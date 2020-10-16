package com.lazday.kotlinandroidretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    private val intentTitle = intent.getStringExtra("intent_title")
    private val intentImage = intent.getStringExtra("intent_title")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}