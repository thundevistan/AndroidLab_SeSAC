package com.kotdev99.android.c100

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kotdev99.android.c100.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: MyViewModel by viewModels()  // ViewModelProvider 를 이용한 것과 동일

        binding.button.setOnClickListener {
            model.calSum().observe(this) {
                binding.resultView.text = it
            }
        }
    }
}