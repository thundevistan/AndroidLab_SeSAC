package com.kotdev99.android.c48

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ImageView
import android.widget.TextView
import androidx.loader.content.AsyncTaskLoader

class MainActivity : AppCompatActivity() {

	lateinit var startView: ImageView
	lateinit var pauseView: ImageView
	lateinit var textView: TextView

	var isFirst = true

	lateinit var asyncTask: MyAsyncTask

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		startView = findViewById(R.id.main_startBtn)
		pauseView = findViewById(R.id.main_pauseBtn)
		textView = findViewById(R.id.main_textView)

		startView.setOnClickListener {
			if (isFirst) {
				asyncTask.isRun = true
				asyncTask.execute()     // execute 함수를 호출하는 순간 doInBackground 함수 실행
				isFirst = false
			} else {
				asyncTask.isRun = true
			}
		}

		pauseView.setOnClickListener {
			asyncTask.isRun = false
		}

		asyncTask = MyAsyncTask()
	}

	inner class MyAsyncTask : AsyncTask<Void?, Int?, String>() {
		var loopFlag = true
		var isRun = false

		override fun doInBackground(vararg p0: Void?): String {
			var count = 10
			while (loopFlag) {
				SystemClock.sleep(1000)
				if (isRun) {
					count--
					publishProgress(count)
					if (count == 0) {
						loopFlag = false
					}
				}
			}
			return "Finish!!"
		}

		// 이 함수는 메인 스레드에 의해서 호출됨. 즉, 뷰 객체를 이용할 수 있음.
		// doInBackground 함수에서 publishProgress 가 콜 되었을 때 호출 된다.
		override fun onProgressUpdate(vararg values: Int?) {
			super.onProgressUpdate(*values)
			textView.setText(values[0].toString())
		}

		// doInBackground 함수가 최종 종료된 순간에 마지막 리턴 값을 받아서 호출 된다.
		override fun onPostExecute(result: String?) {
			super.onPostExecute(result)
			textView.setText(result)
		}
	}
}