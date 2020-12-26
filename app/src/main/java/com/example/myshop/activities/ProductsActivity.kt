package com.example.myshop.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.R
import com.example.myshop.models.*
import kotlinx.android.synthetic.main.activity_products.*


class ProductsActivity: AppCompatActivity() {
    private lateinit var productsAdapter: ProductsRecyclerAdapter
    var category = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        category = intent.getStringExtra("category").toString()
        setTitle(UserData.shopName + ", " + category)
        val searchInput = findViewById<EditText>(R.id.searchKeyword)
        val addProduct = findViewById<Button>(R.id.add_product_button)
        addProduct.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            intent.putExtra("category", category)
            startActivity(intent)
        }
        searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                    search(s.toString())
            }
        })
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@ProductsActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
        }
        initRecyclerView()
        addDataSet()
    }
    private fun search(keyword: String){
        productsAdapter.items = ArrayList<Product>()
        for (item in ProductPopulate.list) {
            if(item.title.toLowerCase().startsWith(keyword.toLowerCase())){
                productsAdapter.items+=item
            }else if(!productsAdapter.items.contains(item) && item.title.toLowerCase().contains(keyword.toLowerCase())){
                productsAdapter.items+=item
            }
        }
        productsAdapter.notifyDataSetChanged()
    }
    private fun addDataSet(){
        var currentList = ArrayList<Product>()
        when(category) {
            "Food" -> currentList = ProductPopulate.CreateFoodList()
            "House appliances" -> currentList = ProductPopulate.CreateHaList()
            "Toys" -> currentList = ProductPopulate.CreateToysList()
        }
        productsAdapter.submitList(currentList)
    }
    private fun initRecyclerView(){
        recycler_view.apply {
            productsAdapter = ProductsRecyclerAdapter()
            adapter = productsAdapter
        }
    }
}