package zubkov.vadim.apiandroid.login.data.network

import retrofit2.Response
import retrofit2.http.GET
import zubkov.vadim.apiandroid.login.data.network.response.LoginResponse

interface LoginClient {
    @GET("/v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    suspend fun doLogin(): Response<LoginResponse>
}