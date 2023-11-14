package com.example.bird_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





//intent to the login page
        val getstartedbtn = findViewById<Button>(R.id.getstartedbtn)
        getstartedbtn.setOnClickListener {
            val intent1 = Intent(this@MainActivity, LoginScreen::class.java)
            //call the intent
            startActivity(intent1)

        }


        //temporary login to main page
        val btnlogdirect = findViewById<Button>(R.id.btnlogdirect)
        btnlogdirect.setOnClickListener {
            val tempintent = Intent(this@MainActivity,MainApp1::class.java)
            //call the intent
            startActivity(tempintent)

        }


















    }
}