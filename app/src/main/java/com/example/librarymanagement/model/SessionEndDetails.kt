package com.example.librarymanagement.model

import com.google.gson.annotations.SerializedName

class SessionEndDetails(
    @SerializedName("location_id")
    val locationId: String,

    @SerializedName("time_spent")
    val timeSpent: Int,

    @SerializedName("end_time")
    val endTime: Long
)