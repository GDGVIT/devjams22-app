package com.dscvit.devjams22.notification

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.dscvit.devjams22.R
import com.dscvit.devjams22.presentation.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("push notification from: ", message.from.toString())

        if (message.data.isNotEmpty()) {
            Log.d("push notification: ", message.data.toString())
        }

        message.data.let {
            Log.d("push notification", "${it["body"]}")
            Log.d("push notification", "${it["title"]}")

            showNotification(it)
        }

        if (message.notification != null) {
            Log.d("push notification", "Notification ${message.notification}")
            Log.d("push notification", "Title ${message.notification?.title}")
            Log.d("push notification", "Body     ${message.notification?.body}")
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun showNotification(data: Map<String, String>) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags =
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP

        }
        intent.putExtra("title", data["title"])
        intent.putExtra("body", data["body"])

        var requestCode = System.currentTimeMillis().toInt()
        var pendingIntent: PendingIntent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pendingIntent =
                PendingIntent.getActivity(this, requestCode, intent, PendingIntent.FLAG_MUTABLE)
        } else {
            pendingIntent =
                PendingIntent.getActivity(
                    this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_CANCEL_CURRENT
                )

        }

        val builder = NotificationCompat.Builder(this, "Global").setAutoCancel(true)
            .setContentTitle(data["title"])
            .setContentText(data["body"])
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(NotificationCompat.BigTextStyle().bigText((data[""])))
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.devjams)
        with(NotificationManagerCompat.from(this)) {
            notify(requestCode, builder.build())
        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        GlobalScope.launch {
            saveGCMToken(token)

        }
    }

    private suspend fun saveGCMToken(token: String) {
        val gckTokenKey = stringPreferencesKey("gcm_token")
        baseContext.dataStore.edit { pref ->
            pref[gckTokenKey] = token
        }

    }


}