package com.example.librarymanagement

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class App : Application() {
    private val channelId = "Progress Notification"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        val channel1 = NotificationChannel(
            channelId,
            "Progress Notification",
            //IMPORTANCE_HIGH = shows a notification as peek notification.
            //IMPORTANCE_LOW = shows the notification in the status bar.
            NotificationManager.IMPORTANCE_HIGH
        )
        channel1.description = "Progress Notification Channel"
        val manager = getSystemService(
            NotificationManager::class.java
        )
        manager.createNotificationChannel(channel1)
    }
}
