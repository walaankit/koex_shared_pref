package com.koex.sharedprefclientapp.util

import com.koex.sharedpref.SharedPrefClient
import com.koex.sharedpref.typeannotations.SharedPrefBoolean
import com.koex.sharedpref.typeannotations.SharedPrefInteger
import com.koex.sharedpref.typeannotations.SharedPrefString
import com.koex.sharedprefclientapp.util.MainSharedPref.TEST2_INT
import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_BOOLEAN

import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_INT
import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_STRING
import com.koex.sharedprefclientapp.util.MainSharedPref.prefFileName


@SharedPrefClient(
    prefFileName = prefFileName,
    prefIntegers = [
        SharedPrefInteger(TEST_INT,3),
        SharedPrefInteger(TEST2_INT)
    ],
    prefBooleans = [
        SharedPrefBoolean(TEST_BOOLEAN)
    ],
    prefStrings = [
        SharedPrefString(TEST_STRING)
    ]
)
object  MainSharedPref {

    const val prefFileName = "main_pref"

    const val TEST_INT = "test_int"

    const val TEST_BOOLEAN = "test_bool"

    const val TEST_STRING = "test_string"

    const val TEST2_INT = "test2_int"
}