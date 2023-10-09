package com.kotdev99.android.c75

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

	private lateinit var btn: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		btn = findViewById(R.id.button)
		btn.setOnClickListener {
			initNotification()
		}
	}

	private fun initNotification() {
		val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
		val builder: NotificationCompat.Builder

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val channelId = "one"
			val channelName = "channel name"
			val channel = NotificationChannel(
				channelId,
				channelName,
				NotificationManager.IMPORTANCE_HIGH
			)

			channel.description = "one description"
			manager.createNotificationChannel(channel)

			builder = NotificationCompat.Builder(this, channelId)
		} else {
			builder = NotificationCompat.Builder(this)
		}

		builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
		builder.setWhen(System.currentTimeMillis())
		builder.setContentTitle("Title")
		builder.setContentText("Text")

		pendingIntent(builder)
		manager.notify(1, builder.build())
	}

	private fun pendingIntent(builder: NotificationCompat.Builder) {

		// 알림 PendingIntent
		val actionIntent = Intent(this, DetailActivity::class.java)
		val actionPending =
			PendingIntent.getActivity(
				this, 20, actionIntent,
				PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
			)
		builder.setContentIntent(actionPending)

		// Action PendingIntent
		val actionIntent2 = Intent(this, DetailActivity::class.java)
		val actionPending2 =
			PendingIntent.getActivity(
				this, 20, actionIntent2,
				PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
			)
		builder.addAction(
			NotificationCompat.Action.Builder(
				android.R.drawable.stat_notify_more,
				"Action",
				actionPending2
			).build()
		)

		// BigPicture Style
		val bigPicture = BitmapFactory.decodeResource(resources, R.drawable.logo_1)
		val style = NotificationCompat.BigPictureStyle()
		style.bigPicture(bigPicture)
		builder.setStyle(style)
	}
}