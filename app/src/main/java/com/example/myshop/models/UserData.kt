package com.example.myshop.models

import android.app.Application

class UserData : Application() {
    companion object {
        var username = ""
        var password = ""
        var shopName = ""
        fun validate(): Boolean {
            return !(username.isEmpty()|| password.isEmpty() || shopName.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches())
        }
    }
}

