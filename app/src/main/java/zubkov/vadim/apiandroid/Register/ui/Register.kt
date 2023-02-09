package zubkov.vadim.pruebasandroiddiseo.Screens.Register

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import zubkov.vadim.apiandroid.R
import zubkov.vadim.pruebasandroiddiseo.Screens.Register.ui.RegisterViewModel

var comprobacionRapida = false

@Composable
fun RegisterScreen(navigationController: NavHostController, registerViewModel: RegisterViewModel) {
    var state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Main(state,navigationController,registerViewModel)
    }
}

@Composable
fun Main(state: MutableTransitionState<Boolean>, navigationController: NavHostController, registerViewModel: RegisterViewModel){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painterResource(R.drawable.background),
            contentDescription = "stringResource(id = R.string.icono_descripcion)",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
            alpha = if (isSystemInDarkTheme()) 0.5F else 0.8f
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            RegisterBody(state = state,navigationController,registerViewModel)
        }
    }
}

@Composable
fun RegisterBody(state: MutableTransitionState<Boolean>, navigationController: NavHostController, registerViewModel: RegisterViewModel){
    val name: String by registerViewModel.name.observeAsState(initial = "")
    val email: String by registerViewModel.email.observeAsState(initial = "")
    val password: String by registerViewModel.password.observeAsState(initial = "")
    val repeatPassword: String by registerViewModel.repeatPassword.observeAsState(initial = "")


    AnimatedVisibility(
        visibleState = state,
        enter = fadeIn(
            animationSpec = tween(
                delayMillis = 400,
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
            )
        )
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Spacer(modifier = Modifier.padding(15.dp))
            Box(
                modifier = Modifier.width(275.dp)
            ){
                Column {
                    Name(name){
                        registerViewModel.onRegisterChanged(name = it,email = email, password = password,repeatPassword = repeatPassword)
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Email(email){
                        registerViewModel.onRegisterChanged(name = name,email = it, password = password,repeatPassword = repeatPassword)
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Password(password){
                        registerViewModel.onRegisterChanged(name = name,email = email, password = it,repeatPassword = repeatPassword)
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    RepeatPassword(repeatPassword){
                        registerViewModel.onRegisterChanged(name = name,email = email, password = password,repeatPassword = it)
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                    TermsAndConditions(navigationController)
                    Spacer(modifier = Modifier.padding(5.dp))
                    ButtonRegister(navigationController,registerViewModel)
                }
            }
        }
    }
}

@Composable
fun Title(){
    Text(
        text = "stringResource(id = R.string.titulo)",
        fontSize = 23.sp,
        fontFamily = FontFamily.Default,
        color = Color(0xFFDAD3C8)
    )
}

@Composable
fun Name(name:String, onTextChanged: (String) -> Unit){
    OutlinedTextField(
        value = name,
        onValueChange = {
            onTextChanged(it)
        },
        placeholder = { Text(
            text = "Nombre",
            color = Color(0xFFDAD3C8)
        ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFDAD3C8),
            unfocusedBorderColor = Color(0xFFDAD3C8)
        ),
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun Email(email:String, onTextChanged: (String) -> Unit){
    OutlinedTextField(
        value = email,
        onValueChange = {
            onTextChanged(it)
        },
        placeholder = { Text(
            text = "zubkov.vadim.apiandroid.login.ui.Email",
            color = Color(0xFFDAD3C8)
        ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFDAD3C8),
            unfocusedBorderColor = Color(0xFFDAD3C8)
        ),
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Password(password:String, onTextChanged: (String) -> Unit){
    OutlinedTextField(
        value = password,
        onValueChange = {
            onTextChanged(it)
        },
        placeholder = { Text(
            text = "Contraseña",
            color = Color(0xFFDAD3C8)
        ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFDAD3C8),
            unfocusedBorderColor = Color(0xFFDAD3C8)
        ),
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun RepeatPassword(repeatPassword:String, onTextChanged: (String) -> Unit){
    OutlinedTextField(
        value = repeatPassword,
        onValueChange = {
            onTextChanged(it)
        },
        placeholder = { Text(
            text = "Repetir Contraseña",
            color = Color(0xFFDAD3C8)
        ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFDAD3C8),
            unfocusedBorderColor = Color(0xFFDAD3C8)
        ),
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun ButtonRegister(navigationController: NavHostController,registerViewModel: RegisterViewModel) {
    val mContext = LocalContext.current

    Button(
        onClick = {
            if (comprobacionRapida){
                registerViewModel.onButtonRegisterPress(navigationController,mContext)
            } else {
                Toast.makeText(mContext,"No acepto los terminos y condiciones", Toast.LENGTH_SHORT).show()
            }
        },
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7B7457))
    ){
        Text("Register")
    }
}

@Composable
fun TermsAndConditions(navigationController: NavHostController) {
    var confirmar by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = confirmar,
            onCheckedChange = {
                confirmar = !confirmar
                comprobacionRapida = confirmar
            }
        )
        androidx.compose.foundation.text.ClickableText(
            text = AnnotatedString("Aceptar los terminos de servicios y condiciones para el programa"),
            onClick = {

            },
            style = TextStyle(
                color = Color(0xFFDAD3C8)
            )
        )
    }
}