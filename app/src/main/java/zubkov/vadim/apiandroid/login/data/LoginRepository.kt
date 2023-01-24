package zubkov.vadim.apiandroid.login.data

import zubkov.vadim.apiandroid.login.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin():List<UserModel> {
        return api.doLogin()
    }
}