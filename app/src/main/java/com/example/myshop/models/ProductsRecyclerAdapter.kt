package com.example.myshop.models

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myshop.R
import com.example.myshop.activities.OneProductActivity
import com.example.myshop.activities.RegisterActivity
import kotlinx.android.synthetic.main.layout_product_card.view.*

class ProductsRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    public var items: List<Product> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_product_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is ProductViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(productList: List<Product>){
        items = productList
    }

    class ProductViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val image = itemView.product_image
        val title = itemView.product_title
        val price = itemView.product_price

        fun bind(product: Product){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(product.image)
                .into(image)
            image.setOnClickListener{
                val intent = Intent(itemView.context, OneProductActivity::class.java)
                intent.putExtra("image", product.image)
                intent.putExtra("title", product.title)
                intent.putExtra("price", product.price)
                itemView.context.startActivity(intent)
            }
            title.setText(product.title)
            price.setText(product.price)
        }
    }
}