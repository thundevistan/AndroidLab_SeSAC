package com.kotdev99.android.c81

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

	private lateinit var resultView: TextView
	private lateinit var manager: LocationManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// 멤버변수 초기화
		resultView = findViewById(R.id.resultView)
		manager = getSystemService(LOCATION_SERVICE) as LocationManager

		// 퍼미션 획득
		val launcher = registerForActivityResult(
			ActivityResultContracts.RequestPermission()
		) { isGranted ->
			// 퍼미션 다이얼로그가 닫힌 순간 콜 되는 부분
			if (isGranted) {
				getLocation()
			} else {
				Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
			}
		}

		// 퍼미션 확인
		val status = ContextCompat.checkSelfPermission(
			this,
			"android.permission.ACCESS_FINE_LOCATION"
		)
		if (status == PackageManager.PERMISSION_GRANTED) {
			getLocation()
		} else {
			launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
		}
	}

	// 위치 추적
	private fun getLocation() {
		val location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
		location?.let {
			val latitude = location.latitude
			val longitude = location.longitude
			val accuracy = location.accuracy
			val time = location.time

			resultView.text = "$latitude \n $longitude \n $accuracy \n $time"
		}
	}
}