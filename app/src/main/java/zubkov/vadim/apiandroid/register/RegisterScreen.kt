package zubkov.vadim.apiandroid.register

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zubkov.vadim.apiandroid.nav.Routes

@Composable
fun RegisterScreen(navigationController: NavHostController, loginViewModel: Any) {
    Text("Hola")
    Button(
        onClick = {
            navigationController.navigate(Routes.Login.route)
        }
    ) {
        Text("Click")
    }
}