package zubkov.vadim.pruebasandroiddiseo.Screens.Register.data

import zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.network.RegisterService
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin.RegisterModel

class RegisterRepository {
    private val api = RegisterService()

    suspend fun doRegister(registerUser : RegisterModel) : Boolean {
        return api.doUser(registerUser)
    }
}