package zubkov.vadim.apiandroid.login.data

data class UserModel(
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
)
