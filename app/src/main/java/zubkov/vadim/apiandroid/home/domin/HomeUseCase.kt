package zubkov.vadim.monkeyfilm.home.domin

import zubkov.vadim.monkeyfilm.home.data.HomeRepository
import zubkov.vadim.monkeyfilm.home.data.MediaModel

class HomeUseCase {
    private val repository = HomeRepository()

    suspend operator fun invoke() :List<MediaModel>{
        return repository.doFilms()
    }
}