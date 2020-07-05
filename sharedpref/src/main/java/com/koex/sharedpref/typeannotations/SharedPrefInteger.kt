package com.koex.sharedpref.typeannotations

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefInteger(val defaultValue: Int = 0) {
}