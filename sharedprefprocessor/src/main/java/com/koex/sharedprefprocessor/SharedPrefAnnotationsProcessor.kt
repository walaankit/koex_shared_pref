package com.koex.sharedprefprocessor

import com.google.auto.service.AutoService
import com.koex.sharedpref.SharedPrefClient
import com.koex.sharedpref.typeannotations.SharedPrefBoolean
import com.koex.sharedpref.typeannotations.SharedPrefInteger
import com.squareup.kotlinpoet.*
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.util.ElementFilter


@AutoService(Processor::class) // For registering the service
@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
@SupportedOptions(SharedPrefAnnotationsProcessor.KAPT_KOTLIN_GENERATED_OPTION_NAME)
@SupportedAnnotationTypes("com.koex.sharedpref.SharedPrefClient", "com.koex.sharedpref.typeannotations.SharedPrefInteger")
class SharedPrefAnnotationsProcessor : AbstractProcessor() {

    var processingRound = 0

    override fun process(typeElementsSet: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {
        processingEnv.printMessage("\n Processing Round ${++processingRound}")
        val generatedSourcesRoot: String = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME].orEmpty()
        if(generatedSourcesRoot.isEmpty()) {
            processingEnv.printErrorMessage(
                "Can't find the target directory for generated Kotlin files."
            )
            return false
        }else{
            processingEnv.printMessage(
                "\nFound path for Kotlin Generated Code: $generatedSourcesRoot"
            )
        }
        roundEnvironment?.getElementsAnnotatedWith(SharedPrefInteger::class.java)?.forEach { intElement ->
            processingEnv.printMessage(
                "\n Integer Element name is ${intElement.simpleName} and kind is ${intElement.kind}"
            )


        }

        roundEnvironment?.getElementsAnnotatedWith(SharedPrefClient::class.java)?.forEach { classElement ->
            if (classElement.kind != ElementKind.CLASS) {
                processingEnv.printErrorMessage(
                    "SharedPrefClient annotation Can only be applied to classes,  element: $classElement "
                )
                return false
            } else{
                processingEnv.printMessage(
                    "\n Class Element name is ${classElement.simpleName}"
                )
            }

            val fieldsInArgument = ElementFilter.fieldsIn(classElement.enclosedElements)

            val annotationArgs = classElement.getAnnotation(SharedPrefClient::class.java).prefFileName
//            fieldsInArgument.forEach{element ->
//                processingEnv.printMessage("\nGot element ${element.simpleName} with Annotaions ${element.getAnnotation(SharedPrefInteger::class.java)}")
//            }


            val className = classElement.simpleName.toString()+"Client"
            val file = File(generatedSourcesRoot).apply { mkdir() }
            FileSpec.builder("com.koex.sharedpref", className)
                .addType(TypeSpec.classBuilder(className)
                    .addFunction(
                        FunSpec.builder("getert")
                            .addStatement("val i=0")
                            .build()
                    )
                    .addProperty(
                        PropertySpec.builder(
                            "name",
                            String::class
                        ).initializer("\"$annotationArgs\"")
                        .build()

                    ).build()
                ).build()
                .writeTo(file)



        }

        return true
    }

    companion object{
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}