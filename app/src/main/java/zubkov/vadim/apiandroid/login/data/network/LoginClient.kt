package zubkov.vadim.apiandroid.login.data.network

import retrofit2.Response
import retrofit2.http.GET
import zubkov.vadim.apiandroid.login.data.network.response.LoginResponse

interface LoginClient {
    @GET("/signin")
    suspend fun doLogin(): Response<LoginResponse>
}