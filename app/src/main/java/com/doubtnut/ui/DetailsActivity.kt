package com.doubtnut.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doubtnut.R
import com.doubtnut.utils.loadImage
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initView()
        initParse()
    }

    private fun initView() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initParse() {
        tv_title.text = intent?.getStringExtra("title")?:""
        tv_desc.text = intent?.getStringExtra("desc")?:"N.A"
        iv_news.loadImage(intent?.getStringExtra("image_url")?:"N.A")
    }


}
