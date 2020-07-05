package com.koex.sharedprefclientapp.util

import com.koex.sharedpref.SharedPrefClient
import com.koex.sharedpref.typeannotations.SharedPrefBoolean
import com.koex.sharedpref.typeannotations.SharedPrefInteger
import com.koex.sharedpref.typeannotations.SharedPrefString

@SharedPrefClient(prefFileName = "main")
object MainSharedPref {

    @SharedPrefInteger
    const val TEST_INT = "test_int"

    @SharedPrefBoolean(defaultValue = true)
    const val TEST_BOOLEAN = "test_bool"

    @SharedPrefString
    const val TEST_STRING = "test_string"
}