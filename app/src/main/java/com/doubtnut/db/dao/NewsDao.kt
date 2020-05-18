package com.doubtnut.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.doubtnut.model.Article


@Dao
interface NewsDao {
    @Insert
    fun saveAndUpdate(news: List<Article>)

    @Query("SELECT * FROM Article")
    fun getAllNews(): List<Article>

    @Query("DELETE FROM Article")
    fun deleteAllNews()
}