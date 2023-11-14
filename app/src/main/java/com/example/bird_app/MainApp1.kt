package com.example.bird_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainApp1 : AppCompatActivity() {



    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app1)

        val birdlist = findViewById<ImageView>(R.id.birdlist)
        birdlist.setOnClickListener {
            val intent1 = Intent(this, birdlisting::class.java)
            //call the intent
            startActivity(intent1)

        }

        //  stare btn intent
        val share = findViewById<ImageView>(R.id.share)
        share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Check out this birdobservation app:")
            shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+ applicationContext.packageName)
            startActivity(Intent.createChooser(shareIntent, "Share via: "))
        }



        //back btn intent to the main activity
        val backbtn = findViewById<ImageView>(R.id.backbtn)
        backbtn.setOnClickListener {
            val intent1 = Intent(this@MainApp1, MainActivity::class.java)
            //call the intent
            startActivity(intent1)

        }

        //  entry btn intent to the add image activity
        val btnentry = findViewById<Button>(R.id.btnentry)
        btnentry.setOnClickListener {
            val intent1 = Intent(this, AddImageActivity::class.java)
            //call the intent
            startActivity(intent1)

        }


    }



    }