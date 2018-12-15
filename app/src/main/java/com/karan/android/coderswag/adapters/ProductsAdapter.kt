package com.karan.android.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.karan.android.coderswag.R
import com.karan.android.coderswag.model.Product
import kotlinx.android.synthetic.main.products_list_item.view.*
import java.text.FieldPosition

class ProductsAdapter(val context: Context,val products: List<Product>,val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.products_list_item,parent,false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(products[position],context)
    }

    inner class Holder(itemView: View,val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView){
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productName = itemView.findViewById<TextView>(R.id.productName)
        val productPrice = itemView.findViewById<TextView>(R.id.productCost)

        fun bindProduct(product: Product,context: Context){
            val imageResourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage.setImageResource(imageResourceId)
            productName.text = product.title
            productPrice.text = product.price
            itemView.setOnClickListener {
                itemClick(product)
            }
        }

    }

}