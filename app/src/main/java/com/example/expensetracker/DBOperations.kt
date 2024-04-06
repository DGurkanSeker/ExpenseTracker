package com.example.expensetracker

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOperations(context : Context) : SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object {
        private const val DB_NAME = "my_database.db"
        private const val DB_VERSION = 1

        // Define table and column names
        const val TABLE_NAME = "my_table"
        const val COLUMN_ID = "id"
        const val COLUMN_PRICE = "price"
        const val COLUMN_NAME = "header"
        const val COLUMN_MONTH = "month"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = """CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COLUMN_NAME TEXT,$COLUMN_MONTH INTEGER,$COLUMN_PRICE INTEGER)""".trimIndent()
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertData(price : Int, header : String, month : Int,) : Long {
        val cv = ContentValues().apply {

            this.put(COLUMN_NAME, header)
            this.put(COLUMN_MONTH, month)
            this.put(COLUMN_PRICE, price)

            return writableDatabase.insert(TABLE_NAME, null, this)
        }
    }
    fun readData(): List<DataModel> {
        val datalist = mutableListOf<DataModel>()
        val cursor: Cursor = readableDatabase.query(TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val header = getString(getColumnIndexOrThrow(COLUMN_NAME))
                val price = getInt(getColumnIndexOrThrow(COLUMN_PRICE))
                val month = getInt(getColumnIndexOrThrow(COLUMN_MONTH))
                datalist.add(DataModel(id, header, price, month))
            }
        }
        cursor.close()
        return datalist
    }
}