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


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username_login)
        val password = findViewById<EditText>(R.id.password_login)
        val login = findViewById<Button>(R.id.login)
        username.setText(UserData.username)
        password.setText(UserData.password)
        login.isEnabled = true
        login.setOnClickListener {
            if(username.text.toString().equals(UserData.username)
                && password.text.toString().equals(UserData.password)){
                startActivity(Intent(this, CategoriesActivity::class.java))
            }else{
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}