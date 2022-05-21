package com.example.librarymanagement.repo

import com.example.librarymanagement.model.SessionEndDetails
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SessionEndAPI {

    @Headers("Content-Type: application/json")
    @POST(Constants.endSessionEndPoint)
    suspend fun endSession(@Body sessionEndDetails: SessionEndDetails): Response<SessionEndDetails>
}