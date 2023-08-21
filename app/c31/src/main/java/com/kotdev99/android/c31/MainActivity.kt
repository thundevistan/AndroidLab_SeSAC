package com.kotdev99.android.c31

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val listView = findViewById<ListView>(R.id.main_list)

		val datas = resources.getStringArray(R.array.location)

		val adapter = ArrayAdapter(
			this,
			android.R.layout.simple_list_item_1,
			datas
		)
		listView.adapter = adapter
	}
}