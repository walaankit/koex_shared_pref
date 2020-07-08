package com.koex.sharedpref.typeannotations

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation class SharedPrefInteger(
    val keyName: String,
    val defaultValue: Int = 0
) {

}

