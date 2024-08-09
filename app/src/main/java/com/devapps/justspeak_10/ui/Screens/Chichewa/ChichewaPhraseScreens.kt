package com.devapps.justspeak_10.ui.Screens.Chichewa

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
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.ui.Components.ChichewaCrimePhraseList
import com.devapps.justspeak_10.ui.Components.ChichewaDaysList
import com.devapps.justspeak_10.ui.Components.ChichewaDiningPhraseList
import com.devapps.justspeak_10.ui.Components.ChichewaExpressionList
import com.devapps.justspeak_10.ui.Components.ChichewaGeneralEmergencyList
import com.devapps.justspeak_10.ui.Components.ChichewaGoodbyeList
import com.devapps.justspeak_10.ui.Components.ChichewaGreetingsList
import com.devapps.justspeak_10.ui.Components.ChichewaIntroductionPhraseList
import com.devapps.justspeak_10.ui.Components.ChichewaKeyWordList
import com.devapps.justspeak_10.ui.Components.ChichewaMedicalEmergencyList
import com.devapps.justspeak_10.ui.Components.ChichewaQuestionsList
import com.devapps.justspeak_10.ui.Components.ChichewaShoppingList
import com.devapps.justspeak_10.ui.Components.GermanBasicExpressionList
import com.devapps.justspeak_10.ui.Components.GermanCrimeEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanGoodbyeList
import com.devapps.justspeak_10.ui.Components.GermanGreetingExpressionList
import com.devapps.justspeak_10.ui.Components.GermanGreetingList
import com.devapps.justspeak_10.ui.Components.GermanIntroductionExpressionList
import com.devapps.justspeak_10.ui.Components.GermanMedicalEmergencyList
import com.devapps.justspeak_10.ui.Components.GermanPhraseCard
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Screens.German.GermanEating
import com.devapps.justspeak_10.ui.Screens.German.GermanEmergency
import com.devapps.justspeak_10.ui.Screens.German.GermanExpressions
import com.devapps.justspeak_10.ui.Screens.German.GermanIntroductions
import com.devapps.justspeak_10.ui.Screens.German.GermanQuestion
import com.devapps.justspeak_10.ui.Screens.German.GermanTime
import com.devapps.justspeak_10.ui.Screens.German.PhraseListItem
import com.devapps.justspeak_10.ui.destinations.ChichewaEatingScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaEmergencyScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaExpressionScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaHomeScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaIntroductionScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaPhraseListScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaQuestionScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaTimeScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChichewaPhraseScreen(
    chichewaPhraseNavController: NavController,
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
                            chichewaPhraseNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = { chichewaPhraseNavController.navigate(ChichewaHomeScreen.route)
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
                ChichewaPhraseNavigation(chichewaPhraseNavController)
            }
        }


    }

}

@Composable
fun ChichewaPhraseNavigation(navController: NavController) {

    val chichewaPhraseNavController = rememberNavController()

    NavHost(navController = chichewaPhraseNavController,
        startDestination = ChichewaPhraseListScreen.route) {
        composable(ChichewaPhraseListScreen.route) {
            ChichewaPhraseListLandingScreen(chichewaPhraseNavController)
        }
        composable(ChichewaIntroductionScreen.route) {
            ChichewaIntroductions()
        }
        composable(ChichewaExpressionScreen.route) {
            ChichewaExpressions()
        }
        composable(ChichewaEatingScreen.route) {
            ChichewaDiningAndEating()
        }
        composable(ChichewaEmergencyScreen.route) {
            ChichewaEmergency()
        }
        composable(ChichewaQuestionScreen.route) {
            ChichewaQuestion()
        }
        composable(ChichewaTimeScreen.route) {
            ChichewaTime()
        }
    }
}


@Composable
fun ChichewaPhraseListLandingScreen(
    navController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val topics = listOf(
        PhraseListItem(
            itemTitle = "Introductions",
            itemDescription = "Learn to introduce yourself the Malawian way. Distinguish the formal" +
                    "from informal greetings, learn the appropriate greeting based on the time!",
            itemRoute = ChichewaIntroductionScreen.route
        ),
        PhraseListItem(
            itemTitle = "Expressions",
            itemDescription = "Master the art of expressing yourself the right wy in German, learn" +
                    "the commonly used phrases in day to day life to get by easily.",
            itemRoute = ChichewaExpressionScreen.route
        ),
        PhraseListItem(
            itemTitle = "Dining and Shopping",
            itemDescription = "Key phrases when you go out to enjpy fine dining or when you visit the" +
                    " bustling markets of Malawi",
            itemRoute = ChichewaEatingScreen.route
        ),
        PhraseListItem(
            itemTitle = "Emergencies",
            itemDescription = "Learn the key phrases in emergency situations so that you are not " +
                    "tongue tied when something happens unexpectedly.",
            itemRoute = ChichewaEmergencyScreen.route
        ),
        PhraseListItem(
            itemTitle = "Questions",
            itemDescription = "Learning how to ask and structure questions is a key component when" +
                    " it comes to speaking Chichewa",
            itemRoute = ChichewaQuestionScreen.route
        ),
        PhraseListItem(
            itemTitle = "Time",
            itemDescription = "Days of the week and telling the time",
            itemRoute = ChichewaTimeScreen.route
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
fun ChichewaIntroductions() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = LightGray)
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
                    text = "In Malawian culture, politeness and courtesy is important. Learn key " +
                            "introduction phrases as ice breakers:"
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
                ChichewaGreetingsList()
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
                ChichewaGoodbyeList()
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
                    text = "Introduction phrases",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                ChichewaIntroductionPhraseList()
            }
        }
    }
}

@Composable
fun ChichewaExpressions() {
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
                        "will find a list of common basic phrases you will often hear in your chichewa" +
                        "learning journey:"
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ChichewaExpressionList()
        }
    }
}

@Composable
fun ChichewaDiningAndEating() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = LightGray)
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
                    text = "Shopping and Dining",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Learn key phrases which can come in handy when you either go shopping or" +
                            " dining in chichewa speaking areas:"
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
                    text = "Shopping",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                ChichewaShoppingList()
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
                    text = "Dining",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                ChichewaDiningPhraseList()
            }
        }
    }
}

@Composable
fun ChichewaEmergency() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = LightGray)
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
                            "off guard when it happens. Below you will learn general emergency " +
                            "phrases as well as medical and crime related"
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
                ChichewaGeneralEmergencyList()
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
                ChichewaMedicalEmergencyList()
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
                ChichewaCrimePhraseList()
            }
        }
    }
}

@Composable
fun ChichewaQuestion() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = LightGray)
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
                Text(
                    text = "Questions form an essential part of a language. They allow people to " +
                            "acquire pieces of information from others. This section focuses on how " +
                            "questions are formed and example questions in chichewa"
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
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
                Text(text = "Question key words",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "In chichewa, questions can be formulated in different ways, below" +
                        " is a list of words to look out for to be able to tell if it is a question" +
                        " or not. Many of these can be added as prefixes to verbs:"
                )
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )
                ChichewaKeyWordList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
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
                Text(text = "Example Questions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "This section has a set of example sentences and how the keywords above " +
                            "can be used in sentences:"
                )
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )
                ChichewaQuestionsList()
            }
        }
    }
}

@Composable
fun ChichewaTime() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = LightGray)
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
                    text = "Days, Months and Time",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "This section covers on time related vocabulary in chichewa, below you will" +
                            " find lists of days, months and a few phrases on telling the time."
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
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
                    text = "Days (Masiku)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                ChichewaDaysList()
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
                    text = "Months (Miyezi) and time (Nthawi)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Months in Chichewa are the same as in English, sometimes they are " +
                        "pronounced with a corruption but generally the same as english, thus no months" +
                        " list."
                )
                Spacer(
                    modifier = Modifier
                        .height(7.dp)
                )
                Text(
                    text = "Telling the time in chichewa is similar to the way it is done in English"
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun ChichewaScreensPreview() {
    ChichewaQuestion()
}