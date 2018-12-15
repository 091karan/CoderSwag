package com.karan.android.coderswag.services

import com.karan.android.coderswag.model.Category
import com.karan.android.coderswag.model.Product

object DataService {

    val categories = listOf(
        Category("Shirts","shirtimage"),
        Category("Hoodies","hoodieimage"),
        Category("Hats","hatimage"),
        Category("Digital","digitalgoodsimage")
    )

    val hats = listOf(
        Product("Hat Black","hat1","$20"),
        Product("Hat White","hat2","$22"),
        Product("Hat Red","hat3","$18"),
        Product("Hat Blue","hat4","$20")
    )

    val hoodies = listOf(
        Product("Hoodie Black","hoodie1","$30"),
        Product("Hoodie Blue","hoodie2","$31"),
        Product("Hoodie White","hoodie3","$28"),
        Product("Hoodie Red","hoodie4","$32")
    )

    val shirts = listOf(
        Product("Shirt Black","shirt1","$25"),
        Product("Shirt Blue","shirt2","$20"),
        Product("Shirt Green","shirt3","$22"),
        Product("Shirt White","shirt4","$25"),
        Product("Shirt Red","shirt5","$27")
    )

    val digitalGoods = listOf<Product>()

    fun getProducts(categoryName : String): List<Product>{
        return when(categoryName){
            "Shirts" -> shirts
            "Hoodies" -> hoodies
            "Hats" -> hats
            else -> digitalGoods
        }
    }

}