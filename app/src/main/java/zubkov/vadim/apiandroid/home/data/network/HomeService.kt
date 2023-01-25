package zubkov.vadim.monkeyfilm.home.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubkov.vadim.apiandroid.core.network.RetrofitHelper
import zubkov.vadim.monkeyfilm.home.data.MediaModel


class HomeService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doFilms():List<MediaModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(HomeClient::class.java).doFilmList()
            response.body()?.filmList ?: emptyList()
        }
    }
}