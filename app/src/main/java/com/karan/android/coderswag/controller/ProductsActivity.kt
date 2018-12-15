package com.karan.android.coderswag.controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.karan.android.coderswag.R
import com.karan.android.coderswag.adapters.ProductsAdapter
import com.karan.android.coderswag.services.DataService
import com.karan.android.coderswag.utilities.EXTRA_CATEGORY
import com.karan.android.coderswag.utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryName = intent.getStringExtra(EXTRA_CATEGORY)

        productsAdapter = ProductsAdapter(this,DataService.getProducts(categoryName)){product ->
            val intent = Intent(this,ProductDetailActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT,product)
            startActivity(intent)

        }
        productsItemView.adapter = productsAdapter

        var spanCount = 2

        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount=3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize >= 720){
            spanCount=3
        }

        productsItemView.layoutManager = GridLayoutManager(this,spanCount)

        productsItemView.setHasFixedSize(true)



    }
}
