package com.kotdev99.android.c47

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String
import kotlin.Exception

class MainActivity : AppCompatActivity() {

	private lateinit var startView: ImageView
	private lateinit var pauseView: ImageView
	private lateinit var textView: TextView

	// 스레드 제어 boolean
	private var loopFlag = true
	private var isFirst = true
	private var isRun = false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		startView = findViewById(R.id.main_startBtn)
		pauseView = findViewById(R.id.main_pauseBtn)
		textView = findViewById(R.id.main_textView)

		startView.setOnClickListener {
			if (isFirst) {
				isFirst = false
				isRun = true
				thread.start()
			} else {
				isRun = true
			}
		}
		pauseView.setOnClickListener {
			isRun = false
		}
	}

	var handler: Handler = object : Handler() {
		override fun handleMessage(msg: Message) {
			if (msg.what === 1) {
				textView.setText(String.valueOf(msg.arg1))
			} else if (msg.what === 2) {
				textView.text = msg.obj as String
			}
		}
	}

	var thread: Thread = object : Thread() {
		override fun run() {
			try {
				var count = 10
				while (loopFlag) {
					sleep(1000)
					if (isRun) {
						count--
						var message = Message()
						message.what = 1
						message.arg1 = count
						handler.sendMessage(message)
						if (count == 0) {
							message = Message()
							message.what = 2
							message.obj = "Finish!!"
							handler.sendMessage(message)
							loopFlag = false
						}
					}
				}
			} catch (e: Exception) {


			}
		}
	}
}