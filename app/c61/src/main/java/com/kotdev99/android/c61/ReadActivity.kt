package com.kotdev99.android.c61

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReadActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_read)

		val titleView = findViewById<TextView>(R.id.read_title)
		val contentView = findViewById<TextView>(R.id.read_content)

		val db = DBHelper(this).readableDatabase
		val cursor = db.query(
			"tb_memo",
			arrayOf("title", "content"),
			null,
			null,
			null,
			null,
			"_id desc limit 1"
		)
		while (cursor.moveToNext()) {
			titleView.text = cursor.getString(0)
			contentView.text = cursor.getString(1)
		}
	}
}