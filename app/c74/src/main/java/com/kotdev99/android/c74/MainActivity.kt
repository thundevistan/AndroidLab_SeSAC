package com.kotdev99.android.c74

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
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

		// channel 정보 입력
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val channelId = "one-channel"
			val channelName = "My One Channel"
			val channel = NotificationChannel(
				channelId,
				channelName,
				NotificationManager.IMPORTANCE_HIGH
			)

			// channel 에 주는 정보
			channel.description = "My Channel One Description"  // 환경설정에 출력되는 설명
			channel.setShowBadge(true)
			val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
			val audio = AudioAttributes.Builder()
				.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
				.setUsage(AudioAttributes.USAGE_ALARM)
				.build()
			channel.setSound(uri, audio)
			channel.enableLights(true)    // 알림 시에 빛남 (제공 여부는 기종에 따라 다름)
			channel.lightColor = Color.RED      // 불빛 색상
			channel.enableVibration(true)
			channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

			manager.createNotificationChannel(channel)

			builder = NotificationCompat.Builder(this, channelId)
		} else {
			builder = NotificationCompat.Builder(this)
		}
		builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
		builder.setWhen(System.currentTimeMillis())
		builder.setContentTitle("Title")
		builder.setContentText("message")

		manager.notify(1, builder.build())
	}
}