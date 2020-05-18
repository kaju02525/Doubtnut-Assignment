package com.doubtnut.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.doubtnut.R
import com.doubtnut.model.Article
import com.doubtnut.mvvm.MainViewModel
import com.doubtnut.utils.showSnack
import kotlinx.android.synthetic.main.activity_news_list.*
import org.koin.android.viewmodel.ext.android.viewModel


class NewsListActivity : AppCompatActivity() {

    private val newsViewModel: MainViewModel by viewModel()
    var newsList = mutableListOf<Article>()
    private lateinit var mNewsListAdapter:NewsListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setUpUI()
        setupViewModel()
    }

    private fun setupViewModel(){
        newsViewModel.getNewsData().observe(this, Observer {
            if(it!=null) {
                progressHideShow(false)
                newsList = it as MutableList<Article>
                Log.d("TAGS", "setupViewModel: List Size: ${newsList.size} ")
                notifyAdapter()
            }
        })

        newsViewModel.getErrorMessage().observe(this, Observer {
            progressHideShow(false)
            showSnack(it)
        })
    }

    private fun setUpUI(){
        rv_news_list.run{ layoutManager = LinearLayoutManager(this@NewsListActivity)
               addItemDecoration( DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
    }}

    private fun notifyAdapter(){
        mNewsListAdapter=NewsListAdapter(newsList)
        rv_news_list.adapter = mNewsListAdapter
        mNewsListAdapter.notifyDataSetChanged()
    }

    private fun progressHideShow(flag:Boolean){
        if(flag){
            progress_circular.visibility=View.VISIBLE
        }else{
            progress_circular.visibility=View.GONE
        }
    }

}
