package zubkov.vadim.apiandroid.login.ui

import zubkov.vadim.apiandroid.R

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import zubkov.vadim.apiandroid.login.data.UserModel
import zubkov.vadim.apiandroid.nav.Routes


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navigationController: NavHostController,
){
    LazyColumn(
        modifier = Modifier
            .background(Brush.linearGradient(0f to Color(0xFF00658C), 1000f to Color(0xFFE3FAFF)))
            .height(608.dp)
    ) {
        Log.i("Hola","asd")
        items(loginViewModel.listaUsers.value!!.size) { index ->
            Log.i("Hola","Entro")
            val film = loginViewModel.listaUsers.value!![index]
            Text("${film.nombre}")
        }
    }
}