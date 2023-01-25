package zubkov.vadim.apiandroid.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zubkov.vadim.apiandroid.login.ui.LoginScreen
import zubkov.vadim.apiandroid.login.ui.LoginViewModel
import zubkov.vadim.apiandroid.register.RegisterScreen
import zubkov.vadim.monkeyfilm.home.ui.HomeScreen
import zubkov.vadim.monkeyfilm.home.ui.HomeViewModel

@Composable
fun Navigation() {
    val homeViewModel = HomeViewModel()
    homeViewModel.devolverLista()
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.Register.route) {
        composable(route = Routes.Home.route) {
            HomeScreen(
                navigationController = navigationController,
                homeViewModel = homeViewModel
            )
        }
        composable(route = Routes.Register.route) {
            RegisterScreen(
                navigationController = navigationController,
                loginViewModel = homeViewModel
            )
        }
    }
}