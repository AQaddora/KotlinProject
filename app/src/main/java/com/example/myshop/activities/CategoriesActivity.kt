package com.example.myshop.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.myshop.R
import com.example.myshop.models.UserData

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setTitle(UserData.shopName)
        val editBtn = findViewById<Button>(R.id.edit_Profile_Catagories)
        val foodBtn = findViewById<Button>(R.id.food)
        val haBtn = findViewById<Button>(R.id.ha)
        val toysBtn = findViewById<Button>(R.id.toys)

        var intent = Intent(this@CategoriesActivity, ProductsActivity::class.java)
        var category = ""
        editBtn.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
        foodBtn.setOnClickListener {
            category = "Food"
            intent.putExtra("category", category)
            startActivity(intent)
        }
        haBtn.setOnClickListener {
            category = "House appliances"
            intent.putExtra("category", category)
            startActivity(intent)
        }
        toysBtn.setOnClickListener {
            category = "Toys"
            intent.putExtra("category", category)
            startActivity(intent)
        }
    }
}