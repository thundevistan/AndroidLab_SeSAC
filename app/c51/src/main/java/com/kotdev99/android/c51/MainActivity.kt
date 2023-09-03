package com.kotdev99.android.c51

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.Manifest

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// test2...
		val requestPermissionLauncher = registerForActivityResult(
			ActivityResultContracts.RequestPermission()
		) {
			if (it) {
				Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
			} else {
				Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
			}
		}

		// 퍼미션의 허락/거부 여부 확인
		val status = ContextCompat.checkSelfPermission(
			this,
			"android.permission.ACCESS_FINE_LOCATION"
		)
		if (status == PackageManager.PERMISSION_GRANTED) {
			Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
		}
		// 퍼미션 요청을 위한 시스템 다이얼로그 출력
		else {
			// test1...
//			ActivityCompat.requestPermissions(
//				this,
//				arrayOf<String>("android.permission.ACCESS_FINE_LOCATION"),
//				100
//			)

			// test2...
			requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
		}
	}

	// requestPermissions() 호출 시 자동 콜
	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray
	) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
			Toast.makeText(this, "granted...", Toast.LENGTH_SHORT).show()
		} else {
			Toast.makeText(this, "denied...", Toast.LENGTH_SHORT).show()
		}
	}
}