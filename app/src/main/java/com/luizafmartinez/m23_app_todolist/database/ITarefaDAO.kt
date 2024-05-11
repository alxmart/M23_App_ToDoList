package com.luizafmartinez.m23_app_todolist.database

import com.luizafmartinez.m23_app_todolist.model.Tarefa

interface ITarefaDAO {

    fun salvar( tarefa: Tarefa ) : Boolean

    fun atualizar( tarefa: Tarefa ) : Boolean

    fun remover( idTarefa: Int ) : Boolean

    fun listar() : List<Tarefa>

}