package zubkov.vadim.apiandroid.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import zubkov.vadim.apiandroid.login.data.UserModel
import zubkov.vadim.apiandroid.login.domin.LoginUseCase
import zubkov.vadim.apiandroid.nav.Routes

class LoginViewModel : ViewModel() {
    private var _listaUsers = MutableLiveData<List<UserModel>>()
    var listaUsers : LiveData<List<UserModel>> = _listaUsers

    val loginUseCase = LoginUseCase()

    fun changeList(){
        listaUsers = _listaUsers
    }

    fun devolverLista(){
        viewModelScope.launch {
            _listaUsers = MutableLiveData(loginUseCase())
            changeList()
        }
    }
}