package zubkov.vadim.apiandroid.register

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zubkov.vadim.apiandroid.login.ui.LoginViewModel
import zubkov.vadim.apiandroid.nav.Routes
import zubkov.vadim.monkeyfilm.home.ui.HomeViewModel

@Composable
fun RegisterScreen(navigationController: NavHostController, loginViewModel: HomeViewModel) {
    Text("Hola")
    Button(
        onClick = {
            navigationController.navigate(Routes.Home.route)
        }
    ) {
        Text("Click")
    }
}