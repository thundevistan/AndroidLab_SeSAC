package com.kotdev99.android.c12

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	private lateinit var btnVisible: Button
	private lateinit var btnInvisible: Button
	private lateinit var imgViewLogo: ImageView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		btnVisible = findViewById(R.id.btn_visible)
		btnInvisible = findViewById(R.id.btn_invisible)
		imgViewLogo = findViewById(R.id.imgView_logo)

		btnVisible.setOnClickListener {
			imgViewLogo.visibility = View.VISIBLE
		}
		btnInvisible.setOnClickListener {
			imgViewLogo.visibility = View.INVISIBLE
		}
	}
}