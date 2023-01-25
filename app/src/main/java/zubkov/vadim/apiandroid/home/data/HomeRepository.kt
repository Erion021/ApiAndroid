package zubkov.vadim.monkeyfilm.home.data

import zubkov.vadim.monkeyfilm.home.data.network.HomeService

class HomeRepository {
    private val api = HomeService()

    suspend fun doFilms():List<MediaModel>{
        return api.doFilms()
    }
}