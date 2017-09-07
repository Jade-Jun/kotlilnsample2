package com.sy.sample.kotlin_example2

import android.content.pm.PackageInfo
import android.os.Bundle
import android.preference.EditTextPreference
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference

/**
 * Created by SuYa on 2017. 9. 7..
 */
class SettingFragment : PreferenceFragment(), Preference.OnPreferenceChangeListener {

    private lateinit var pref_used_name : SwitchPreference
    private lateinit var pref_name : EditTextPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settting_preference)

        pref_used_name = findPreference("pref_used_name") as SwitchPreference
        pref_name = findPreference("pref_name") as EditTextPreference
        val pref_app_version = findPreference("pref_app_version") as Preference
        val info = this.activity.packageManager.getPackageInfo(this.activity.packageName, 0) as PackageInfo
        pref_app_version.setSummary(info.versionName)

        pref_used_name.setOnPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onPreferenceChange(p0: Preference?, p1: Any?): Boolean {

        when (p0) {
            pref_used_name -> {
                pref_name.isEnabled = p1 as Boolean
            }
        }
        return true
    }
}