package zubkov.vadim.apiandroid.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zubkov.vadim.apiandroid.login.ui.LoginScreen
import zubkov.vadim.apiandroid.login.ui.LoginViewModel
import zubkov.vadim.apiandroid.register.RegisterScreen

@Composable
fun Navigation() {
    val loginViewModel = LoginViewModel()
    loginViewModel.devolverLista()
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.Register.route) {
        composable(route = Routes.Login.route) {
            LoginScreen(
                navigationController = navigationController,
                loginViewModel = LoginViewModel()
            )
        }
        composable(route = Routes.Register.route) {
            RegisterScreen(
                navigationController = navigationController,
                loginViewModel = loginViewModel
            )
        }
    }
}