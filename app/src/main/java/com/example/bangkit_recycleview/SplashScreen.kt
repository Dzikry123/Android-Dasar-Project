package com.example.bangkit_recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finish the current activity
        }, 3000)
    }
}