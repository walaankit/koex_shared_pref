package com.koex.sharedpref.typeannotations


@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefBoolean(
    val keyName: String,
    val defaultValue: Boolean = false
) {
}