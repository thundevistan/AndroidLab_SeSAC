package com.kotdev99.android.c88

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val imageView = findViewById<ImageView>(R.id.resultView)

		Glide.with(this)
			.load("https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
			.override(200, 200)
			.placeholder(R.drawable.loading)
			.error(R.drawable.error)
			.into(imageView)
	}
}