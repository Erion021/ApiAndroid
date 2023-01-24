package zubkov.vadim.apiandroid.login.domin

import zubkov.vadim.apiandroid.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(id:String,user: String,email:String, password: String) : Boolean {
        return repository.doLogin(id, user, email, password)
    }
}