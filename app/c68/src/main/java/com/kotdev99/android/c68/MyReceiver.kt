package com.kotdev99.android.c68

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

	override fun onReceive(context: Context, intent: Intent) {
		// This method is called when the BroadcastReceiver is receiving an Intent broadcast.
		Log.d("kotdev99", "receiver...")
	}
}