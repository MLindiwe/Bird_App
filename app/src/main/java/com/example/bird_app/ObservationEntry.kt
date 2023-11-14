package com.example.bird_app

import android.net.Uri

data class ObservationEntry(
    val birdName: String,
    val observationDetails: String,
    val imageUri: Uri?
)


