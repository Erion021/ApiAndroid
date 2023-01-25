package zubkov.vadim.monkeyfilm.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navigationController: NavHostController, homeViewModel: HomeViewModel) {
    Content(homeViewModel,navigationController)
}

@Composable
fun Content(homeViewModel: HomeViewModel, navigationController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .background(Brush.linearGradient(0f to Color(0xFF00658C), 1000f to Color(0xFFE3FAFF)))
            .height(608.dp)
    ) {
        items(homeViewModel.listaPelis.value!!.size) { index ->
            val film = homeViewModel.listaPelis.value!![index]
            Text("${film.nombre}")
        }
    }
}
