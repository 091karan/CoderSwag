package com.karan.android.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.karan.android.coderswag.R
import com.karan.android.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryName = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryName)
    }
}
