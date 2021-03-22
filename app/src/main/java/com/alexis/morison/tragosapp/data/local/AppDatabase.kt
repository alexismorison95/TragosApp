package com.alexis.morison.tragosapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexis.morison.tragosapp.data.model.DrinkEntity

@Database(entities = [DrinkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinksDao

    companion object {

        private var instanceDatabase: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            instanceDatabase = instanceDatabase ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "my_database_name"
            ).build()

            return instanceDatabase!!
        }

        fun destroyInstanceDatabase() {

            instanceDatabase = null
        }
    }
}