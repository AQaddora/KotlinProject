package com.example.myshop.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.myshop.R
import com.example.myshop.models.UserData

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val username = findViewById<EditText>(R.id.username_edit)
        val password = findViewById<EditText>(R.id.password_edit)
        val storeName = findViewById<EditText>(R.id.storeName_edit)
        val edit = findViewById<Button>(R.id.edit)
        edit.isEnabled = true
        username.setText(UserData.username)
        password.setText(UserData.password)
        storeName.setText(UserData.shopName)

        edit.setOnClickListener {
            UserData.username = username.text.toString()
            UserData.password = password.text.toString()
            UserData.shopName = storeName.text.toString()
            if(!UserData.validate()) {
                Toast.makeText(this, "Please fill in your data", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val sharedPref =
                getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("username", username.text.toString())
            editor.putString("storeName", storeName.text.toString())
            editor.putString("password", password.text.toString())
            editor.apply()
            editor.commit()
            startActivity(Intent(this, CategoriesActivity::class.java))
        }
    }
}