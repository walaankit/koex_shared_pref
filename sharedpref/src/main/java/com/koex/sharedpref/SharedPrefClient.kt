package com.koex.sharedpref

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefClient(val prefFileName: String = "") {
}