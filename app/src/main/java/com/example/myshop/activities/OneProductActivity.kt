package com.example.myshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myshop.R
import com.example.myshop.models.Product
import org.w3c.dom.Text

class OneProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_product_screen)

        val image = findViewById<ImageView>(R.id.one_product_image)
        val title = findViewById<TextView>(R.id.one_product_title)
        val price = findViewById<TextView>(R.id.one_product_price)
        val product = Product(
                intent.getStringExtra("title").toString(),
                intent.getStringExtra("price").toString(),
                intent.getStringExtra("image").toString()
        );
        setTitle(product.title)
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load(product.image)
            .into(image)
        title.setText(product.title)
        price.setText(product.price)
    }
}