package com.devapps.justspeak_10.ui.Screens.German

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.ui.destinations.GermanGrammarScreen
import com.devapps.justspeak_10.ui.destinations.GermanHomeScreen
import com.devapps.justspeak_10.ui.destinations.GermanPhrasesScreen
import com.devapps.justspeak_10.ui.destinations.GermanQuizScreen
import com.devapps.justspeak_10.ui.destinations.GermanTriviaScreen

@Composable
fun GermanNavigation(navController: NavController) {

    val germanNavController = rememberNavController()
    NavHost(navController = germanNavController, startDestination = GermanHomeScreen.route) {
        composable(GermanHomeScreen.route) {

        }
        composable(GermanGrammarScreen.route) {

        }
        composable(GermanPhrasesScreen.route) {

        }
        composable(GermanTriviaScreen.route) {

        }
        composable(GermanQuizScreen.route) {

        }
    }
}