package com.example.assms.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.assms.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        var handler = Handler()
        handler.postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },2000)
    }
}