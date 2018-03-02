/**
 * Created by jcosilva on 3/2/2018.
 */
object Versions {
    val kotlin = "1.2.30"
    val gradle = "3.0.1"

    val compile_sdk = 27
    val min_sdk = 21
    val target_sdk = 27

    val support = "27.0.2"

    val rx = "2.1.10"
    val rxandroid = "2.0.1"

    val retrofit = "2.3.0"

    val logging_interceptor = "3.9.1"

    val glide = "4.4.0"

    val kodein = "4.1.0"

    val google_components = "1.1.0"

    val okhttp = "3.10.0"
}

object Deps {
    val kotlin_stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"

    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    val rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

    val gson_adapter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support}"

    val design = "com.android.support:design:${Versions.support}"

    val cardview_v7 = "com.android.support:cardview-v7:${Versions.support}"

    val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support}"

    val kodein = "com.github.salomonbrys.kodein:kodein:${Versions.kodein}"

    val kodein_android = "com.github.salomonbrys.kodein:kodein-android:${Versions.kodein}"

    val kodein_conf = "com.github.salomonbrys.kodein:kodein-conf:${Versions.kodein}"

    val rx = "io.reactivex.rxjava2:rxjava:${Versions.rx}"

    val view_model = "android.arch.lifecycle:viewmodel:${Versions.google_components}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
}

