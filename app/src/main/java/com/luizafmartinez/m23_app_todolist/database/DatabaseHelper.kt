package com.luizafmartinez.m23_app_todolist.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, NOME_BANCO_DADOS, null, VERSAO
) {
    companion object {
        const val NOME_BANCO_DADOS  = "ListaTarefas.db"
        const val VERSAO = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {


    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int) {

    }
}