package com.koex.sharedpref.typeannotations

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefInteger(val defaultValue: Int = 0) {
}