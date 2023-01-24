package zubkov.vadim.apiandroid.login.domin

import zubkov.vadim.apiandroid.login.data.LoginRepository
import zubkov.vadim.apiandroid.login.data.UserModel

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke() : List<UserModel> {
        return repository.doLogin()
    }
}