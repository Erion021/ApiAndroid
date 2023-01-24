package zubkov.vadim.apiandroid.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubkov.vadim.apiandroid.core.network.RetrofitHelper

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(id:String,user: String,email:String, password: String) : Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.loginOk ?: false
        }
    }
}