package com.devapps.justspeak_10.ui.Screens.Chichewa

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
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
import com.devapps.justspeak_10.ui.Components.profileCard
import com.devapps.justspeak_10.ui.Screens.German.CardItem
import com.devapps.justspeak_10.ui.Screens.German.GermanCard
import com.devapps.justspeak_10.ui.destinations.ChichewaFlashcardScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaGrammarScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaHomeScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaPhraseScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaQuizScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaTriviaScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.destinations.Signup
import com.devapps.justspeak_10.ui.destinations.Start
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.theme.offWhite
import com.devapps.justspeak_10.ui.viewmodels.AuthViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@Composable
fun ChichewaNavigation(startNavController: NavController) {
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
    val chichewaNavController = rememberNavController()
    NavHost(navController = chichewaNavController, startDestination = ChichewaHomeScreen.route) {
        composable(ChichewaHomeScreen.route) {
            ChichewaHomeContent(
                userData = googleClientAuth.getSignedInUser(),
                cardNavController = chichewaNavController,
                backNavController = startNavController,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ChichewaGrammarScreen.route) {
            ChichewaGrammarScreen(
                chichewaNavController,
                userData = googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ChichewaPhraseScreen.route) {
            ChichewaPhraseScreen(
                chichewaNavController,
                userData = googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ChichewaQuizScreen.route) {
            ChichewaQuizScreen(
                chichewaNavController,
                userData = googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(ChichewaFlashcardScreen.route) {
            ChichewaFlashScreen(
                chichewaNavController,
                userData = googleClientAuth.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
                )
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
fun ChichewaHomeContent(
    userData: UserData?,
    cardNavController: NavController,
    backNavController: NavController,
    onSignOut: () -> Unit
) {

    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
    ) {
        val showMenu = remember { mutableStateOf(false) }
        Scaffold(
            containerColor = Color.White,
            topBar = { CenterAlignedTopAppBar(title = { Text(
                "JustSpeak",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            },
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
                navigationIcon = {
                    IconButton(onClick = {
                        backNavController.navigate(Start.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "exit button",
                            tint = AzureBlue
                        )
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
                    .background(color = offWhite)
            ) {

                UserBar(userData)
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    profileCard(
                        AzureBlue,
                        R.drawable.malawi,
                        "Chichewa Lesson",
                        Color.Blue )
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    Text(text = "Let's start with...",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier
                        .height(20.dp))

                    val items = listOf(
                        CardItem(
                            cardTitle = "Grammar",
                            cardIcon = R.drawable.grammar,
                            cardRoute = ChichewaGrammarScreen.route
                        ),
                        CardItem(
                            cardTitle = "Phrases",
                            cardIcon = R.drawable.phrase,
                            cardRoute = ChichewaPhraseScreen.route
                        ),
                        CardItem(
                            cardTitle = "Quizzes",
                            cardIcon = R.drawable.quiz,
                            cardRoute = ChichewaQuizScreen.route
                        ),
                        CardItem(
                            cardTitle = "Trivia",
                            cardIcon = R.drawable.trivia,
                            cardRoute = ChichewaTriviaScreen.route
                        ),
                        CardItem(
                            cardTitle = "FlashCards",
                            cardIcon = R.drawable.flashcards,
                            cardRoute = ChichewaFlashcardScreen.route
                        )
                    )
                    LazyVerticalGrid(columns = GridCells.Fixed(2),
                        content = {
                            items(items.size) { i ->
                                val cardItem = items[i]
                                GermanCard(
                                    selected = selectedItemIndex == i,
                                    onClick = {
                                        cardNavController.navigate(cardItem.cardRoute)
                                    },
                                    icon = cardItem.cardIcon,
                                    cardTitle = cardItem.cardTitle
                                )
                            }
                        }
                    )
                }
            }
        }

    }

}