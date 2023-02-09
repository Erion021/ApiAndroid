package zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.network.response.RegisterResponse
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin.RegisterModel

interface RegisterClient {
    @POST("auth/signup")
    suspend fun doRegisterJSON(@Body registerUser: RegisterModel): Response<RegisterResponse>
}