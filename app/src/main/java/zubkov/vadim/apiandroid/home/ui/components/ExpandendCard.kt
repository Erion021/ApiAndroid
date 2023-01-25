package zubkov.vadim.monkeyfilm.home.ui

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import zubkov.vadim.apiandroid.R
import zubkov.vadim.apiandroid.nav.Routes
import zubkov.vadim.monkeyfilm.home.data.MediaModel

/*
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    navController: NavHostController,
    selectedFilm: MediaModel,
) {
    var expand by remember { mutableStateOf(false) }
    var stroke by remember { mutableStateOf(1) }
    var iconShow by rememberSaveable { mutableStateOf(true) }
    var imagenes = when (selectedFilm.catel){
        1 -> Log.i("a","a")
        else -> Log.i("a","a")
    }
    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 400,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(8.dp),
        backgroundColor = Color(0xFFC9FAFE),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(stroke.dp, Color.Gray),
        onClick = {
            expand = !expand
            stroke = if (expand) 2 else 1
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .padding(10.dp)

                ){
                    Image(
                        painterResource(imagenes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(88.dp)
                    )
                }
                Row(
                    Modifier
                        .width(196.dp)
                ) {
                    Text(
                        text = selectedFilm.title,
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center
                ){
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                    val imagen = if (iconShow) {
                        Icons.Default.FavoriteBorder
                    } else {
                        Icons.Default.Favorite
                    }
                    IconButton(
                        onClick = {
                            iconShow = !iconShow
                            selectedFilm.likes()
                        }
                    ) {
                        Icon(
                            imageVector = imagen,
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            }
            if (expand) {
                Image(
                    painterResource(imagenes),
                    contentDescription = null
                )
                Text(
                    text = "${selectedFilm.genre}",
                    color = Color(0xFF00658C),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
                Text(
                    text = selectedFilm.description,
                    color = Color(0xFF00658C),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}
 */