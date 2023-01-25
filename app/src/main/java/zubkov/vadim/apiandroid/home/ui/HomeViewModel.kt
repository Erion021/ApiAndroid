package zubkov.vadim.monkeyfilm.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import zubkov.vadim.monkeyfilm.home.data.MediaModel
import zubkov.vadim.monkeyfilm.home.domin.HomeUseCase

class HomeViewModel : ViewModel() {
    private var _listaPelis = MutableLiveData<List<MediaModel>>()
    var listaPelis : LiveData<List<MediaModel>> = _listaPelis

    val homeUseCase = HomeUseCase()

    fun changeList(){
        listaPelis = _listaPelis
    }

    fun devolverLista(){
        viewModelScope.launch {
            _listaPelis = MutableLiveData(homeUseCase())
            changeList()
        }
    }
}