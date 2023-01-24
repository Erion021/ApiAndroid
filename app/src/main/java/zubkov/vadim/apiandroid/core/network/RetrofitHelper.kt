package zubkov.vadim.apiandroid.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.1.189:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}