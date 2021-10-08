package com.example.company.myapplication

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var send_notification = findViewById<Button>(R.id.send_notification)


        send_notification.setOnClickListener {
            val intent = Intent(this, FinishActivity::class.java)

            val resultIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            var builder = NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.alert_dark_frame)
                    .setContentTitle("Title")
                    .setContentText("Text")
                    .setContentIntent(resultIntent)
                    .setAutoCancel(true)

            val notification = builder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(1, notification)

            //   notificationManager.cancel(1)
            //   notificationManager.cancelAll()


        }
    }
}
