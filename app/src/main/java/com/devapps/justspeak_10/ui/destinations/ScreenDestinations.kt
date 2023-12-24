package com.devapps.justspeak_10.ui.destinations

interface ScreenDestination {
    val route: String
}

object SplashScreen : ScreenDestination {
    override val route = "splash_screen"
}

object Check : ScreenDestination {
    override val route = "check_auth"
}

object Start : ScreenDestination {
    override val route = "start_screen"
}

object Signup : ScreenDestination {
    override val route = "signup_screen"
}

object Home : ScreenDestination {
    override val route = "home_screen"
}

object GermanSection : ScreenDestination {
    override val route = "german_screen"
}

object ChichewaScreen : ScreenDestination {
    override val route = "chichewa_screen"
}

//German routes

object GermanNavigation : ScreenDestination {
    override val route = "german_navigation"
}
object GermanHomeScreen : ScreenDestination {
    override val route = "german_home_screen"
}

object GermanGrammarScreen : ScreenDestination {
    override val route = "german_grammar_screen"
}

object GermanPhrasesScreen : ScreenDestination {
    override val route = "german_phrase_screen"
}

object GermanTriviaScreen : ScreenDestination {
    override val route = "german_trivia_screen"
}

object GermanQuizScreen : ScreenDestination {
    override val route = "german_quiz_screen"
}

object Signout : ScreenDestination {
    override val route = "signout_user"
}