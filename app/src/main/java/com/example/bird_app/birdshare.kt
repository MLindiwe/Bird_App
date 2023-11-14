package com.example.bird_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class birdshare  : AppCompatActivity() {
    private lateinit var observationEntry: ObservationEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birdshare)

        //intent back to listing
        val backbtnT = findViewById<ImageView>(R.id.backbtnT)
        backbtnT.setOnClickListener {
            val intent1 = Intent(this, birdlisting::class.java)
            //call the intent
            startActivity(intent1)

        }
        // Get the observation entry data from your data storage, for example
         // Retrieve entry based on the selected entry ID

        val btnShare = findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener {


        }
    }

}
