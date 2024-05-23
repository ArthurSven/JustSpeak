package com.devapps.justspeak_10.ui.Screens.German

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth
import com.devapps.justspeak_10.ui.Components.Question
import com.devapps.justspeak_10.ui.Components.QuizCard
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Components.germanAdjectiveQuizQuestions
import com.devapps.justspeak_10.ui.Components.germanCaseQuizQuestions
import com.devapps.justspeak_10.ui.Components.germanNounQuizQuestions
import com.devapps.justspeak_10.ui.Components.germanPrepositionQuestions
import com.devapps.justspeak_10.ui.Components.germanPronounQuestions
import com.devapps.justspeak_10.ui.Components.germanSentenceQuestions
import com.devapps.justspeak_10.ui.Components.germanTenseQuestions
import com.devapps.justspeak_10.ui.Components.germanVerbConjugationQuestions
import com.devapps.justspeak_10.ui.destinations.GermanAdjectiveQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanAdjectiveScreen
import com.devapps.justspeak_10.ui.destinations.GermanAlphabetScreen
import com.devapps.justspeak_10.ui.destinations.GermanCaseQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanCaseScreen
import com.devapps.justspeak_10.ui.destinations.GermanDiningQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanEmergencyQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanExpressionQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanGrammarQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanIntroductionQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanNounQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanNounScreen
import com.devapps.justspeak_10.ui.destinations.GermanPhraseQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanPrepositionQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanPrepositionScreen
import com.devapps.justspeak_10.ui.destinations.GermanPronounQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanPronounScreen
import com.devapps.justspeak_10.ui.destinations.GermanQuestionQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanQuizHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanSentenceStructureQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanSentenceStructureScreen
import com.devapps.justspeak_10.ui.destinations.GermanTenseQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanTenseScreen
import com.devapps.justspeak_10.ui.destinations.GermanTimeQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanVerbConjugationQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanVerbConjugationScreen
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.viewmodels.AuthViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

data class QuizTabs(
    val title: String,
    val description: String,
    val route: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanQuizScreen(
    germanQuizNavController: NavController,
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
                            germanQuizNavController.navigate(Signout.route)
                            onSignOut()
                        },
                        modifier = Modifier
                            .background(color = Color.White))
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = { germanQuizNavController.navigate(GermanHomeScreen.route)
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
                    .height(20.dp)
                )
                GermanQuizNavigation(germanQuizNavController)
            }
        }


    }

}

@Composable
fun GermanQuizNavigation(navController: NavController) {
    val germanQuizNavController = rememberNavController()
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
    NavHost(germanQuizNavController, startDestination = GermanQuizHomeScreen.route) {
        composable(GermanQuizHomeScreen.route) {
            GermanQuizHome(germanQuizNavController)
        }
        composable(GermanGrammarQuizScreen.route) {
            GermanGrammarQuiz(navController, germanQuizNavController)
        }
        composable(GermanPhraseQuizScreen.route) {
            GermanPhraseQuiz(navController, germanQuizNavController)
        }
        composable(GermanAdjectiveQuizScreen.route) {
            GermanAdjectiveQuiz()
        }
        composable(GermanCaseQuizScreen.route) {
            GermanCaseQuiz()
        }

        composable(GermanNounQuizScreen.route) {
            GermanNounQuiz()
        }
        composable(GermanPrepositionQuizScreen.route) {
            GermanPrepositionQuiz()
        }
        composable(GermanPronounQuizScreen.route) {
            GermanPronounQuiz()
        }
        composable(GermanSentenceStructureQuizScreen.route) {
            GermanSentenceQuiz()
        }
        composable(GermanTenseQuizScreen.route) {
            GermanTenseQuiz()
        }
        composable(GermanVerbConjugationQuizScreen.route) {
            GermanVerbConjugationQuiz()
        }
        //phrase navigation
        composable(GermanIntroductionQuizScreen.route) {
            GermanIntroductionQuiz()
        }
        composable(GermanExpressionQuizScreen.route) {
            GermanExpressionQuiz()
        }
    }
}

@Composable
fun GermanQuizHome(
    navController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val quizzes = listOf(
        QuizTabs(
            title = "Grammar Quizes",
            description = "Test your knowledge and understanding of German Grammar. Choose your grammar" +
                    " topic and begin!",
            route = GermanGrammarQuizScreen.route,
        ),
        QuizTabs(
            title = "Phrase Quizes",
            description = "Test your knowledge and understanding on commonly used " +
                    "phrases. Choose your phrase topic and begin!",
            route = GermanPhraseQuizScreen.route,
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 5.dp)
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
    ) {
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
                    text = "Quiz Section",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(text = "Test yourself and check how much German you can understand with the " +
                        "quizzes below")
            }
        }
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        Text(
            text = "Quiz Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
            .padding(all = 10.dp)
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        LazyRow(content = {
            items(quizzes.size) { i ->
                val quizTopic = quizzes[i]
                QuizCard(
                    selected = selectedItemIndex == i,
                    quizHeading = quizTopic.title,
                    quizDescription = quizTopic.description,
                    onClick = {
                        navController.navigate(quizTopic.route)
                    }
                )
            }
        },
            modifier = Modifier
                .padding(all = 10.dp))
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanGrammarQuiz(
    germanGrammarNavController: NavController,
    itemNavController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val quizList = listOf(
        GrammarListItem(
            itemTitle = "Adjectives Quiz",
            itemRoute = GermanAdjectiveQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Cases Quiz",
            itemRoute = GermanCaseQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Nouns Quiz",
            itemRoute = GermanNounQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Prepositions Quiz",
            itemRoute = GermanPrepositionQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Pronouns Quiz",
            itemRoute = GermanPronounQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Sentence Structure Quiz",
            itemRoute = GermanSentenceStructureQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Tenses Quiz",
            itemRoute = GermanTenseQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Verbs and Conjugation Quiz",
            itemRoute = GermanVerbConjugationQuizScreen.route
        )
    )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp)
                .background(color = Color.LightGray)
        ) {
            Text(text = "Grammar Quizzes",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black)
            Spacer(modifier = Modifier
                .height(10.dp))
            LazyColumn(content = {
                items(quizList.size) {i->
                    val listItem = quizList[i]
                    GrammarListItem(
                        selected = selectedItemIndex == i,
                        listTitle = listItem.itemTitle,
                        onClick = {
                            itemNavController.navigate(listItem.itemRoute)
                        } )
                }
            }
            )
        }
}

@Composable
fun GermanAdjectiveQuiz() {

    val germanAdjectiveQuestions = germanAdjectiveQuizQuestions()

    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanAdjectiveQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanAdjectiveQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {
        // Display score if available
        score?.let {

            if (it == germanAdjectiveQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanAdjectiveQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanAdjectiveQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanAdjectiveQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }
        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanAdjectiveQuestions.size) { j ->
                val adjectiveQuizList = germanAdjectiveQuestions[j]
                // Display the current question
                Text(
                    text = "${adjectiveQuizList.number} ${adjectiveQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                adjectiveQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != adjectiveQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${adjectiveQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanAdjectiveQuestions.indices) {
                    if (selectedOptions[i] == germanAdjectiveQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanCaseQuiz() {

    val germanCaseQuestions = germanCaseQuizQuestions()
    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanCaseQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanCaseQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {
        // Display score if available
        score?.let {

            if (it == germanCaseQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanCaseQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanCaseQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanCaseQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }
        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanCaseQuestions.size) { j ->
                val caseQuizList = germanCaseQuestions[j]
                // Display the current question
                Text(
                    text = "${caseQuizList.number} ${caseQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                caseQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != caseQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${caseQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanCaseQuestions.indices) {
                    if (selectedOptions[i] == germanCaseQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanNounQuiz() {
    val germanNounQuestions = germanNounQuizQuestions()
    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanNounQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanNounQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanNounQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanNounQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanNounQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanNounQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }
        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanNounQuestions.size) { j ->
                val nounQuizList = germanNounQuestions[j]
                // Display the current question
                Text(
                    text = "${nounQuizList.number} ${nounQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                nounQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != nounQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${nounQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanNounQuestions.indices) {
                    if (selectedOptions[i] == germanNounQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanPrepositionQuiz() {
    val germanPrepositionQuestions = germanPrepositionQuestions()
    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanPrepositionQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanPrepositionQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {
            
            if (it == germanPrepositionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanPrepositionQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanPrepositionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanPrepositionQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanPrepositionQuestions.size) { j ->
                val prepositionQuizList = germanPrepositionQuestions[j]
                // Display the current question
                Text(
                    text = "${prepositionQuizList.number} ${prepositionQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                prepositionQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != prepositionQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${prepositionQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanPrepositionQuestions.indices) {
                    if (selectedOptions[i] == germanPrepositionQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanPronounQuiz() {
    val germanPronounQuestions = germanPronounQuestions()
    // Maintain selection state for each question
    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanPronounQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanPronounQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanPronounQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanPronounQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanPronounQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanPronounQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanPronounQuestions.size) { j ->
                val pronounQuizList = germanPronounQuestions[j]
                // Display the current question
                Text(
                    text = "${pronounQuizList.number} ${pronounQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                pronounQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != pronounQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${pronounQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanPronounQuestions.indices) {
                    if (selectedOptions[i] == germanPronounQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanSentenceQuiz() {
// Maintain selection state for each question
    val germanSentenceQuestions = germanSentenceQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanSentenceQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanSentenceQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanSentenceQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanSentenceQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanSentenceQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanSentenceQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanSentenceQuestions.size) { j ->
                val sentenceQuizList = germanSentenceQuestions[j]
                // Display the current question
                Text(
                    text = "${sentenceQuizList.number} ${sentenceQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                sentenceQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != sentenceQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${sentenceQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanSentenceQuestions.indices) {
                    if (selectedOptions[i] == germanSentenceQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanTenseQuiz() {
// Maintain selection state for each question
    val germanTenseQuestions = germanTenseQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanTenseQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanTenseQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanTenseQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanTenseQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanTenseQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanTenseQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanTenseQuestions.size) { j ->
                val tenseQuizList = germanTenseQuestions[j]
                // Display the current question
                Text(
                    text = "${tenseQuizList.number} ${tenseQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                tenseQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != tenseQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${tenseQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanTenseQuestions.indices) {
                    if (selectedOptions[i] == germanTenseQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanVerbConjugationQuiz() {
    val germanVerbConjugationQuestions = germanVerbConjugationQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanVerbConjugationQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanVerbConjugationQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanVerbConjugationQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanVerbConjugationQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanVerbConjugationQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanVerbConjugationQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanVerbConjugationQuestions.size) { j ->
                val verbQuizList = germanVerbConjugationQuestions[j]
                // Display the current question
                Text(
                    text = "${verbQuizList.number} ${verbQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                verbQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != verbQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${verbQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanVerbConjugationQuestions.indices) {
                    if (selectedOptions[i] == germanVerbConjugationQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

//German phrase Quiz screens
@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GermanPhraseQuiz(
    germanPhraseNavController: NavController,
    itemNavController: NavController
) {
    val selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val quizList = listOf(
        GrammarListItem(
            itemTitle = "Introductions Quiz",
            itemRoute = GermanIntroductionQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Expressions Quiz",
            itemRoute = GermanExpressionQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Dining and Shopping Quiz",
            itemRoute = GermanDiningQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Emergencies Quiz",
            itemRoute = GermanEmergencyQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Questions Quiz",
            itemRoute = GermanQuestionQuizScreen.route
        ),
        GrammarListItem(
            itemTitle = "Time Quiz",
            itemRoute = GermanTimeQuizScreen.route
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .background(color = Color.LightGray)
    ) {
        Text(text = "Phrase Quizzes",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black)
        Spacer(modifier = Modifier
            .height(10.dp))
        LazyColumn(content = {
            items(quizList.size) {i->
                val listItem = quizList[i]
                GrammarListItem(
                    selected = selectedItemIndex == i,
                    listTitle = listItem.itemTitle,
                    onClick = {
                        itemNavController.navigate(listItem.itemRoute)
                    } )
            }
        }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun QuizPreview() {
    val testNavController = rememberNavController()
    GermanPrepositionQuiz()
}