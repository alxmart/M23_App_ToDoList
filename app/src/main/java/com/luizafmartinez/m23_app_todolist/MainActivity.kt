package com.luizafmartinez.m23_app_todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.luizafmartinez.m23_app_todolist.database.TarefaDAO
import com.luizafmartinez.m23_app_todolist.databinding.ActivityMainBinding
import com.luizafmartinez.m23_app_todolist.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var listaTarefas = emptyList<Tarefa>()

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
    }

    override fun onStart() {
        super.onStart()
        val tarefaDAO = TarefaDAO(this)  // ou application context
        listaTarefas = tarefaDAO.listar()

        listaTarefas.forEach { tarefa ->
            Log.i("info_db", "${tarefa.descricao} \n")
        }
    }

}