package com.test.enmatest.ui.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.enmatest.R
import com.test.enmatest.data.network.model.Category
import com.test.enmatest.util.loadImage
import kotlinx.android.synthetic.main.category_item.view.*

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesVH>() {

    private val items: ArrayList<Category> = ArrayList()

    private var callback: CategoriesAdapter.Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesVH = CategoriesVH(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoriesVH, position: Int) {
        holder.onBind(items[position])
    }

    fun addItems(data: List<Category>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClick(category: Category)
    }

    fun setCallback(callback: CategoriesAdapter.Callback?) {
        this.callback = callback
    }

    fun removeCallback() {
        this.callback = null
    }

    inner class CategoriesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(category: Category) {
            itemView.categoryIV.loadImage(category.image)
            itemView.categoryTV.text = category.name
        }
        init {
            itemView.setOnClickListener {
                callback?.onItemClick(category = items[adapterPosition])
            }
        }
    }

}