package zubkov.vadim.apiandroid.login.data

import zubkov.vadim.apiandroid.login.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(id:String,user: String,email:String, password: String) : Boolean {
        return api.doLogin(id,user, email,password)
    }
}