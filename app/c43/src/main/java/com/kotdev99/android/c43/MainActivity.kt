package com.kotdev99.android.c43

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val btn = findViewById<Button>(R.id.btn)
		btn.setOnClickListener {
			val intent = Intent()
			intent.action = "ACTION_DETAIL"
			// category 정보를 주지 않으면 기본으로 DEFAULT 값이 된다
			intent.data = Uri.parse("http://www.google.com")
			startActivity(intent)
		}
	}
}