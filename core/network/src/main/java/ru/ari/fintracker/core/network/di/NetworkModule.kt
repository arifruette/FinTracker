package ru.ari.fintracker.core.network.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ari.fintracker.core.common.utils.qualifiers.AppScope
import ru.ari.fintracker.core.network.AuthInterceptor

@Module
class NetworkModule {

    @Provides
    @AppScope
    fun provideOkHttpClient(apiKey: String): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(apiKey))
            .build()

    @Provides
    @AppScope
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://shmr-finance.ru/api/v1/"
    }
}
