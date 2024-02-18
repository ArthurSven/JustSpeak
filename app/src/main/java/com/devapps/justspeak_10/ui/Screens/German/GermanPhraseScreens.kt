package com.devapps.justspeak_10.ui.Screens.German

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.devapps.justspeak_10.ui.Components.GermanGoodbyeList
import com.devapps.justspeak_10.ui.Components.GermanGreetingExpressionList
import com.devapps.justspeak_10.ui.Components.GermanGreetingList
import com.devapps.justspeak_10.ui.Components.GermanPhraseCard
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.destinations.GermanEatingScreen
import com.devapps.justspeak_10.ui.destinations.GermanEmergencyScreen
import com.devapps.justspeak_10.ui.destinations.GermanExpressionScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanIntroductionScreen
import com.devapps.justspeak_10.ui.destinations.GermanPhraseListScreen
import com.devapps.justspeak_10.ui.destinations.GermanQuestionsScreen
import com.devapps.justspeak_10.ui.destinations.GermanTimeScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.theme.offWhite

data class PhraseListItem(
    val itemTitle: String,
    val itemDescription: String,
    val itemRoute: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanPhraseScreen(
    germanPhraseNavController: NavController,
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
                            germanPhraseNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                             IconButton(
                                 onClick = { germanPhraseNavController.navigate(GermanHomeScreen.route)
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
            UserBar(userData)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {

                Spacer(modifier = Modifier
                    .height(20.dp))
                GermanPhraseNavigation(germanPhraseNavController)
            }
        }


    }

}

@Composable
fun GermanPhraseNavigation(navController: NavController) {

    val germanPhraseNavController = rememberNavController()

    NavHost(navController = germanPhraseNavController,
        startDestination = GermanPhraseListScreen.route) {
        composable(GermanPhraseListScreen.route) {
            GermanPhraseListLandingScreen(germanPhraseNavController)
        }
        composable(GermanIntroductionScreen.route) {
            GermanIntroductions()
        }
        composable(GermanExpressionScreen.route) {
            GermanExpressions()
        }
    }
}

@Composable
fun GermanPhraseListLandingScreen(
    navController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val topics = listOf<PhraseListItem>(
        PhraseListItem(
            itemTitle = "Introductions",
            itemDescription = "Learn to introduce yourself the german way. Distinguish the formal" +
                    "from informal greetings, learn the appropriate greeting based on the time!",
            itemRoute = GermanIntroductionScreen.route
        ),
        PhraseListItem(
            itemTitle = "Expressions",
            itemDescription = "Master the art of expressing yourself the right wy in German, learn" +
                    "the commonly used phrases in day to day life to get by easily.",
            itemRoute = GermanExpressionScreen.route
        ),
        PhraseListItem(
            itemTitle = "Eating out",
            itemDescription = "Image yourself at a nice cafe in Vienna... Learn to express yourself " +
                    "when you go out to buy or order a meal, common language used in context of food.",
            itemRoute = GermanEatingScreen.route
        ),
        PhraseListItem(
            itemTitle = "Emergencies",
            itemDescription = "Learn the key phrases in emergency situations so that you are not " +
                    "tongue tied when something happens unexpectedly.",
            itemRoute = GermanEmergencyScreen.route
        ),
        PhraseListItem(
            itemTitle = "Questions",
            itemDescription = "Learning how to ask and structure questions is a key component when" +
                    " it comes to speaking German",
            itemRoute = GermanQuestionsScreen.route
        ),
        PhraseListItem(
            itemTitle = "Tell the time",
            itemDescription = "What time is it? Learn to tell the time the German way, never get" +
                    "caught off-guard with German punctuality.",
            itemRoute = GermanTimeScreen.route
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)

    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Text(
            text = "Phrase topics",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .height(10.dp))
        LazyColumn(content = {
            items(topics.size) {i->
                val topicItem = topics[i]
                GermanPhraseCard(
                    selected = selectedItemIndex == i,
                    phraseTitle = topicItem.itemTitle,
                    phraseDescription = topicItem.itemDescription,
                   onClick =  {
                       navController.navigate(topicItem.itemRoute)
                   })
            }
        })
    }
}

@Composable
fun GermanIntroductions() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Introductions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "In German culture, it is important to introduce yourself when you arrive" +
                            "at a place where there's people. This section will take you through " +
                            "introductions and greetings used in the German speaking world:"
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Greetings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanGreetingList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = "Goodbyes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanGoodbyeList()
            }

        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = "Goodbyes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanGoodbyeList()
            }

        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = "Expressions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanGreetingExpressionList()
            }

        }
    }

}

@Composable
fun GermanExpressions() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Expressions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Expressions are an essential part of the language. These sentences allow " +
                            "learners to carry across messages and help people to speak the language" +
                            "without thinking too much about grammar rules."
                )
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Phrases",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewPhraseScreens() {
    GermanExpressions()
}