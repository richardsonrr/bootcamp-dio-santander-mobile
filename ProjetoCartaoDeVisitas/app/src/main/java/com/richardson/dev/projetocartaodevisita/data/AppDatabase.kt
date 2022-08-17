package com.richardson.dev.projetocartaodevisita.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun businessDao():BusinessCardDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context):AppDatabase{
            return  INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                   "businessCard db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}