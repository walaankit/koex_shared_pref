package com.koex.sharedprefprocessor

import com.google.auto.service.AutoService
import com.koex.sharedpref.SharedPrefClient
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
@SupportedAnnotationTypes("com.koex.sharedpref.SharedPrefClient")
class SharedPrefAnnotationsProcessor : AbstractProcessor() {

    override fun process(typeElementsSet: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {

        val generatedSourcesRoot: String = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME].orEmpty()
        if(generatedSourcesRoot.isEmpty()) {
            processingEnv.printErrorMessage(
                "Can't find the target directory for generated Kotlin files."
            )
            return false
        }else{
            processingEnv.printMessage(
                "Found path for Kotlin Generated Code: $generatedSourcesRoot"
            )
        }

        roundEnvironment?.getElementsAnnotatedWith(SharedPrefClient::class.java)?.forEach { classElement ->
            if (classElement.kind != ElementKind.CLASS) {
                processingEnv.printErrorMessage(
                    "SharedPrefClient annotation Can only be applied to classes,  element: $classElement "
                )
                return false
            }

            val fieldsInArgument = ElementFilter.fieldsIn(classElement.enclosedElements)

            val annotationArgs = classElement.getAnnotation(SharedPrefClient::class.java).prefFileName

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