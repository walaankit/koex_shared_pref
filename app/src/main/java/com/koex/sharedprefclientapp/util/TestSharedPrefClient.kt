package com.koex.sharedprefclientapp.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
//import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_BOOLEAN
//import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_INT
//import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_STRING


class TestSharedPrefClient(private val context: Application) {
    val prefName: String? = null //or "any string which is given in Annotations arguments"

    val preferences: SharedPreferences? =
        prefName?.let {
            context.getSharedPreferences(it, Context.MODE_PRIVATE)
        }?.run {
            PreferenceManager.getDefaultSharedPreferences(context)
        }


//    fun setTestInt(testInt: Int){
//        preferences?.edit(commit = true){
//            putInt(TEST_INT, testInt)
//        }
//    }
//
//    fun getTestInt(defaultValue: Int = 0 /* or the value received from annotation arguments*/ ):Int{
//        return preferences?.getInt(TEST_INT,defaultValue)!!
//    }
//
//    fun setTestBoolean(testBoolean: Boolean){
//        preferences?.edit(commit = true){
//            putBoolean(TEST_BOOLEAN, testBoolean)
//        }
//    }
//
//    fun getTestBoolean(defaultValue: Boolean = true/* or the value received from annotation arguments*/):Boolean{
//        return preferences?.getBoolean(TEST_BOOLEAN,defaultValue)!!
//    }
//
//    fun setTestString(testString: String?){
//        preferences?.edit(commit = true){
//            putString(TEST_STRING, testString)
//        }
//    }
//
//    fun getTestString(defaultValue: String? = null /* or the value received from annotation arguments*/): String?{
//        return preferences?.getString(TEST_STRING,defaultValue)
//    }

}