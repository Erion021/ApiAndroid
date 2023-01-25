package zubkov.vadim.apiandroid.nav

sealed class Routes(val route: String) {
    object Login: Routes("login")
    object Register: Routes("register")
    object Home: Routes("home")
}
