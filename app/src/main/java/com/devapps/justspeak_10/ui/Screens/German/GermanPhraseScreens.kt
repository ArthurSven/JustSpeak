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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.devapps.justspeak_10.ui.Components.GermanBasicExpressionList
import com.devapps.justspeak_10.ui.Components.GermanCrimeEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanEatingPhraseList
import com.devapps.justspeak_10.ui.Components.GermanEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanFormQuestionList
import com.devapps.justspeak_10.ui.Components.GermanGoodbyeList
import com.devapps.justspeak_10.ui.Components.GermanGreetingExpressionList
import com.devapps.justspeak_10.ui.Components.GermanGreetingList
import com.devapps.justspeak_10.ui.Components.GermanIntroductionExpressionList
import com.devapps.justspeak_10.ui.Components.GermanMedicalEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanPhraseCard
import com.devapps.justspeak_10.ui.Components.GermanQuestionStarterList
import com.devapps.justspeak_10.ui.Components.GermanShoppingList
import com.devapps.justspeak_10.ui.Components.GermanTimeEssentialsList
import com.devapps.justspeak_10.ui.Components.GermanTimeList
import com.devapps.justspeak_10.ui.Components.GermanVerbQuestionList
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.makeBulletedList
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
        composable(GermanEatingScreen.route) {
            GermanEating()
        }
        composable(GermanEmergencyScreen.route) {
            GermanEmergency()
        }
        composable(GermanQuestionsScreen.route) {
            GermanQuestion()
        }
        composable(GermanTimeScreen.route) {
            GermanTime()
        }
    }
}


@Composable
fun GermanPhraseListLandingScreen(
    navController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val topics = listOf(
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
            itemTitle = "Dining and Shopping",
            itemDescription = "Imagine yourself at a nice cafe in Vienna... Learn to express yourself " +
                    "when you go out shopping or to dine.",
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
            .background(color = offWhite)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
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
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
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
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
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
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
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
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Introduction phrases",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanIntroductionExpressionList()
            }
        }
    }
}

@Composable
fun GermanExpressions() {
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(all = 10.dp)
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
                text = "Expressions help us form common sentences we use in a language, below you " +
                        "will find a list of common basic phrases you will often hear in your german" +
                        "learning journey:"
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            GermanBasicExpressionList()
        }
    }
}

@Composable
fun GermanEating() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = offWhite)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Dining and Shopping",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Dining and shopping are essential part of modern day life. Perhaps you" +
                            " fancy a good dinner or a shopping spree in the German speaking world, this" +
                            " section covers both dining out and shopping:"
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Dining out",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanEatingPhraseList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Shopping",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanShoppingList()
            }
        }
    }
}

@Composable
fun GermanEmergency() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = offWhite)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Emergencies",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Emergencies can occur without warning, however you should not be caught " +
                            "off guard when it happens in the German speaking world. Below you will " +
                            "learn general emergency phrases as well as medical and crime related"
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "General Emergencies",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanEmergencyList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Medical Emergencies",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanMedicalEmergencyList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Crime Emergencies",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanCrimeEmergencyList()
            }
        }
    }
}

@Composable
fun GermanQuestion() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Questions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(text = "Questions are an essential aspect of language learning. Questions " +
                        "enable you to ask for information regarding interests. Knowing how to ask" +
                        " questions in German enables you to find out more about things you are " +
                        "curious about")
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Common question starters",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "Below are some common words we use to form questions in German:")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanQuestionStarterList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "How to form questions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "To form questions, we use the common question starters at the beginning" +
                        " of the sentence. The sentence is usually followed by a verb much like it is " +
                        "in english with which being the exception:"
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanFormQuestionList()

            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Forming questions with verbs",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "There are some instances where questions can be formed not wth the Ws" +
                        " but verbs. In english this is equivalent to questions that start with does," +
                        " do, are, will, etc. These questions start with the verb at the beginning:"
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanVerbQuestionList()
            }
        }
            }
}

@Composable
fun GermanTime() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Telling the time",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "In the German speaking world, time is of essence. Time is taken very" +
                            "seriously, that means try your best to be at least 5 minutes early. " +
                            "This section teaches you how to read and tell time in German:"
                )
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Essential phrases for time",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "The following are phrases key to telling the time in German:")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanTimeEssentialsList()
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(all = 10.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "How to tell the time",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                val items = listOf<String>(
                    "In german, if the time has the word nach, it is equivalent to the word past",
                    "The word vor is equivalent to the word to: Viertel vor Neun (Quarter to nine)",
                    "In german if the time is 8:30, it will not be halb acht rather halb neun",
                    "easiest way to tell minutes is to say the number of the minutes then either " +
                            "vor or nach and the the hour"
                )
                Text(text = makeBulletedList(items = items))
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "The following are different examples of telling time in German:"
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                GermanTimeList()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewPhraseScreens() {
    GermanTime()
}