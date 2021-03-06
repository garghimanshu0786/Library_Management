package com.example.librarymanagement.model

import com.google.gson.annotations.SerializedName

class LibraryDetails(
    @SerializedName("location_id")
    val locationId: String,

    @SerializedName("location_details")
    val locationDetails: String,

    @SerializedName("price_per_min")
    val pricePerMin: Float
)