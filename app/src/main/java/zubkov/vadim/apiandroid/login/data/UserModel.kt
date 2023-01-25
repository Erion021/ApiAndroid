package zubkov.vadim.apiandroid.login.data

import androidx.annotation.DrawableRes

/*data class UserModel(
    var id: String,
    var nombre: String,
    var apellidos: String,
    var email: String,
    var fecha: String,
    var nickname: String,
    var password: String,
    var siguiendo: List<String>,
    var foto: String,
    var web: String,
    var rol : String
)*/

data class UserModel(
    var id: Int,
    var title: String,
    var description: String,
    @DrawableRes var catel: Int,
    var score: Int,
    var favorito: Boolean = false,
    var genre: List<String>,
    var category: String
){
    fun likes(){
        favorito = !favorito
    }
}
