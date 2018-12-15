package com.karan.android.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.karan.android.coderswag.R
import com.karan.android.coderswag.model.Category

class CategoryAdapter(val context : Context, val categories: List<Category>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parentView: ViewGroup?): View {
        val categoryView : View
        val holder: ViewHolder

        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
        }
        else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
        val imageResourceId = context.resources.getIdentifier(categories[position].image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(imageResourceId)
        holder.categoryName?.text = categories[position].title
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder{
        var categoryName: TextView? = null
        var categoryImage: ImageView? = null
    }
}