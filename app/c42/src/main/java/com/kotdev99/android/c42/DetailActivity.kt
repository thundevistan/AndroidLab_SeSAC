package com.kotdev99.android.c42

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)

		val id = intent.getStringExtra("id")
		val btn = findViewById<Button>(R.id.btn_finish)
		btn.setOnClickListener {
			intent.putExtra("result", "hello : $id")
			setResult(RESULT_OK, intent)
			finish()
		}
	}
}