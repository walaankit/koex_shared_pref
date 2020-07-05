package com.koex.sharedprefclientapp.util

import com.koex.sharedpref.SharedPrefClient
import com.koex.sharedpref.typeannotations.SharedPrefBoolean
import com.koex.sharedpref.typeannotations.SharedPrefInteger
import com.koex.sharedpref.typeannotations.SharedPrefString
import com.koex.sharedprefclientapp.util.MainSharedPref.TEST_INT


@SharedPrefClient(prefFileName = TEST_INT)
object  MainSharedPref {

    @SharedPrefInteger
    const val TEST_INT = "test_int"

    @SharedPrefBoolean(defaultValue = true)
     val TEST_BOOLEAN = "test_bool"

    @SharedPrefString
     val TEST_STRING = "test_string"

    @SharedPrefInteger
    var TEST2_INT = "test2_int"
}