package zubkov.vadim.apiandroid.login.data

import zubkov.vadim.apiandroid.login.data.dto.UserDTO
import zubkov.vadim.apiandroid.login.data.network.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: UserService){

    suspend fun doLogin(
        user : UserDTO
    ) : Boolean {
        return api.doUser(user)
    }

}