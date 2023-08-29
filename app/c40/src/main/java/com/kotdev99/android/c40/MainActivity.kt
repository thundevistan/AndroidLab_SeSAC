package com.kotdev99.android.c40

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private lateinit var btn: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		btn = findViewById(R.id.btn)
		btn.setOnClickListener {
			val intent = Intent(this, DetailActivity::class.java)
			startActivity(intent)
		}
	}
}