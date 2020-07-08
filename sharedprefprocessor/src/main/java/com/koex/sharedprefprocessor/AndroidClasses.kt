package com.koex.sharedprefprocessor

import com.squareup.kotlinpoet.ClassName


object AndroidClasses
{
    val SharedPreferencesClass = ClassName("android.content", "SharedPreferences")
    val ContextClass = ClassName("android.content", "Context")
    val PreferenceManagerClass = ClassName("androidx.preference","PreferenceManager")
    val ApplicationClass = ClassName("android.app","Application")
    
}