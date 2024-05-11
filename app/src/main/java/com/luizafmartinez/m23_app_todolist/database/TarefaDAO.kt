package com.luizafmartinez.m23_app_todolist.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.luizafmartinez.m23_app_todolist.model.Tarefa

class TarefaDAO(context: Context) : ITarefaDAO {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(tarefa: Tarefa): Boolean {

        val conteudos = ContentValues()
        conteudos.put("${DatabaseHelper.COLUNA_DESCRICAO}", tarefa.descricao)

        try {
            escrita.insert(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                null,
                conteudos
                )
            Log.i("info_db", "Sucesso ao salvar tarefa")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao salvar tarefa")
            return false
        }
        return true
    }

    override fun atualizar(tarefa: Tarefa): Boolean {


        return true
    }

    override fun remover(idTarefa: Int): Boolean {


    return true

    }

    override fun listar(): List<Tarefa> {

        return emptyList()
    }
/*
        try {
            db?.execSQL( sql )
            Log.i("info_db", "Sucesso ao criar tabela")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao criar tabela")
        }*/
}