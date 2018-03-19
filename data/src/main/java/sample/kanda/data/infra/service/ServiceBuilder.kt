package sample.kanda.data.infra.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by caique on 3/7/18.
 */

object ServiceBuilder {
    operator fun invoke(baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpCliente(logger()))
                .build()
    }

    private fun okHttpCliente(interceptor: Interceptor) = OkHttpClient.Builder().run {
        addInterceptor(interceptor)
        build()
    }

    private fun logger() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

}