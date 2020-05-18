package com.doubtnut.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.doubtnut.R
import com.doubtnut.model.Article
import com.doubtnut.utils.loadImage
import kotlinx.android.synthetic.main.adapter_news_list.view.*

class NewsListAdapter (var list: List<Article>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_news_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val context: Context =itemView.context
        fun bindItems(model: Article) {
            itemView.apply {
                iv_news.loadImage(model.urlToImage?:"")
                tv_title.text = model.title?:"N.A"
                tv_desc.text = model.description?:"N.A"
            }.setOnClickListener {
                val sharedIntent = Intent(context, DetailsActivity::class.java)
                   .putExtra("image_url",model.urlToImage)
                   .putExtra("title",model.title)
                   .putExtra("desc",model.description)
                val pair1 = Pair.create(itemView.iv_news as View, "iv_news")
                val pair2 = Pair.create(itemView.tv_title as View, "tv_title")
                val pair3 = Pair.create(itemView.tv_desc as View, "tv_desc")
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, pair1, pair2,pair3)
                context.startActivity(sharedIntent, options.toBundle())

            }
        }
    }

}