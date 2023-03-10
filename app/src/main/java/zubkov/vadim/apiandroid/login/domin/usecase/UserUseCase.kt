package zubkov.vadim.apiandroid.login.domin.usecase

import zubkov.vadim.apiandroid.login.data.UserRepository
import zubkov.vadim.apiandroid.login.data.dto.UserDTO
import zubkov.vadim.apiandroid.login.domin.entity.UserModel
import javax.inject.Inject

class UserUseCase @Inject constructor(private val repository: UserRepository){
    suspend operator fun invoke(
        user : UserModel
    ) : Boolean {
        return repository.doLogin(
            user = UserDTO(
                email = user.email,
                password = user.password
            )
        )
    }
}