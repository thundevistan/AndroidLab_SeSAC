package com.kotdev99.android.c25

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private var pauseTime = 0L

	private lateinit var start: Button
	private lateinit var stop: Button
	private lateinit var reset: Button
	private lateinit var chronometer: Chronometer

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		start = findViewById(R.id.btn_start)
		stop = findViewById(R.id.btn_stop)
		reset = findViewById(R.id.btn_reset)
		chronometer = findViewById(R.id.chronometer)

		start.setOnClickListener {
			chronometer.base = SystemClock.elapsedRealtime() + pauseTime
			chronometer.start()

			start.isEnabled = false
			stop.isEnabled = true
			reset.isEnabled = true
		}
		stop.setOnClickListener {
			pauseTime = chronometer.base - SystemClock.elapsedRealtime()
			chronometer.stop()

			start.isEnabled = true
			stop.isEnabled = false
			reset.isEnabled = true
		}
		reset.setOnClickListener {
			pauseTime = 0L
			chronometer.base = SystemClock.elapsedRealtime()
			chronometer.stop()

			start.isEnabled = true
			stop.isEnabled = false
			reset.isEnabled = false
		}
	}
}