package zubkov.vadim.pruebasandroiddiseo.Screens.Register.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import zubkov.vadim.apiandroid.nav.Routes
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin.RegisterModel
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin.RegisterUseCase

class RegisterViewModel : ViewModel() {
    private val registerUseCase = RegisterUseCase()

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _nick = MutableLiveData<String>()
    val nick: LiveData<String> = _nick

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _repeatPassword = MutableLiveData<String>()
    val repeatPassword: LiveData<String> = _repeatPassword

    private val _isButtonLoginEnable = MutableLiveData<Boolean>()
    val isButtonLoginEnable: LiveData<Boolean> = _isButtonLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onRegisterChanged(name: String, email:String, password: String, repeatPassword: String) {
        _name.value = name
        _email.value = email
        _password.value = password
        _repeatPassword.value = repeatPassword
    }

    fun onButtonRegisterPress(navigationController: NavHostController,context : Context) {
        if (name.value == null && email.value == null && password.value == null){
            Toast.makeText(context,"Debe introducir los datos", Toast.LENGTH_SHORT).show()
        } else if (repeatPassword.value?.let { password.value?.compareTo(it) ?: 0 } != 0) {
            Toast.makeText(context,"Las contraseñeas deben coincidir", Toast.LENGTH_SHORT).show()
        } else {
            viewModelScope.launch {
                Log.i("Mensaje", "Hola?")
                val userRegister = RegisterModel(name = name.value!!, email = email.value!!, password = password.value!!, nick = "DefNick")
                val result = registerUseCase(userRegister)
                if(result) {
                    Log.i("Mensaje", "Registro Completo")
                    navigationController.navigate(route = Routes.Login.route)
                }
            }
        }

    }
}