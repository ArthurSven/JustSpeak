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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.ui.Components.AdjectiveRow
import com.devapps.justspeak_10.ui.Components.CaseParagraph
import com.devapps.justspeak_10.ui.Components.GermanAdjectiveList
import com.devapps.justspeak_10.ui.Components.GermanAlphabetItem
import com.devapps.justspeak_10.ui.Components.GermanAlphabetList
import com.devapps.justspeak_10.ui.Components.GermanDefEndTable
import com.devapps.justspeak_10.ui.Components.GermanDefiniteArticleTable
import com.devapps.justspeak_10.ui.Components.GermanIndEndTable
import com.devapps.justspeak_10.ui.Components.GermanIndefiniteArticleTable
import com.devapps.justspeak_10.ui.Components.GermanPeopleNounList
import com.devapps.justspeak_10.ui.Components.TextsForArticles
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.getEnglishAdjectives
import com.devapps.justspeak_10.ui.Components.getGermanAdjectiveExamples
import com.devapps.justspeak_10.ui.Components.getGermanAdjectives
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
import com.google.common.io.Files.append

data class GrammarListItem(
val itemTitle: String,
    val itemRoute: String
)

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
        composable(GermanAdjectiveScreen.route) {
            GermanAdjectives()
        }
        composable(GermanCaseScreen.route) {
            GermanCases()
        }
        composable(GermanNounScreen.route) {
            GermanNouns()
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
            Text(text = "Alphabet",
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
fun GermanAdjectives() {
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(all = 10.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp))
            Text(text = "Adjectives (die Adjektive)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "Adjectives like in any other language are used for description of nouns" +
                    ". German adjectives are dependent on the gender and case of the nouns.")
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "Below are common adjectives you will encounter:")
            Spacer(modifier = Modifier
                .height(10.dp))
            GermanAdjectiveList()
            Spacer(modifier = Modifier
                .height(20.dp))
            Text(text = "Adjective endings",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(10.dp))
            Text("Adjectives in german have different endings. This is determined by the case " +
                    "of the sentence or the gender of a noun.")
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = "There are two different groups of endings, endings can either be under " +
                    "definite or indefinite.")
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "With definite articles endings",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(5.dp))
            GermanDefEndTable()
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "With indefinite articles endings",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(5.dp))
            GermanIndEndTable()
        }
    }
}

@Composable
fun GermanCases() {
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
                text = "Articles",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier
                    .height(10.dp))
            Text(text = "Sentences in the German language fall into 4 different cases: Nominative, " +
                    "Accusative, Dative and Genitive. Each case has a different emphasis depending" +
                    " on the situation.")
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = "Before we get into cases, we need to understand that german nouns have genders. " +
                    " They can either be Masculine (der), Feminine (die) and neutral (das)." +
                    " These are also known as articles")
            Spacer(modifier = Modifier
                .height(30.dp))
            Text("There two types of articles:")
            Spacer(modifier = Modifier
                .height(10.dp))
            TextsForArticles("Bestimmte Artikeln",
                "Definite articles: (Der, die, das). These are the english equivalent of (The).")
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = " - Der Junge singt - The boy is singing.")
            Text(text = " - Die Frau tanzt  - The woman is dancing.")
            Text(text = " - Das Kind weint  - The child is crying.")
            Spacer(modifier = Modifier
                .height(15.dp))
            TextsForArticles("Unbestimmte Artikeln",
                "Indefinite articles(ein, eine, ein). These are the english equivalent of (A).")
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = " - Ein Junge singt - A boy is singing.")
            Text(text = " - Eine Frau tanzt - A woman is dancing.")
            Text(text = " - Ein Kind weint  - A child is crying.")
            Spacer(modifier = Modifier
                .height(40.dp))
            Text(
                text = "Cases",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "With an understanding of articles, you can now grasp cases. German ")
            Spacer(modifier = Modifier
                .height(10.dp))
            CaseParagraph(
                "Nominativ (Nominative)",
                "This case shows the subject of the sentence or who the sentence is about.",
                "Die Sonne scheint (The sun shines)\n \n - Die Sonne is the subject as the " +
                        "sentence is about the sun."
            )
            CaseParagraph(
                "Akkusativ (Accusative)",
                "This case shows the direct object of the sentence or what is directly " +
                        "affected by the verb.",
                "Ich kaufe einen neuen Computer (I am buying a new computer)\n \n - den Computer is " +
                        "the object as it is being bought. Ich is the subject."
            )
            CaseParagraph(
                "Dativ (Dative)",
                "This case shows the indirect object of a sentence or the item which is" +
                        "indirectly affected.",
                "Ich habe dem Mann den Ball geworfen (I threw the ball to the man)\n \n - dem Mann" +
                        " is the indirect object as the ball was thrown to him, den Ball was thrown " +
                        "making the ball an object and I threw the ball making Ich the subject."
            )
            CaseParagraph(
                "Genitiv (Genitive)",
                "This case shows possession of something in a sentence",
                "Das Auto der Frau ist Kaputt (The woman's car is broken)\n \n - der Frau shows " +
                        "ownership. The car belongs to the woman"
            )
            Spacer(modifier = Modifier
                .height(20.dp))
            Text("With each case explained, below are tables showing how each article is written" +
                    " with a particular case")
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = "Definite articles",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(3.dp))
            GermanDefiniteArticleTable()
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = "Indefinite articles",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(3.dp))
            GermanIndefiniteArticleTable()
            Spacer(modifier = Modifier
                .height(10.dp))
        }
    }
}

@Composable
fun GermanNouns() {
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
                text = "Nouns",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = "Nouns are basically objects and things that we see and know. In German " +
                    "nouns have genders which can get tricky for many english speakers as english " +
                    "words do not have genders. It is important to learn each German noun with its " +
                    "gender in oder to learn the genders easily. Another tip is to capitalise nouns." +
                    " In this chapter, you will learn about significant nouns as well as tips and " +
                    "tricks to remembering some noun genders."
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(text = "Most nouns end with en, el, er, ling, ent, ier, eur, ler as well as " +
                    "nationalities, times of the day, seasons, days, months tend to be masculine")
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(text = "Most nouns end with in, heit, kei, ung, tät, ion, age, ur, schaft, ei, " +
                    "-ie, -anz, -enz as well as numbers tend to be feminine.")
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(
                text = "People Nouns",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            GermanPeopleNounList()
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(
                text = "Place Nouns",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}




@Composable
@Preview(showBackground = true)
fun ViewGrammarScreens() {
    GermanNouns()
}