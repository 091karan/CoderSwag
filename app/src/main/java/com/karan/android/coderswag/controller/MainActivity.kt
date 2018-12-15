package com.karan.android.coderswag.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.karan.android.coderswag.R
import com.karan.android.coderswag.adapters.CategoryAdapter
import com.karan.android.coderswag.adapters.CategoryRecyclerAdapter
import com.karan.android.coderswag.services.DataService
import com.karan.android.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this,DataService.categories){ category ->
            val intent = Intent(this,ProductsActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(intent)
        }
        listItemView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        listItemView.layoutManager = layoutManager

        listItemView.setHasFixedSize(true)

    }
}
