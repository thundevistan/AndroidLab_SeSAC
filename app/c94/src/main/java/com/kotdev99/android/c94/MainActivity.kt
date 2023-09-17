package com.kotdev99.android.c94

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.kotdev99.android.c94.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// 액션바에 적용 되는 내용을 툴바에 적용
		setSupportActionBar(binding.toolbar)
	}

	// menu_main 를 inflate 하여 적용
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return super.onCreateOptionsMenu(menu)
	}
}