package com.devapps.justspeak_10.ui.Screens.German

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.getGermanLetters
import com.devapps.justspeak_10.ui.Components.getGermanSounds
import com.devapps.justspeak_10.ui.destinations.GermanAdjectiveScreen
import com.devapps.justspeak_10.ui.destinations.GermanAlphabetScreen
import com.devapps.justspeak_10.ui.destinations.GermanCaseScreen
import com.devapps.justspeak_10.ui.destinations.GermanGrammarItemScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanNounScreen
import com.devapps.justspeak_10.ui.destinations.GermanPronounScreen
import com.devapps.justspeak_10.ui.destinations.GermanSentenceStructureScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue

data class GrammarListItem(
val itemTitle: String,
    val itemRoute: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanGrammarScreen(
    germanGrammarNavController: NavController,
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
                            germanGrammarNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                             IconButton(onClick = {
                                 germanGrammarNavController.navigate(GermanHomeScreen.route)
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
                GermanGrammarNavigation(germanGrammarNavController)
            }
        }

    }

}

@Composable
fun GermanGrammarNavigation(grammarNavController: NavController) {

    val germanGrammarNavController = rememberNavController()
    NavHost(navController = germanGrammarNavController,
        startDestination = GermanGrammarItemScreen.route) {
        composable(GermanGrammarItemScreen.route) {
            com.devapps.justspeak_10.ui.Screens.German.GermanGrammarItemScreen(
                navController = germanGrammarNavController)
        }
        composable(GermanAlphabetScreen.route) {
            GermanAlphabet()
        }
    }
}

@Composable
fun GermanGrammarItemScreen(navController: NavController) {

    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        GrammarListItem(
            itemTitle = "Alphabet",
            itemRoute = GermanAlphabetScreen.route
        ),
        GrammarListItem(
            itemTitle = "Adjectives",
            itemRoute = GermanAdjectiveScreen.route
        ),
        GrammarListItem(
            itemTitle = "Cases",
            itemRoute = GermanCaseScreen.route
        ),
        GrammarListItem(
            itemTitle = "Nouns",
            itemRoute = GermanNounScreen.route
        ),
        GrammarListItem(
            itemTitle = "Pronouns",
            itemRoute = GermanPronounScreen.route
        ),
        GrammarListItem(
            itemTitle = "Sentence Structure",
            itemRoute = GermanSentenceStructureScreen.route
        ),
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
            fontSize = 24.sp,
            color = Color.Black)
        Spacer(modifier = Modifier
            .height(10.dp))
        LazyColumn(content = {
            items(6) {i->
                val listItem = items[i]
                GrammarListItem(
                    selected = selectedItemIndex == i,
                    listTitle = listItem.itemTitle,
                    onClick = {
                        navController.navigate(listItem.itemRoute)
                    } )
            }
        })
    }
}

@Composable
fun GermanAlphabet() {
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
                .padding(all = 10.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp))
            Text(text = "Alphabet (das Alphabet)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(10.dp))
            GermanAlphabetList()
        }
    }
}

@Composable
fun GermanAlphabetList() {
    val letters = getGermanLetters()
    val sounds = getGermanSounds()

    LazyColumn {
        items(letters) { letter ->
            val index = letters.indexOf(letter)
            val sound = if (index < sounds.size) sounds[index] else ""

            GermanAlphabetItem(letter = letter, sound = sound)
        }
    }
}

@Composable
fun GermanAlphabetItem(letter: String, sound: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        Text(text = letter,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier
            .width(30.dp))
        Text(text = "-",
            fontSize = 20.sp)
        Column(
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Text(text = sound,
                fontSize = 20.sp)
        }
    }
}

@Composable
fun GrammarListItem(
   selected: Boolean,
   listTitle: String,
   onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .height(60.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors( containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = listTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ViewGrammarScreens() {
    Column {
        GermanAlphabetItem("A", "Ah like apple")
        GermanAlphabetItem("B", "Bae like Bear")
    }

}