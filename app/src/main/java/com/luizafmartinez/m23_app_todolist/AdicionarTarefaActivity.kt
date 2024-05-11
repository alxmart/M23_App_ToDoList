package com.luizafmartinez.m23_app_todolist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m23_app_todolist.database.TarefaDAO
import com.luizafmartinez.m23_app_todolist.databinding.ActivityAdicionarTarefaBinding
import com.luizafmartinez.m23_app_todolist.databinding.ActivityMainBinding
import com.luizafmartinez.m23_app_todolist.model.Tarefa

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener {

            if ( binding.editTarefa.text.isNotEmpty() ) {
                val descricao = binding.editTarefa.text.toString()
                val tarefa = Tarefa(
                    -1,
                    descricao,
                    "default"
                )

                val tarefaDao = TarefaDAO(this)
                if ( tarefaDao.salvar(tarefa) ) {
                    Toast.makeText(this,
                        "Tarefa cadastrada com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                } else {
                    Toast.makeText(this,
                        "Erro ao cadastrar tarefa",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                Toast.makeText(this,
                    "Preencha uma tarefa",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }



    }
}