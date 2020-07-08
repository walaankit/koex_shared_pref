package com.koex.sharedpref

import com.koex.sharedpref.typeannotations.SharedPrefBoolean
import com.koex.sharedpref.typeannotations.SharedPrefInteger
import com.koex.sharedpref.typeannotations.SharedPrefString

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class SharedPrefClient(
    val prefFileName: String,
    val prefIntegers: Array<SharedPrefInteger> = [],
    val prefBooleans: Array<SharedPrefBoolean> = [],
    val prefStrings: Array<SharedPrefString> = []
) {
}