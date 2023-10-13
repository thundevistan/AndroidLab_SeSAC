package com.kotdev99.android.c79

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val btn = findViewById<Button>(R.id.button)
		btn.setOnClickListener {

			// 시스템 서비스 획득
			var scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

			// JobInfo 등록
			JobInfo.Builder(1, ComponentName(this, MyService::class.java)).run {
				setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)  // 와이파이에 붙는 순간 실행
				scheduler.schedule(build())
			}
		}
	}
}