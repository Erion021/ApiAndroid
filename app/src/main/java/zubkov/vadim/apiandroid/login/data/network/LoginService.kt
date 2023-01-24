package zubkov.vadim.apiandroid.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubkov.vadim.apiandroid.core.network.RetrofitHelper
import zubkov.vadim.apiandroid.login.data.UserModel

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin() : List<UserModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.loginUsers ?: emptyList()
        }
    }
}