package zubkov.vadim.monkeyfilm.home.data

import androidx.annotation.DrawableRes

data class MediaModel(
    var id_usuario:Int,
    var fecha: String,
    var nombre:String,
    var categoria:String,
    var distancia:Int,
    var dificultad:String,
    var duracion:Int,
    var descripcion: String,
    var privacidad: String,
    var empresa: String,
    var url: String,
    var foto: String
)


/*data class MediaModel(
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
)*/