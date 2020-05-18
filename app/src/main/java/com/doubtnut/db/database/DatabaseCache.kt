package com.doubtnut.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.doubtnut.App
import com.doubtnut.db.dao.NewsDao
import com.doubtnut.model.Article
import com.doubtnut.network.Const.db_name

@Database(entities = [Article::class], version = 1)
abstract class DatabaseCache : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseCache? = null
       fun getInstance(): DatabaseCache =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(App.appContext!!).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            databaseBuilder(context.applicationContext, DatabaseCache::class.java, db_name).build()
    }
}