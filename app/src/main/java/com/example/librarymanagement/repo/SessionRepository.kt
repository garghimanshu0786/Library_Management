package com.example.librarymanagement.repo

import android.util.Log
import com.example.librarymanagement.model.SessionEndDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class SessionRepository {
    private val TAG = this.javaClass.name
    private val sessionEndAPI = WebClient.sessionEndAPI

    suspend fun endSession(
        sessionEndDetails: SessionEndDetails,
        dispatcher: CoroutineDispatcher = IO
    ): SessionEndDetails? =
        withContext(dispatcher) {
            try {
                val response =
                    sessionEndAPI.endSession(sessionEndDetails)
                Log.d(TAG, "Success ${response.body().toString()}")
                response.body()
            } catch (ex: Exception) {
                Log.e(TAG, "Error while sending session details $ex")
                null
            }
        }
}
