package zubkov.vadim.apiandroid.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import zubkov.vadim.apiandroid.login.domin.LoginUseCase
import zubkov.vadim.apiandroid.nav.Routes

class LoginViewModel : ViewModel() {
    private val loginUseCase = LoginUseCase()

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> = _id

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isButtonLoginEnable = MutableLiveData<Boolean>()
    val isButtonLoginEnable: LiveData<Boolean> = _isButtonLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(id:String,name:String,email: String, password: String) {
        _id.value = id
        _name.value = name
        _email.value = email
        _password.value = password
        _isButtonLoginEnable.value = enableLogin(id,name,email, password)
    }

    private fun enableLogin(id:String,name:String,email: String, password: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length > 8

    fun onButtonLoginPress(navigationController: NavHostController) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(id.value!!,name.value!!,email.value!!, password.value!!)
            if(result) {
                Log.i("DAM", "Se ha completado el login")
                navigationController.navigate(route = Routes.Register.route)
            }
            _isLoading.value = false
        }
    }
}