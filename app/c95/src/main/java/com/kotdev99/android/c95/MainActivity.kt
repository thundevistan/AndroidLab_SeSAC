package com.kotdev99.android.c95

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotdev99.android.c95.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.fab.setOnClickListener {
			when (binding.fab.isExtended) {
				true -> binding.fab.shrink()
				false -> binding.fab.extend()
			}
		}
	}
}