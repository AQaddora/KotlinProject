package com.example.myshop.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.myshop.R
import com.example.myshop.models.Product
import com.example.myshop.models.ProductPopulate

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        val title = findViewById<EditText>(R.id.product_title_addProductScreen)
        val imageUrl = findViewById<EditText>(R.id.product_image_addProductScreen)
        val price = findViewById<EditText>(R.id.product_price_addProductScreen)
        val addProductBtn = findViewById<Button>(R.id.add_product_button_addProductScreen)
        val category = intent.getStringExtra("category")
        addProductBtn.setOnClickListener {
            if(title.text.toString().isNullOrEmpty() || price.text.toString().isNullOrEmpty() || imageUrl.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Please fill in correct data", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            when(category) {
                "Food" -> ProductPopulate.added_food.add(Product(title.text.toString(), price.text.toString(), imageUrl.text.toString()))
                "House appliances" -> ProductPopulate.added_ha.add(Product(title.text.toString(), price.text.toString(), imageUrl.text.toString()))
                "Toys" -> ProductPopulate.added_toys.add(Product(title.text.toString(), price.text.toString(), imageUrl.text.toString()))
            }
            startActivity(Intent(this, ProductsActivity::class.java).putExtra("category",category))
        }
    }
}