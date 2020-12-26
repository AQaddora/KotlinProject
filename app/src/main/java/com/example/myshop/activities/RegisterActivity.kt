package com.example.myshop.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myshop.R
import com.example.myshop.models.UserData

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username = findViewById<EditText>(R.id.username_rt)
        val password = findViewById<EditText>(R.id.password_rt)
        val storeName = findViewById<EditText>(R.id.storeName_rt)
        val register = findViewById<Button>(R.id.register)
        register.isEnabled = true
        val sharedPref =
                getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        username.setText(sharedPref.getString(("username"), ""))
        storeName.setText(sharedPref.getString(("storeName"), ""))
        password.setText(sharedPref.getString(("password"), ""))
        register.setOnClickListener {
            UserData.username = username.text.toString()
            UserData.password =  password.text.toString()
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
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}
