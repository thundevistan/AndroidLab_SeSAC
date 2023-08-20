package com.kotdev99.android.c23

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private var initTime = 0L

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
		if (keyCode === KeyEvent.KEYCODE_BACK) {
			if (System.currentTimeMillis() - initTime > 3000) {
				Toast.makeText(
					this, "종료하려면 한 번 더 누르세요", Toast.LENGTH_SHORT
				).show()
				initTime = System.currentTimeMillis()
				return true
			}
		}
		return super.onKeyDown(keyCode, event)
	}
}