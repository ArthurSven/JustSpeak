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
import com.devapps.justspeak_10.ui.Components.ChichewaAdjectiveList
import com.devapps.justspeak_10.ui.Components.ChichewaAlphabetList
import com.devapps.justspeak_10.ui.Components.ChichewaPeopleNounList
import com.devapps.justspeak_10.ui.Components.ChichewaPlaceNounsList
import com.devapps.justspeak_10.ui.Components.ChichewaVowelsList
import com.devapps.justspeak_10.ui.Components.GermanAlphabetList
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Screens.German.GermanAdjectives
import com.devapps.justspeak_10.ui.Screens.German.GermanAlphabet
import com.devapps.justspeak_10.ui.Screens.German.GermanCases
import com.devapps.justspeak_10.ui.Screens.German.GermanGrammarItemScreen
import com.devapps.justspeak_10.ui.Screens.German.GermanGrammarNavigation
import com.devapps.justspeak_10.ui.Screens.German.GermanNouns
import com.devapps.justspeak_10.ui.Screens.German.GermanPrepositions
import com.devapps.justspeak_10.ui.Screens.German.GermanPronouns
import com.devapps.justspeak_10.ui.Screens.German.GermanSentenceStructure
import com.devapps.justspeak_10.ui.Screens.German.GermanTenses
import com.devapps.justspeak_10.ui.Screens.German.GermanVerbsAndConjugation
import com.devapps.justspeak_10.ui.Screens.German.GrammarListItem
import com.devapps.justspeak_10.ui.destinations.ChichewaAdjectiveScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaAlphabetScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaGrammarItemScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaHomeScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaNounScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaNumbersScreen
import com.devapps.justspeak_10.ui.destinations.ChichewaPronounScreen
import com.devapps.justspeak_10.ui.destinations.GermanAdjectiveScreen
import com.devapps.justspeak_10.ui.destinations.GermanAlphabetScreen
import com.devapps.justspeak_10.ui.destinations.GermanCaseScreen
import com.devapps.justspeak_10.ui.destinations.GermanGrammarItemScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanNounScreen
import com.devapps.justspeak_10.ui.destinations.GermanPrepositionScreen
import com.devapps.justspeak_10.ui.destinations.GermanPronounScreen
import com.devapps.justspeak_10.ui.destinations.GermanSentenceStructureScreen
import com.devapps.justspeak_10.ui.destinations.GermanTenseScreen
import com.devapps.justspeak_10.ui.destinations.GermanVerbConjugationScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.theme.offWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChichewaGrammarScreen(
    chichewaGrammarNavController: NavController,
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
                            chichewaGrammarNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(onClick = {
                    chichewaGrammarNavController.navigate(ChichewaHomeScreen.route)
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
                .background(color = Color.LightGray)
        ) {
            UserBar(userData)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                ChichewaGrammarNavigation(chichewaGrammarNavController)
            }
        }

    }
}

@Composable
fun ChichewaGrammarNavigation(grammarNavController: NavController) {

    val chichewaGrammarNavController = rememberNavController()
    NavHost(navController = chichewaGrammarNavController,
        startDestination = ChichewaGrammarItemScreen.route) {
        composable(ChichewaGrammarItemScreen.route) {
            ChichewaGrammarItemScreen(chichewaGrammarNavController)
        }
        composable(ChichewaAlphabetScreen.route) {
            ChichewaAlphabet()
        }
        composable(ChichewaAdjectiveScreen.route) {
            ChichewaAdjectives()
        }
        composable(ChichewaNounScreen.route) {
            ChichewaNouns()
        }
        composable(ChichewaNumbersScreen.route) {
            GermanNouns()
        }

        composable(GermanPronounScreen.route) {
            GermanPronouns()
        }
    }
}

@Composable
fun ChichewaGrammarItemScreen(navController: NavController) {

    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        GrammarListItem(
            itemTitle = "Alphabet",
            itemRoute = ChichewaAlphabetScreen.route
        ),
        GrammarListItem(
            itemTitle = "Adjectives",
            itemRoute = ChichewaAdjectiveScreen.route
        ),
        GrammarListItem(
            itemTitle = "Nouns",
            itemRoute = ChichewaNounScreen.route
        ),
        GrammarListItem(
            itemTitle = "Numbers",
            itemRoute = ChichewaNumbersScreen.route
        ),
        GrammarListItem(
            itemTitle = "Pronouns",
            itemRoute = ChichewaPronounScreen.route
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
    ) {
        Spacer(modifier = Modifier
            .height(20.dp))
        Text(text = "Grammar Items",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black)
        Spacer(modifier = Modifier
            .height(10.dp))
        LazyColumn(content = {
            items(items.size) {i->
                val listItem = items[i]
                GrammarListItem(
                    selected = selectedItemIndex == i,
                    listTitle = listItem.itemTitle,
                    onClick = {
                        navController.navigate(listItem.itemRoute)
                    } )
            }
        }
        )
    }
}

@Composable
fun ChichewaAlphabet() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp),
        colors = CardDefaults.cardColors( containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(all = 10.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp))
            Text(text = "Alphabet (Afabeti)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(20.dp)
            )
            Text(text = "The following is an alphabet list in chichewa together with how each letter" +
                    "is pronounced"
            )
            Spacer(modifier = Modifier
                .height(10.dp)
            )
            ChichewaAlphabetList()
            Spacer(modifier = Modifier
                .height(10.dp)
            )
            Text(text = "In foundational years, children are taught vowel sounds as this plays a " +
                    "crucial role in pronunciation. Below is a list of vowels and their sounds:"
            )
            Spacer(modifier = Modifier
                .height(10.dp)
            )
            ChichewaVowelsList()
        }
    }
}

@Composable
fun ChichewaAdjectives() {
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
                    text = "Adjectives",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(text = "Adjectives are used to describe nouns. In chichewa some adjectives can" +
                        " be added as a suffix Below is a list of adjectives commonly used in chichewa:"
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                ChichewaAdjectiveList()
            }
        }
    }
}

@Composable
fun ChichewaNouns() {
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
                    text = "Nouns",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(text = "Nouns are objects and things we interact with. In this section you will" +
                        " learn basic nouns you will constantly encounter in chichewa."
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
                Text(
                    text = "People nouns",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ChichewaPeopleNounList()
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
                Text(
                    text = "Place nouns",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ChichewaPlaceNounsList()
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
                Text(
                    text = "Food and drink nouns",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ChichewaPlaceNounsList()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewChichewaGrammarScreens() {
    ChichewaNouns()
}