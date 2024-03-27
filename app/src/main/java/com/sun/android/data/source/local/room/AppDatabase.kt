package com.sun.android.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sun.android.data.model.Movie
import com.sun.android.utils.Constant

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, Constant.DATABASE_NAME).build().also {
                    instance = it
                }
            }
        }
    }
}
