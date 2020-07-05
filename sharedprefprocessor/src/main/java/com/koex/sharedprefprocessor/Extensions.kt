package com.koex.sharedprefprocessor

import javax.annotation.processing.ProcessingEnvironment
import javax.tools.Diagnostic


fun ProcessingEnvironment.printErrorMessage(message: String?){
    messager.printMessage(Diagnostic.Kind.ERROR, message )
}

fun ProcessingEnvironment.printMessage(message: String?){
    messager.printMessage(Diagnostic.Kind.NOTE, message )
}