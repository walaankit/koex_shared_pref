package com.koex.sharedpref.typeannotations

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefString(val defaultValue: String = "") {
}