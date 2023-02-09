package zubkov.vadim.apiandroid.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zubkov.vadim.apiandroid.login.ui.Login
import zubkov.vadim.apiandroid.login.ui.UserViewModel
import zubkov.vadim.apiandroid.screenProve.Screen
import zubkov.vadim.monkeyfilm.home.ui.HomeViewModel
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.RegisterScreen
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.ui.RegisterViewModel

@Composable
fun Navigation(userViewModel: UserViewModel) {
    val homeViewModel = HomeViewModel()
    val registerViewModel = RegisterViewModel()

    homeViewModel.devolverLista()
    //val ApiService: RetrofitHelper = RetrofitHelper.getRetrofit().create(RetrofitHelper::class.java)
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.Login.route) {
        composable(route = Routes.Home.route) {
            Login(
                navigationController = navigationController,
                userViewModel = userViewModel
            )
        }
        composable(route = Routes.Register.route) {
            RegisterScreen(
                navigationController = navigationController,
                registerViewModel = registerViewModel
            )
        }
        composable(route = Routes.Screen.route) {
            Screen(
                navigationController = navigationController
            )
        }
    }
}