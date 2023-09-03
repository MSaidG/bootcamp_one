package com.msgulberk.bootcamp_one.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ogrenci::class], version = 1)
abstract class BtkDatabase: RoomDatabase() {

    abstract fun ogrenciDAO(): OgrenciDAO

    companion object {
        private var instance: BtkDatabase? = null

        fun getBtkDatabase(context: Context): BtkDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context,BtkDatabase::class.java,"btk.db").allowMainThreadQueries().build()
            }

            return instance as BtkDatabase
        }

    }
}