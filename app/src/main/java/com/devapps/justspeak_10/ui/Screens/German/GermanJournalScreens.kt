package com.devapps.justspeak_10.ui.Screens.German

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanJournalCreateScreen
import com.devapps.justspeak_10.ui.destinations.GermanJournalEditScreen
import com.devapps.justspeak_10.ui.destinations.GermanJournalHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanJournalReadScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanJournalScreen(
    germanJournalNavController: NavController,
    userData: UserData?,
    onSignOut: () -> Unit) {
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
                            germanJournalNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = { germanJournalNavController.navigate(GermanHomeScreen.route)
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
    ) {
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
                GermanJournalNavigation(germanJournalNavController)
            }
        }


    }

}

@Composable
fun GermanJournalNavigation(germanJNavController: NavController) {

    val germanJournalsNavController = rememberNavController()

    NavHost(navController = germanJournalsNavController, startDestination = GermanJournalHomeScreen.route) {
        composable(GermanJournalHomeScreen.route) {

        }
        composable(GermanJournalCreateScreen.route) {

        }
        composable(GermanJournalEditScreen.route) {

        }
        composable(GermanJournalReadScreen.route) {

        }
    }
}

@Composable
fun GermanJournalHome() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(10.dp)
    ) {
        Text(text = "Journeys on JustSpeak",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )


    }
}

@Composable
@Preview(showBackground = true)
fun showJournalScreens() {
    GermanJournalHome()
}