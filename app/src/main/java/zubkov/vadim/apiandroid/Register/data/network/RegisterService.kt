package zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubkov.vadim.apiandroid.core.network.RetrofitHelper
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin.RegisterModel

class RegisterService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doUser(registerUser : RegisterModel):Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(RegisterClient::class.java).doRegisterJSON(registerUser)
            response.body()?.status?.compareTo("201") == 0
        }
    }
}