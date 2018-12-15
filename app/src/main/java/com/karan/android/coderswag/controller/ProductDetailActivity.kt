package com.karan.android.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.karan.android.coderswag.R
import com.karan.android.coderswag.model.Product
import com.karan.android.coderswag.utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = this.resources.getIdentifier(product.image,"drawable",this.packageName)
        detail_productImage.setImageResource(resourceId)
        detail_productName.text = product.title
        detail_productPrice.text = product.price
    }

    fun onClickCartBtn(view: View){
        Toast.makeText(this,"Product Added to Cart",Toast.LENGTH_SHORT).show()
    }
}
