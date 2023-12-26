package com.devapps.justspeak_10.ui.Screens.German


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.R
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.destinations.GermanGrammarScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanPhrasesScreen
import com.devapps.justspeak_10.ui.destinations.GermanQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanTriviaScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.destinations.Signup
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.viewmodels.AuthViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@Composable
fun GermanNavigation(startNavController: NavController) {
    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel = viewModel<AuthViewModel>()
    val state by authViewModel.state.collectAsStateWithLifecycle()
    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }
    val germanNavController = rememberNavController()
    NavHost(navController = germanNavController, startDestination = GermanHomeScreen.route) {
        composable(GermanHomeScreen.route) {
            GermanHomeContent(
                userData = googleClientAuth.getSignedInUser(),
                cardNavController = germanNavController,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(GermanGrammarScreen.route) {

        }
        composable(GermanPhrasesScreen.route) {

        }
        composable(GermanTriviaScreen.route) {

        }
        composable(GermanQuizScreen.route) {

        }
        composable(Signout.route) {
            LaunchedEffect(Unit) {
                googleClientAuth.signOut()
                startNavController.navigate(Signup.route)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanHomeContent(
    userData: UserData?,
    cardNavController: NavController,
    onSignOut: () -> Unit
) {
        Surface(
            modifier = Modifier
        ) {
            val showMenu = remember { mutableStateOf(false) }
            Scaffold(
                containerColor = Color.White,
                topBar = { TopAppBar(title = { Text(
                    "JustSpeak",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)},
                    actions = {
                        IconButton(onClick = { showMenu.value = true}) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = null,
                                tint = AzureBlue
                            )
                        }
                        DropdownMenu(
                            expanded = showMenu.value,
                            onDismissRequest = {
                                showMenu.value = false
                            },
                            modifier = Modifier
                                .background(color = Color.White)
                                .width(80.dp)) {
                            DropdownMenuItem(
                                text = {
                                       Text(text = "Logout",
                                           color = Color.Black)
                                },
                                onClick = {
                                          cardNavController.navigate(Signout.route)
                                    onSignOut()
                                },
                                modifier = Modifier
                                    .background(color = Color.White))
                        }
                    },
                modifier = Modifier
                    .fillMaxWidth(),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = AzureBlue
                    )
                    )
                 }
            ) { it ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(color = Color.LightGray)
                ) {

                    UserBar(userData)
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        Spacer(modifier = Modifier
                            .height(20.dp))
                        Spacer(modifier = Modifier
                            .height(20.dp))
                        Text(text = "Let's started with...",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier
                            .height(20.dp))
                        LazyVerticalGrid(columns = GridCells.Fixed(2),
                            content = {
                                items(4) { i ->
                                    val cardItem = items[i]
                                }
                            })
                    }
                }
        }

        }

    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanCard(
    onClick: () -> Unit,
    icon: Int,
    cardTitle: String
) {
    ElevatedCard(
        onClick = {
                  onClick()
        },
        colors = CardDefaults.cardColors( containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .height(170.dp)
            .width(150.dp)
            .padding(all = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                )
            Text(text = cardTitle,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowGermanScreens() {
    
}