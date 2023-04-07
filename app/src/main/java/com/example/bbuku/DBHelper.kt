package com.example.bbuku

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DBHelper(ctx: Context) : SQLiteOpenHelper(ctx, "Buku.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =  "CREATE TABLE user(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "nama TEXT," +
                "username TEXT," +
                "password TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }

    fun allDataUser() : Cursor{
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM user", null)
    }
}