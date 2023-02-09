package zubkov.vadim.pruebasandroiddiseo.Screens.Register.domin

import zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.RegisterRepository

class RegisterUseCase {
    private val repository = RegisterRepository()

    suspend operator fun invoke(registerUser : RegisterModel) : Boolean {
        return repository.doRegister(registerUser)
    }
}