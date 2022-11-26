package com.slashmobility.seleccion.ray.pasache.di

import com.slashmobility.seleccion.ray.pasache.datasource.GroupsApiService
import com.slashmobility.seleccion.ray.pasache.datasource.RemoteGroupsDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal const val GROUPS_REMOTE_DATA_SOURCE = "GroupsRemoteDataSource"

var remoteDataSourceModule = module{
    single(named(GROUPS_REMOTE_DATA_SOURCE)){ RemoteGroupsDataSource(apiService()) }
}

private fun apiService(): GroupsApiService {
    return retrofit().create(GroupsApiService::class.java)
}

private fun retrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://practica-slashmobility.firebaseio.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp())
        .build()
}

private fun okHttp(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()

    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
}