package com.example.librarymanagement.repo

import com.example.librarymanagement.model.SessionEndDetails
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IRepository {

    @Headers("Content-Type: application/json")
    @POST("users")
    suspend fun endSession(@Body sessionEndDetails: SessionEndDetails): Call<SessionEndDetails>
    //  suspend fun getPullRequests(dispatcher: CoroutineDispatcher): List<PullRequest>?
}