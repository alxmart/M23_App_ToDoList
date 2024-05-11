package com.luizafmartinez.m23_app_todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luizafmartinez.m23_app_todolist.databinding.ItemTarefaBinding
import com.luizafmartinez.m23_app_todolist.model.Tarefa

class TarefaAdapter() : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listaTarefas: List<Tarefa> = emptyList()

    fun adicionarLista( lista: List<Tarefa>) {
        this.listaTarefas = lista
        notifyDataSetChanged()
    }

    inner class TarefaViewHolder(itemBinding: ItemTarefaBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        private val binding: ItemTarefaBinding

        init {
            binding = itemBinding
        }

        fun bind( tarefa: Tarefa){
            binding.textDescricao.text = tarefa.descricao
            binding.textData.text = tarefa.dataCadastro
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTarefaBinding = ItemTarefaBinding.inflate(
            layoutInflater, parent, false
        )
        return TarefaViewHolder(itemTarefaBinding)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefas[position]
        holder.bind()
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

}