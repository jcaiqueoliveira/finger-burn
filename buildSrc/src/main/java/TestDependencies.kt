/**
 * Created by jcosilva on 3/2/2018.
 */
object TestVersions {
    val junit = "4.12"
    val assertj_core = "3.8.0"
    val mockito_kotlin = "1.5.0"
    val mockito = "2.8.9"
    val robolectric = "3.5.1"

    val runner = "1.0.1"
    val espresso = "3.0.1"

}


object TestDeps {
    val junit = "junit:junit:${TestVersions.junit}"

    val runner = "com.android.support.test:runner:${TestVersions.runner}"

    val espresso_core = "com.android.support.test.espresso:espresso-core:${TestVersions.espresso}"

    val espresso_contrib = "com.android.support.test.espresso:espresso-contrib:${TestVersions.espresso}"

    val espresso_intent = "com.android.support.test.espresso:espresso-intents:${TestVersions.espresso}"

    val assert_j = "org.assertj:assertj-core:${TestVersions.assertj_core}"

    val mockito_kotlin = "com.nhaarman:mockito-kotlin:${TestVersions.mockito_kotlin}"

    val mockito_android = "org.mockito:mockito-android:${TestVersions.mockito}"

    val robolectric = "org.robolectric:robolectric:${TestVersions.robolectric}"

    val mockito_core = "org.mockito:mockito-core:${TestVersions.mockito}"

    val mockito_inline = "org.mockito:mockito-inline:${TestVersions.mockito}"

    val mock_server = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"

}