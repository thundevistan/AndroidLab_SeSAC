package com.kotdev99.android.c28

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val view2 = findViewById<TextView>(R.id.txt_View2)
		view2.text = getString(R.string.txt_data2)
		view2.setTextColor(ResourcesCompat.getColor(resources, R.color.txt_color, null))
		view2.textSize = resources.getDimension(R.dimen.txt_size)
	}
}