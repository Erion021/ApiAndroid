package zubkov.vadim.apiandroid.login.ui

import zubkov.vadim.apiandroid.R

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import zubkov.vadim.apiandroid.nav.Routes


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navigationController: NavHostController,
){
    Box(
        Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(0f to Color(0xFF00658C), 1000f to Color(0xFFE3FAFF)))
    ) {
        val isLoading: Boolean by loginViewModel
            .isLoading.observeAsState(initial = false)

        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            Cabecera(
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp))
            Cuerpo(
                Modifier
                    .align(Alignment.Center)
                    .padding(8.dp), loginViewModel,navigationController)
            PieDePagina(
                Modifier
                    .align(Alignment.BottomCenter),
                navigationController
            )
        }
    }
}

@Composable
fun Cabecera(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = stringResource(id = R.string.close_app),
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Cuerpo(modifier: Modifier, loginViewModel: LoginViewModel,navigationController: NavHostController) {
    val id: String by loginViewModel.id.observeAsState(initial = "")
    val name: String by loginViewModel.name.observeAsState(initial = "")
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isButtonLoginEnable.observeAsState(initial = false)

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.app_title),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            color = Color(0xFF0D78AA)
        )
        id(id) {
            loginViewModel.onLoginChanged(id = it,name = name,email = email, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        name(name) {
            loginViewModel.onLoginChanged(id = id, name = it,email = email, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Email(email) {
            loginViewModel.onLoginChanged(id = id,name = name,email = it, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {
            loginViewModel.onLoginChanged(id = id,name = name,email = email, password = it)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End),email){
            loginViewModel.onLoginChanged(id = id,name = name,email = it, password = password)
        }
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable, loginViewModel,navigationController)
    }
}
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = stringResource(id = R.string.email), color = Color(0xFF00658C))
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFC9FAFE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun id(id: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = id,
        onValueChange = {
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = stringResource(id = R.string.email), color = Color(0xFF00658C))
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFC9FAFE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun name(name: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = stringResource(id = R.string.email), color = Color(0xFF00658C))
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFC9FAFE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = {
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(stringResource(id = R.string.password), color = Color(0xFF00658C))
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFC9FAFE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = imagen,
                    contentDescription = stringResource(id = R.string.show_password),
                    tint = Color(0xFF00658C)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ForgotPassword(modifier: Modifier,email: String, onTextChanged: (String) -> Unit) {
    var openDialog by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.forgot_password)),
        onClick = {
            openDialog = !openDialog
        },
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D78AA)
        ),
        modifier = modifier
    )

    if (openDialog){
        AlertDialog(
            onDismissRequest = { openDialog = false },
            text = {
                Text(text = stringResource(id = R.string.dialog_text), color = Color(0xFF00658C))
            },
            buttons = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(18.dp)
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            onTextChanged(it)
                        },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.email),
                                color = Color(0xFF00658C)
                            )
                        },
                        trailingIcon = {
                            if(isError){
                                Icon(
                                    Icons.Filled.Error,
                                    "error",
                                    tint = Color.Red
                                )
                            }
                        },
                        maxLines = 1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color(0xFFB2B2B2),
                            backgroundColor = Color(0xFFC9FAFE),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                    if(isError){
                        Text(
                            text = "Correo no valido",
                            color = Color.Red,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                    Spacer(Modifier.padding(5.dp))
                    Button(
                        onClick = {
                            if(email.contains("@") and email.contains(".")){
                                openDialog = false
                            } else {
                                isError = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF02BAD6),
                            disabledBackgroundColor = Color(0xFF02BAD6),
                            contentColor = Color.White,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Text(text = stringResource(id = R.string.enviar))
                    }
                    Spacer(Modifier.padding(5.dp))
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Cancelar", color = Color(0xFF00658C))
                    }
                }
            },
            backgroundColor = Color(0xFFE3FAFF),
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, loginViewModel: LoginViewModel,navigationController: NavHostController) {
    Button(
        onClick = {
            loginViewModel.onButtonLoginPress(navigationController)
        },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF02BAD6),
            disabledBackgroundColor = Color(0xFF02BAD6),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = stringResource(id = R.string.log_in))
    }
}

@Composable
fun PieDePagina(modifier: Modifier,navigationController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFF0D78AA))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp(navigationController)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp(navigationController : NavHostController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.sign_up_question),
            fontSize = 12.sp,
            color = Color(0xFF02BAD6)
        )
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.sign_up)),
            onClick = {
                navigationController.navigate(route = Routes.Register.route)
            },
            modifier = Modifier.padding(horizontal = 8.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D78AA)
            )
        )
    }
}