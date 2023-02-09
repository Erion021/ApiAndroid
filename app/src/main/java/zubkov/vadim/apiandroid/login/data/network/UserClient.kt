package zubkov.vadim.apiandroid.login.data.network

import dagger.Provides
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import zubkov.vadim.apiandroid.login.data.dto.UserDTO
import zubkov.vadim.apiandroid.login.data.network.response.UserResponse

interface UserClient {
    @Provides
    @POST("auth/signin")
    suspend fun doUser(
        @Body user: UserDTO
    ): Response<UserResponse>
}