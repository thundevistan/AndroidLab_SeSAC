package com.kotdev99.android.c79

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyService : JobService() {

	override fun onCreate() {
		super.onCreate()
		Log.d("JobService", "MyService...onCreate...")      // 서비스 구동 확인
	}

	override fun onStartJob(p0: JobParameters?): Boolean {
		Log.d("JobService", "MyService...onStartJob...")
		return false
	}

	override fun onStopJob(p0: JobParameters?): Boolean {
		Log.d("JobService", "MyService...onStopJob...")
		return false
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d("JobService", "MyService...onDestroy...")     // 서비스 종료 확인
	}
}