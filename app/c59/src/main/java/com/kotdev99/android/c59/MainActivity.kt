package com.kotdev99.android.c59

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val button = findViewById<Button>(R.id.button)
		button.setOnClickListener {
			// select문 으로 저장 되어 있는 데이터 뽑기
			val db: SQLiteDatabase = DBHelper(this).readableDatabase
			val cursor = db.rawQuery("select name from tb_member", null)
			if (cursor.moveToFirst()) {
				Toast.makeText(this, "${cursor.getString(0)}", Toast.LENGTH_SHORT).show()
			}
			db.close()
		}
	}
}