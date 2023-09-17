package com.kotdev99.android.c96

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.kotdev99.android.c96.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var toggle: ActionBarDrawerToggle

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// 토글이 열린 상태, 닫힌 상태를 설명 하는 문자열을 리소스(Int 변수) 로 주게 되어있다.
		toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		toggle.syncState()
	}

	// Menu event 발생 시 자동 호출, but 여기서 이벤트 로직은 작성하지 않는다
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (toggle.onOptionsItemSelected(item)) {
			return true
		}
		return super.onOptionsItemSelected(item)
	}
}