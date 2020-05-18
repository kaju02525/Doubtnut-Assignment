package com.doubtnut.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    var articles: List<Article>? = null,
    var status: String? = null
)

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id:Int= 0,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var urlToImage: String? = null
)