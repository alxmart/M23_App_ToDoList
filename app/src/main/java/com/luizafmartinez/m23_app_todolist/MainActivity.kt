package com.luizafmartinez.m23_app_todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.luizafmartinez.m23_app_todolist.adapter.TarefaAdapter
import com.luizafmartinez.m23_app_todolist.database.TarefaDAO
import com.luizafmartinez.m23_app_todolist.databinding.ActivityMainBinding
import com.luizafmartinez.m23_app_todolist.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var listaTarefas = emptyList<Tarefa>()
    private var tarefaAdapter: TarefaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabAdicionar.setOnClickListener {
            val intent = Intent(
                this,
                AdicionarTarefaActivity::class.java
            )
            startActivity(intent)
        }

        // RecyclerView
        tarefaAdapter = TarefaAdapter()

        binding.rvTarefas.adapter = tarefaAdapter

        binding.rvTarefas.layoutManager = LinearLayoutManager(this)
    }

    private fun atualizarListaTarefas() {
        val tarefaDAO = TarefaDAO(this)  // ou application context
        listaTarefas = tarefaDAO.listar()
        tarefaAdapter?.adicionarLista(listaTarefas)
    }

    override fun onStart() {
        super.onStart()
        atualizarListaTarefas()
    }

}