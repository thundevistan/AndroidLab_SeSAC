package com.kotdev99.android.c93

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotdev99.android.c93.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.viewpager.adapter = MyAdapter(this)
	}
}