package com.example.task2app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.btn_login)
        loginButton.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}
