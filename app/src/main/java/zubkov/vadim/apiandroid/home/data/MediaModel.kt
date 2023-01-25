package zubkov.vadim.monkeyfilm.home.data

import androidx.annotation.DrawableRes

/*
data class MediaModel(
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
*/

data class MediaModel(
    var id_usuario: String,
    var nombre: String,
    var apellido: String,
    var email: String,
    var fecha: String,
    var nick: String,
    var password: String,
    var siguiendo: List<String>,
    var foto: String,
    var web: String,
    var rol: String
)