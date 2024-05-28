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

object GermanFlashCardScreen : ScreenDestination {
    override val route = "german_flashcard_screen"
}

object GermanTranslateScreen : ScreenDestination {
    override val route = "german_translate_screen"
}

object GermanFlashcardListScreen : ScreenDestination {
    override val route = "german_flashcard_list_screen"
}

object GermanAddFlashcardScreen : ScreenDestination {
    override val route = "german_add_flashcard_screen"
}

//German grammar screens

object GermanGrammarItemScreen : ScreenDestination {
    override val route = "german_grammar_item_screen"
}
object GermanAlphabetScreen : ScreenDestination {
    override val route = "german_alphabet_screen"
}

object GermanAdjectiveScreen : ScreenDestination {
    override val route = "german_adjective_screen"
}

object GermanCaseScreen : ScreenDestination {
    override val route = "german_case_screen"
}

object GermanNounScreen : ScreenDestination {
    override val route = "german_noun_screen"
}

object GermanPronounScreen : ScreenDestination {
    override val route = "german_pronoun_screen"
}

object GermanSentenceStructureScreen : ScreenDestination {
    override val route = "german_sentence_screen"
}

object GermanTenseScreen : ScreenDestination {
    override val route = "german_tense_screen"
}

object GermanPrepositionScreen : ScreenDestination {
    override val route = "german_preposition_screen"
}

object GermanVerbConjugationScreen : ScreenDestination {
    override val route = "german_verb_conjugation_screen"
}

object GermanPhraseListScreen : ScreenDestination {
    override val route = "german_phrase_list_screen"
}

object GermanIntroductionScreen : ScreenDestination {
    override val route = "german_introduction_screen"
}

object GermanExpressionScreen : ScreenDestination {
    override val route = "german_expressions_screen"
}

object GermanEatingScreen : ScreenDestination {
    override val route = "german_eating_screen"
}

object GermanEmergencyScreen : ScreenDestination {
    override val route = "german_emergency_screen"
}

object GermanQuestionsScreen : ScreenDestination {
    override val route = "german_question_screen"
}

object GermanTimeScreen : ScreenDestination {
    override val route = "german_time_screen"
}

object GermanQuizHomeScreen : ScreenDestination {
    override val route = "german_quiz_home_screen"
}

object GermanGrammarQuizScreen : ScreenDestination {
    override val route = "german_grammar_quiz_screen"
}

object GermanPhraseQuizScreen : ScreenDestination {
    override val route = "german_phrase_quiz_screen"
}

//Quizzes
object GermanAdjectiveQuizScreen : ScreenDestination {
    override val route = "german_adjective_quiz_screen"
}

object GermanCaseQuizScreen : ScreenDestination {
    override val route = "german_case_quiz_screen"
}

object GermanNounQuizScreen : ScreenDestination {
    override val route = "german_noun_quiz_screen"
}

object GermanPronounQuizScreen : ScreenDestination {
    override val route = "german_pronoun_quiz_screen"
}

object GermanSentenceStructureQuizScreen : ScreenDestination {
    override val route = "german_sentence_quiz_screen"
}

object GermanTenseQuizScreen : ScreenDestination {
    override val route = "german_tense_quiz_screen"
}

object GermanPrepositionQuizScreen : ScreenDestination {
    override val route = "german_preposition_quiz_screen"
}

object GermanVerbConjugationQuizScreen : ScreenDestination {
    override val route = "german_verb_conjugation_quiz_screen"
}

object GermanIntroductionQuizScreen : ScreenDestination {
    override val route = "german_introduction_quiz_screen"
}

object GermanExpressionQuizScreen : ScreenDestination {
    override val route = "german_expression_quiz_screen"
}

object GermanEmergencyQuizScreen : ScreenDestination {
    override val route = "german_emergency_quiz_screen"
}

object GermanDiningQuizScreen : ScreenDestination {
    override val route = "german_dining_quiz_screen"
}

object GermanQuestionQuizScreen : ScreenDestination {
    override val route = "german_question_quiz_screen"
}

object GermanTimeQuizScreen : ScreenDestination {
    override val route = "german_time_quiz_screen"
}

object GermanJournalScreen : ScreenDestination {
    override val route = "german_journal_screen"
}

object GermanJournalHomeScreen : ScreenDestination {
    override val route = "german_journal_home_screen"
}

object GermanJournalCreateScreen : ScreenDestination {
    override val route = "german_journal_create_screen"
}

object GermanJournalReadScreen : ScreenDestination {
    override val route = "german_journal_read_screen"
}

object GermanJournalEditScreen : ScreenDestination {
    override val route = "german_journal_edit_screen"
}
object Signout : ScreenDestination {
    override val route = "signout_user"
}