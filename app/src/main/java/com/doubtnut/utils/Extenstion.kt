package com.doubtnut.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.doubtnut.R
import com.google.android.material.snackbar.Snackbar


fun log(s:String){
    Log.d("TAGS", "log: $s")
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.showSnack(message: String): Snackbar {
    val sb = Snackbar.make((this as Activity).findViewById<View>(android.R.id.content), message, Snackbar.LENGTH_LONG)
    sb.view.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    val textView = sb.view.findViewById<TextView>(R.id.snackbar_text)
    textView.setTextColor(Color.RED)
    sb.show()
    return sb
}

fun ImageView.loadImage(url:String){
    Glide.with(context)
        .load(url)
        .into(this)
}

