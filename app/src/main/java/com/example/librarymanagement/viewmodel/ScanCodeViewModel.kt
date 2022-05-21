package com.example.librarymanagement.viewmodel

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarymanagement.R
import com.example.librarymanagement.model.SessionEndDetails
import com.example.librarymanagement.repo.SessionRepository
import kotlinx.coroutines.launch

class ScanCodeViewModel : ViewModel() {
    fun startSession(context: Context) {
        Session(context).setUsername("new_session")
    }

    private val repository: SessionRepository
        get() = SessionRepository()

    private val _endSessionDetails = MutableLiveData<SessionEndDetails>()

    val endSessionDetails: LiveData<SessionEndDetails>
        get() = _endSessionDetails

    init {
        viewModelScope.launch {
            val a = SessionEndDetails(
                "ButterKnifeLib-1234",
                60,
                1599467709991
            )
            val b = repository.endSession(a)
            _endSessionDetails.postValue(b)
        }
    }


}