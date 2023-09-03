package com.kotdev99.android.c57

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingFragment : PreferenceFragmentCompat() {
	override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
		setPreferencesFromResource(R.xml.settings, rootKey)

		val idPreference = findPreference<EditTextPreference>("serverId")
		val soundPreference = findPreference<ListPreference>("sound_list")

		idPreference?.setOnPreferenceChangeListener { preference, newValue ->
			Toast.makeText(activity, "$newValue", Toast.LENGTH_SHORT).show()
			true
		}

		soundPreference!!.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
		idPreference!!.summaryProvider =
			Preference.SummaryProvider<EditTextPreference> { preference ->
				val text = preference.text
				if (TextUtils.isEmpty(text)) {
					"설정 되지 않았습니다"
				} else {
					"설정된 id 값은 $text 입니다."
				}
			}
	}
}