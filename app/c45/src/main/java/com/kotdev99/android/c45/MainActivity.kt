package com.kotdev99.android.c45

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	private var cnt = 0
	private lateinit var editView: EditText
	private lateinit var cntView: TextView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		cntView = findViewById(R.id.tv_cnt)
		val btn = findViewById<Button>(R.id.btn_plus)
		editView = findViewById(R.id.et_edit)

		btn.setOnClickListener {
			cnt++
			cntView.text = "$cnt"
		}
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putInt("cnt", cnt)
		outState.putString("edit", editView.text.toString())
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		cnt = savedInstanceState.getInt("cnt")
		cntView.setText("$cnt")
		editView.setText(savedInstanceState.getString("edit"))
	}
}