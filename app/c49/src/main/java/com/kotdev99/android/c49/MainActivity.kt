package com.kotdev99.android.c49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

	// 굉장히 큰 연산 작업을 수행 하는 코루틴
	val backgroundScope = CoroutineScope(Dispatchers.Default + Job())

	lateinit var button: Button
	lateinit var resultView: TextView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		button = findViewById(R.id.button)
		resultView = findViewById(R.id.resultView)

		button.setOnClickListener {
			backgroundScope.launch {
				var sum = 0L
				var time = measureTimeMillis {
					for (i in 1..2_000_000_000) {
						sum += i
					}
				}
				// Dispatchers.Main 에게 결과 값을 화면에 찍어 달라고 의뢰
				withContext(Dispatchers.Main) {
					resultView.text = "sum : $sum"
				}
			}
		}
	}
}