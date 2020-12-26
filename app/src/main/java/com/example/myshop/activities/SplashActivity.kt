package com.example.myshop.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import com.example.myshop.R
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer("SettingUp", false).schedule(3000) {
            startActivity(Intent(this@SplashActivity, RegisterActivity::class.java))
        }
    }
}