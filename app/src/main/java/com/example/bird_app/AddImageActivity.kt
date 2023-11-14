package com.example.bird_app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddImageActivity : AppCompatActivity() {
    private lateinit var btnChooseImage: Button
    private lateinit var imgSelected: ImageView
    private lateinit var etBirdName: EditText
    private lateinit var etObservationDetails: EditText

    private val PICK_IMAGE_REQUEST = 1


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)
        val sharedpreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)

        btnChooseImage = findViewById(R.id.btnChooseImage)
        imgSelected = findViewById(R.id.imgSelected)
        etBirdName = findViewById(R.id.etBirdName)
        etObservationDetails = findViewById(R.id.etObservationDetails)

        val getBirdName = sharedpreference.getString("BIRDNAME", "")
        val getObservationEntry = sharedpreference.getString("OBSERVATIONDETAILS", "")


        btnChooseImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)

        }

        findViewById<Button>(R.id.btnSaveEntry).setOnClickListener {

            val birdName = etBirdName.text.toString()
            val observationDetails = etObservationDetails.text.toString()
            val selectedImageUri = imgSelected.toString()

            val editor = sharedpreference.edit()
            editor.putString("BIRDNAME",birdName)
            editor.putString("OBSERVATIONDETAILS", observationDetails )
            editor.putString("SELECTEDIMAGEURI", selectedImageUri )
            editor.apply()


            if(birdName==null && observationDetails==null){
                // Display an error message if required fields are empty
                Toast.makeText(this, "Item is empty", Toast.LENGTH_SHORT).show();

            }
            else if (birdName.isNotEmpty() && observationDetails.isNotEmpty()) {
                // Save the observation entry to your data storage (e.g., database, file, etc.)
                Toast.makeText(this, "Item has been added", Toast.LENGTH_SHORT).show();

            }

            val i = Intent(this, birdlisting::class.java)
            startActivity(i)
        }
    }


    private var selectedImageUri: Uri? = null

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            imgSelected.setImageURI(selectedImageUri)
        }
    }


}