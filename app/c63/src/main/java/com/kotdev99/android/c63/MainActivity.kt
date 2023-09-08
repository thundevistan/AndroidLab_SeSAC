package com.kotdev99.android.c63

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val button = findViewById<Button>(R.id.button)
		val resultView = findViewById<TextView>(R.id.resultView)

		val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
			ActivityResultContracts.StartActivityForResult()
		) {
			// 주소록에서 되돌아 오면 실행 되는 부분
			val cursor = contentResolver.query(
				it.data!!.data!!,   // ContentProvider 및 유저의 식별자
				arrayOf(
					ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
					ContactsContract.CommonDataKinds.Phone.NUMBER
				),
				null,
				null,
				null
			)
			var name = "none"
			var phone = "none"
			if (cursor!!.moveToFirst()) {
				name = cursor?.getString(0).toString()
				phone = cursor?.getString(1).toString()
			}
			resultView.text = "name - $name, phone - $phone"
		}

		val permissionLauncher = registerForActivityResult(
			ActivityResultContracts.RequestPermission()
		) { isGranted ->
			// 퍼미션 다이얼로그 종료 후 실행 되는 부분
			if (isGranted) {
				val intent =
					Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
				requestActivity.launch(intent)
			}
		}

		button.setOnClickListener {
			val status =
				ContextCompat.checkSelfPermission(this, "android.permission.READ_CONTACTS")
			if (status == PackageManager.PERMISSION_GRANTED) {
				// 퍼미션 허용 상태 시 바로 암시적 인텐트 발생시켜 식별자 획득
				val intent =
					Intent(
						Intent.ACTION_PICK,
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI
					)
				requestActivity.launch(intent)
			} else {
				// 퍼미션 거부 상태 시 퍼미션 요청
				permissionLauncher.launch("android.permission.READ_CONTACTS")
			}
		}
	}
}