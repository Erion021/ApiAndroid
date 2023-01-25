package zubkov.vadim.monkeyfilm.home.data.network

import retrofit2.Response
import retrofit2.http.GET
import zubkov.vadim.monkeyfilm.home.data.network.response.HomeResponse

interface HomeClient {
    @GET("/usuarios")
    suspend fun doFilmList(): Response<HomeResponse>
}