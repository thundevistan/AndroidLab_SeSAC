package com.kotdev99.android.c91

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotdev99.android.c91.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val oneFragment = OneFragment()
		val twoFragment = TwoFragment()

		val manager = supportFragmentManager
		val transaction = manager.beginTransaction()

		transaction.add(R.id.fragment_content, oneFragment)
		transaction.commit()

		binding.oneButton.setOnClickListener {
			// commit() 을 하면 트랜잭션 객체는 닫힌다. 때문에 다시 얻어 주어야 한다.
			val tran = manager.beginTransaction()
			tran.replace(R.id.fragment_content, oneFragment)
			tran.commit()
		}
		binding.twoButton.setOnClickListener {
			// commit() 을 하면 트랜잭션 객체는 닫힌다. 때문에 다시 얻어 주어야 한다.
			val tran = manager.beginTransaction()
			tran.replace(R.id.fragment_content, twoFragment)
			tran.commit()
		}
	}
}