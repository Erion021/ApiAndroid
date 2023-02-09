package zubkov.vadim.apiandroid.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubkov.vadim.apiandroid.login.data.dto.UserDTO
import zubkov.vadim.apiandroid.core.network.RetrofitHelper
//import zubkov.vadim.pruebasandroiddiseo.core.network.RetrofitHelper
import javax.inject.Inject

class UserService @Inject constructor(private val userClient: UserClient){
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doUser(
        user : UserDTO
    ):Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(userClient::class.java).doUser(user)
            response.body()?.status?.compareTo("201") == 0
        }
    }
}