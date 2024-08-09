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
import com.devapps.justspeak_10.ui.Components.GermanAccusativePrepositionsList
import com.devapps.justspeak_10.ui.Components.GermanAdjectiveList
import com.devapps.justspeak_10.ui.Components.GermanAlphabetItem
import com.devapps.justspeak_10.ui.Components.GermanAlphabetList
import com.devapps.justspeak_10.ui.Components.GermanBodyPartNounList
import com.devapps.justspeak_10.ui.Components.GermanDativePrepositionsList
import com.devapps.justspeak_10.ui.Components.GermanDefEndTable
import com.devapps.justspeak_10.ui.Components.GermanDefiniteArticleTable
import com.devapps.justspeak_10.ui.Components.GermanFoodNounList
import com.devapps.justspeak_10.ui.Components.GermanGenitivePrepositionsList
import com.devapps.justspeak_10.ui.Components.GermanIndEndTable
import com.devapps.justspeak_10.ui.Components.GermanIndefiniteArticleTable
import com.devapps.justspeak_10.ui.Components.GermanPeopleNounList
import com.devapps.justspeak_10.ui.Components.GermanPlaceNounList
import com.devapps.justspeak_10.ui.Components.GermanTwoWayPrepositionsList
import com.devapps.justspeak_10.ui.Components.HabenConjugationTable
import com.devapps.justspeak_10.ui.Components.KannConjugationTable
import com.devapps.justspeak_10.ui.Components.PronounTable
import com.devapps.justspeak_10.ui.Components.SeinConjugationTable
import com.devapps.justspeak_10.ui.Components.TextsForArticles
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.VerbTable
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
            .padding(top = 10.dp, start = 5.dp, end = 10.dp, bottom = 5.dp)
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
        composable(GermanPronounScreen.route) {
            GermanPronouns()
        }
        composable(GermanPrepositionScreen.route) {
            GermanPrepositions()
        }
        composable(GermanSentenceStructureScreen.route) {
            GermanSentenceStructure()
        }
        composable(GermanTenseScreen.route) {
            GermanTenses()
        }
        composable(GermanVerbConjugationScreen.route) {
            GermanVerbsAndConjugation()
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
          itemTitle = "Prepositions",
            itemRoute = GermanPrepositionScreen.route
        ),
        GrammarListItem(
            itemTitle = "Pronouns",
            itemRoute = GermanPronounScreen.route
        ),
        GrammarListItem(
            itemTitle = "Sentence Structure",
            itemRoute = GermanSentenceStructureScreen.route
        ),
        GrammarListItem(
            itemTitle = "Tenses",
            itemRoute = GermanTenseScreen.route
        ),
        GrammarListItem(
            itemTitle = "Verbs and Conjugation",
            itemRoute = GermanVerbConjugationScreen.route
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
                        .fillMaxSize()
                        .padding(all = 10.dp)
                ) {
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
                    .fillMaxSize()
                    .padding(all = 10.dp)
            ) {
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
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp))
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
                    .padding(all = 10.dp)
            ) {
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
            }
        }

            Spacer(modifier = Modifier
                .height(20.dp))
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
                    .padding(all = 10.dp)
            ) {
                Text(text = "Indefinite articles",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier
                    .height(3.dp))
                GermanIndefiniteArticleTable()
            }
        }
            Spacer(modifier = Modifier
                .height(10.dp))
        }
}

@Composable
fun GermanNouns() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                ) {
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
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                ) {
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
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                ) {
                    Text(
                        text = "Place Nouns",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )
                    GermanPlaceNounList()
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ElevatedCard (
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            )
            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = "Food and drink Nouns",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                GermanFoodNounList()
            }
        }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            ElevatedCard (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 10.dp)
                ) {
                    Text(
                        text = "Body Part Nouns",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )
                    GermanBodyPartNounList()
                }
            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
        }

}

@Composable
fun GermanPronouns() {
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
                text = "Pronouns",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = "Pronouns are the little words that replace nouns in a sentence. The German " +
                    "language like other languages also has pronouns. German has a number of " +
                    "pronouns which will be explained in this chapter. Once you get a feel for " +
                    "pronouns, your fluency will definitely improve."
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(
                text = "Personal Pronouns",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )
            Text(
                text = "In english these are equivalent to (I, you, she, he, it, me). The pronouns " +
                    "however change depending on the case. In German we have the following:"
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            PronounTable()
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
        }
    }
}

@Composable
fun GermanSentenceStructure() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "Sentence Structure",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "One of the most dreaded yet essential skills in German is the sentence " +
                            "structure. Understanding basic German word order is a bridge to fluency and " +
                            "speaking. In this chapter you will learn how sentences in German are structured" +
                            " and how to do this easily."
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Basic declarative sentences have the same structure as english sentences. " +
                            "They follow the Subject - verb - object sequence e.g. Ich komme heute (I am " +
                            "coming today). Unlike in english where you use (I am), in German it is mostly " +
                            "Subject and verb thus using (Ich komme) not (ich bin kommen) to say I am coming." +
                            ""
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
                .padding(all = 20.dp),
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
                    text = "Sentences with separable verbs",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "Some sentences have separable verbs in them, the stem remains in the second" +
                            " position while prefix goes to the end of the sentence e.g. \n \n -Ich schlafe im " +
                            "Auto ein - (I fall asleep in the car)"
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
                .padding(all = 20.dp),
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
                    text = "Sentences with clauses",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "In German, a main clause can be joined with a subordinate clause or even a " +
                            "main clause using connectives like aber, weil, wenn, obwohl, denn usw - (but, " +
                            "because, if/when, although, because etc). \n \n In the case of a subordinate " +
                            "clause, the verb in the subordinate clause usually goes to the end of the " +
                            "sentence. Below are some examples of how connectives bridge main and " +
                            "subordinate clauses:"
                )
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )
                Text(
                    text = "Ich komme zu spät, weil ich mein Zimmer aufräumen muss - (I come late because I have to clean my room)\n\n" +
                            "Ich habe es versucht, die Aufgabe zu erledigen, aber ich konnte es nicht machen - (I tried to complete the task, but I could not do it)\n\n" +
                            "Wenn du zuhause bist, ruf mich an, okay? - (When you are at home, call me, okay?)\n\n" +
                            "Die Kinder verstehen nichts, obwohl ich alles erklärt habe - (The children do not understand anything although I explained everything)\n\n" +
                            "Ich schlafe immer, denn ich bin immer noch krank - (I am still sleeping because I am still sick)\n\n" +
                            "Explanation: 'denn' is a coordinating conjunction in German that means 'because'. It is used to provide a reason or explanation for something. Unlike 'weil', 'denn' does not change the word order of the sentence.\n" +
                            "Example: Ich gehe ins Bett, denn ich bin müde. - (I am going to bed because I am tired.)"
                )

            }
        }
    }
}

@Composable
fun GermanTenses() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "German Tenses",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Tenses are a key part of language learning. Tenses show the time of a given " +
                            "sentence or a statement. In German, there are 6 tenses that are used to " +
                            "show time of occurrence. In this chapter, you will learn about all 6 tenses" +
                            ", how they work and examoles to make your learning much easier."
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
                .padding(all = 20.dp),
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
                    text = "Present Perfect Tense (Perfekt)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "he present perfect tense is used when a past event has its consequences in " +
                            "the present time. In other words, when a verb in present tense has been " +
                            "combined with a past participle. Examples of this tense are:\n" +
                            "\n" +
                            "Sie hat ihre Schlüssel verloren. (She has lost her keys)\n \n" +
                            "Er hat seinen Rucksack vergessen. (He has forgotten his backpack)"
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
                .padding(all = 20.dp),
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
                    text = "Past simple (Imperfekt/Präteritum)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "The past simple tense is used to describe events that occurred in the past." +
                            " Past simple is used quite a lot in written language and verb conjugation " +
                            "changes. \n \n" +
                            "Ich besuchte gestern meine Großeltern. (I visited my Grandma yesterday). \n \n" +
                            "Letzten Sommer reisten wir nach Italien. (We travelled to Italy last summer"
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
                .padding(all = 20.dp),
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
                    text = "Past Perfect (Plusquamperfekt)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "This is used to describe a past action that happened before another past " +
                            "occurrence, this is very much equal to the english tense of past perfect. Below " +
                            "are examples of sentences showing the past perfect tense in action: \n \n" +
                            "Sie hatten das Konzert bereits gesehen, bevor ich ankam. (They had already seen" +
                            " the concert before I arrived). \n \n Bevor sie ins Bett ging, hatte sie " +
                            "bereits das Buch beendet. (She had finished the book before she went to bed.)"
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
                .padding(all = 20.dp),
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
                    text = "Future (Futur I)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "This tense is used to talk about the future or what will be done anytime " +
                            "after the present. Below are some examples of the future tense being used in " +
                            "context \n \n Du wirst es schaffen. (You will make/achieve it) \n \n" +
                            "Sie werden in der Zukunft mehr über umweltfreundliche Technologien forschen. " +
                            "(They will research more environmental friendly technologies in the future)"
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
                .padding(all = 20.dp),
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
                    text = "Future perfect (Futur II)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "This tense is used to describe an occurrence or event that will be achieved" +
                            " or done at a specific time in the future or an even an occurrence that will be" +
                            " past in the future. Below are some examples to give you better understanding " +
                            "of this tense: \n \n Im Jahr 2030 werden wir viele Fortschritte in der Medizin " +
                            "gemacht haben. (In 2030 we will have made many advances in medicine.) \n \n" +
                            "Bis zum Ende des Jahres werden wir zehn Jahre zusammen verbracht haben. " +
                            "(By the end of the year we will have spent ten years together.)"
                )
            }
        }
    }
}

@Composable
fun GermanVerbsAndConjugation() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
                Text(
                    text = "German Verbs and Conjugation",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Verbs are the backbone of many languages, this includes German.Knowing the " +
                            "most important verbs in a language can improve your ability to communicate and " +
                            "express yourself much easily.\n \n German verbs are conjugated based on pronouns " +
                            "thus you might notice some verb endings completely changing, some verbs have " +
                            "the whole word completely changed.\n" +
                            "\n" +
                            "In German verbs can fall under two groups, regular verbs (weak) and irregular " +
                            "verbs(Strong Verbs). \n \nRegular verbs are the verbs that do not completely change " +
                            "even when conjugated. \n \nIrregular verbs are verbs that can change their whole " +
                            "stem due to conjugation."
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
                text = "German Verbs and Conjugation",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = "Verbs are the backbone of many languages, this includes German.Knowing the " +
                        "most important verbs in a language can improve your ability to communicate and " +
                        "express yourself much easily.\n \n German verbs are conjugated based on pronouns " +
                        "thus you might notice some verb endings completely changing, some verbs have " +
                        "the whole word completely changed.\n" +
                        "\n" +
                        "In German verbs can fall under two groups, regular verbs (weak) and irregular " +
                        "verbs(Strong Verbs). \n \nRegular verbs are the verbs that do not completely change " +
                        "even when conjugated. \n \nIrregular verbs are verbs that can change their whole " +
                        "stem due to conjugation."
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
                    text = "Top 20 Verbs to know in German",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "Make sure to learn the conjugations of all these verbs as you will " +
                            "encounter these verbs frequently as you speak and learn more German."
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                VerbTable()
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
                    text = "Verb Conjugation",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Verb conjugation is when a verb changes its form in order to match the " +
                            "pronoun. The pronoun and the verb can show the quantity of the subject of a " +
                            "sentence whether there is one or more persons as subject of a sentence. Below " +
                            "are tables showing conjugation of verbs haben (to have), sein (to be) and " +
                            "können (to be able to, can) while in present tense:"
                )
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )
                Text(
                    text = "Verb haben (to have)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                HabenConjugationTable()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Verb Sein (to be)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                SeinConjugationTable()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Verb können (to be able to, can)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                KannConjugationTable()

            }
        }

        }
    }

@Composable
fun GermanPrepositions() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "Prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "Prepositions connect a noun to the sentence body, they also determine the case" +
                            " of the noun, article and can equally signal whether a noun is stationery " +
                            "or moving. \n \n There are 4 groups of prepositions namely accusative, " +
                            "dative, genitive and two-way:"
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
                .padding(all = 20.dp),
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
                    text = "Accusative Prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These are the prepositions that go with accusative case only. They usually" +
                            "signal something is moving:"
                )
                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                )
                GermanAccusativePrepositionsList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "Dative Prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "These are the prepositions that go with detive case only. They usually" +
                        "signal something is stationary or not moving:"
                )
                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                )
                GermanDativePrepositionsList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "Genitive Prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(
                    text = "These are the prepositions that go with genitive case only:"
                )
                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                )
                GermanGenitivePrepositionsList()
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
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
                    text = "Two way Prepositions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Text(text = "These are the prepositions that can either go with dative or accusative" +
                        "case:"
                )
                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                )
                GermanTwoWayPrepositionsList()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun checkGrammarScreens() {
    GermanVerbsAndConjugation()
}