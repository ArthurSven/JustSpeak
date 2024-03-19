package com.devapps.justspeak_10.ui.Screens.German

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth
import com.devapps.justspeak_10.ui.Components.GridItem
import com.devapps.justspeak_10.ui.Components.RandomColorBox
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.getCurrentDate
import com.devapps.justspeak_10.ui.destinations.GermanAddFlashcardScreen
import com.devapps.justspeak_10.ui.destinations.GermanFlashcardListScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.viewmodels.AuthViewModel
import com.devapps.justspeak_10.ui.viewmodels.FlashcardViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanFlashScreen(
    germanFlashcardNavController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit) {

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

    val flashCardNavController = rememberNavController()
    NavHost(navController = flashCardNavController, startDestination = GermanFlashcardListScreen.route) {
        composable(GermanFlashcardListScreen.route) {
            com.devapps.justspeak_10.ui.Screens.German.GermanFlashcardListScreen(
                germanFlashcardListNavController = flashCardNavController,
                germanFlashcardNavController,
                userData = userData,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(GermanAddFlashcardScreen.route) {
          GermanAddFlashCard(
              germanAddFlashcardNavController = flashCardNavController,
              germanFlashcardNavController,
              userData = userData,
              onSignOut = {
                  coroutineScope.launch {
                      googleClientAuth.signOut()
                      Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                  }
              })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanFlashcardListScreen(
    germanFlashcardListNavController: NavController,
    homeNaviController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    val showMenu = remember { mutableStateOf(false) }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val googleAuthClient by lazy {
        GoogleClientAuth(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val flashcardViewModel: FlashcardViewModel = hiltViewModel()
    val username = googleAuthClient.getSignedInUser()?.username.toString()

    val flashcardState by remember { flashcardViewModel.userFlashcards }.collectAsState(emptyList())

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
                            germanFlashcardListNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        homeNaviController.navigate(GermanHomeScreen.route)
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "exit button",
                        tint = AzureBlue)
                }
            },
            
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = AzureBlue
            )
        )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    germanFlashcardListNavController.navigate(GermanAddFlashcardScreen.route)
            },
                contentColor = Color.White,
                containerColor = AzureBlue
            ) {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Add Flashcard",
                )
                Text(text = "Create Flashcard")
            }
        }
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.LightGray)
        ) {

            LaunchedEffect(username) {
                flashcardViewModel.setCreatedBy(username)
            }
            UserBar(userData)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Your Flashcards",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                if(flashcardState.isEmpty()) {
                    Text(text = "No flashcards available")
                } else {
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(2),
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalItemSpacing = 16.dp
                    ) {
                        itemsIndexed(flashcardState) { index, flashcard ->

                            val randomColor = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
                            val randomHeight = (100..300).random().dp
                            RandomColorBox(
                                GridItem(
                                    germanWord = flashcard.germanTranslation,
                                    englishWord = flashcard.englishTranslation,
                                    height = randomHeight,
                                    color = randomColor
                                )
                            )
                        }
                    }
                }
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanAddFlashCard(
    germanAddFlashcardNavController: NavController,
    homeNaviController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit
) {
    val showMenu = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val googleAuthUiClient by lazy {
        GoogleClientAuth(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val username = googleAuthUiClient.getSignedInUser()?.username.toString()
    val flashcardViewModel: FlashcardViewModel = hiltViewModel()

    val insetResultState by flashcardViewModel.insertResultState.collectAsState()

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
                            germanAddFlashcardNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        germanAddFlashcardNavController.navigate(GermanFlashcardListScreen.route)
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "exit button",
                        tint = AzureBlue)
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

            var germanFlashcard by remember {
                mutableStateOf("")
            }
            var englishTrnslation by remember {
                mutableStateOf("")
            }
            var currentDate = getCurrentDate()

            UserBar(userData)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp)
                        .background(color = Color.White),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .padding(all = 16.dp)
                    ) {
                        Text(
                            text = "Add a Flashcard",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Spacer(
                            modifier = Modifier
                                .height(30.dp)
                        )
                        OutlinedTextField(
                            value = germanFlashcard,
                            onValueChange = { germanFlashcard = it},
                            label = {
                                Text(text = "German")
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        OutlinedTextField(
                            value = englishTrnslation,
                            onValueChange = { englishTrnslation = it},
                            label = {
                                Text(text = "English translation")
                            }
                        )
                        Spacer(modifier = Modifier
                            .height(15.dp)
                        )
                        Button(
                            onClick = {
                                if(germanFlashcard.isNotEmpty() && englishTrnslation.isNotEmpty()) {
                                    val flashcardLocal = FlashcardLocal(
                                        germanTranslation = germanFlashcard,
                                        englishTranslation = englishTrnslation,
                                        creator = username,
                                        dateCreated = currentDate
                                    )
                                    coroutineScope.launch {
                                        flashcardViewModel.insertFlashcard(flashcardLocal)
                                    }
                                } else {
                                    // Display a message if either of the fields is empty
                                    Toast.makeText(context, "Please fill in both German and English " +
                                            "translations.", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier
                                .width(310.dp)
                                .height(40.dp),
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Add flashcard")
                        }
                        LaunchedEffect(insetResultState) {
                            if (insetResultState.isSuccessful) {
                                Toast.makeText(context, "Flashcard has successfully created",
                                    Toast.LENGTH_LONG)
                                    .show()
                                flashcardViewModel.resetState()
                                germanFlashcard = ""
                                englishTrnslation = ""
                            } else {
                                Toast.makeText(context, "Failed to create flashcard: " +
                                        "${insetResultState.error}",
                                    Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }
    }
}

