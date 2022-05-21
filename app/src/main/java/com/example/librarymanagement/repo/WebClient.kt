package com.example.librarymanagement.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {

    var sessionEndAPI: SessionEndAPI = Retrofit.Builder()
        .baseUrl(Constants.baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(SessionEndAPI::class.java)

}