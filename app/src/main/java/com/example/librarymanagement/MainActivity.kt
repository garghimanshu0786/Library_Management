package com.example.librarymanagement

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import com.example.librarymanagement.model.LibraryDetails
import com.example.librarymanagement.view.ScanCodeFragment
import com.example.librarymanagement.viewmodel.ScanCodeViewModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.zxing.integration.android.IntentIntegrator
import java.lang.String
import kotlin.Any
import kotlin.Int
import kotlin.also
import kotlin.getValue
import kotlin.lazy


class MainActivity : AppCompatActivity() {

    private val viewModel: ScanCodeViewModel by lazy {
        ViewModelProvider(this)[ScanCodeViewModel::class.java]
    }

    private lateinit var notificationManager: NotificationManagerCompat
    val channelId = "Progress Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container_layout)
        notificationManager = NotificationManagerCompat.from(this)
        supportFragmentManager.beginTransaction().also {
            val fragment = ScanCodeFragment()
            it.replace(R.id.fragment_container, fragment, fragment.toString())
            it.addToBackStack(null)
            it.commit()
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        // if the intentResult is null then
        // toast a message as "cancelled"
        if (intentResult != null) {
            if (intentResult.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            } else {
                // if the intentResult is not null we'll set
                // the content and format of scan message
                val gson = GsonBuilder()
                    .setLenient() // Set the non-strict mode of GSON setLenient()
                    .create()
                var details =
                    gson.fromJson(
                        JsonParser.parseString(intentResult.contents).asString,
                        LibraryDetails::class.java
                    )
                viewModel.startSession(applicationContext)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    //Start() is called when the buttons is pressed.
    public fun start(){

        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var numMessages = 0
            mNotifyBuilder.setContentText(String.valueOf(timerValue)) // <-- your timer value
            .setNumber(++numMessages)
        // Because the ID remains unchanged, the existing notification is
        // updated.
        // Because the ID remains unchanged, the existing notification is
        // updated.
        mNotificationManager.notify(
            notifyID,  // <-- Place your notification id here
            mNotifyBuilder.build()
        )
    }

//    fun showNotification() {
//        val builder = NotificationCompat.Builder(this, NotificationUtils.CHANNEL_OTHERS)
//        builder.setContentTitle(title)
//            .setContentText(message)
//            // .setSmallIcon(icon)
//            // .setWhen(notificationTimeInMillis)
//            .setColor(ContextCompat.getColor(this, R.color.notification_color))
//            .setStyle(NotificationCompat.BigTextStyle().bigText(message))
//            .setDeleteIntent(dismissIntent)
//    }
}