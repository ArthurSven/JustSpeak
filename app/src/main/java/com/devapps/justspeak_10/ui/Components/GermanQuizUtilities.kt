package com.devapps.justspeak_10.ui.Components

import androidx.compose.runtime.Composable

// Data class to hold a question and its options
data class Question(
    val number: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

fun germanAdjectiveQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1.",
            "What's the German word for beautiful?",
            listOf(
                "Schon", "Schön", "Gut"
            ),
            "Schön",
        ),
        Question(
            "2.",
            "Der Hals ist ... (The neck ist long)",
            listOf(
                "Klein", "groß", "lang"
            ),
            "lang"
        ),
        Question(
            "3.",
            "Das ... Auto (The red car)",
            listOf(
                "roter", "rote", "rot"
            ),
            "rote"
        ),
        Question(
            "4.",
            "Hast du den ... Mann gesehen? (Have you seen the short man?)",
            listOf(
                "kleinen", "klein", "kleiner"
            ),
            "kleinen"
        ),
        Question(
            "5.",
            "What's the german word for slow",
            listOf(
                "Langsam", "Schnell", "Schlow"
            ),
            "Langsam"
        )
    )
}
fun germanCaseQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Der, die das are examples of...",
            listOf(
                "Definite articles", "Indefinite Articles",
            ),
            "Definite Articles"
        ),
        Question(
            "2",
            "What case is the following sentence - Ich kaufe einen neuen Computer",
            listOf(
                "Nominativ", "Dativ", "Akkusativ", "Genitiv"
            ),
            "Akkusativ"
        ),
        Question(
            "3",
            "Complete the sentence - Das Gepäck ... Frau ist verloren (The woman's bag is lost)",
            listOf(
                "die", "des", "der"
            ),
            "der"
        ),
        Question(
            "4",
            "Ich gab ... ... Mann den Ball (I gave the tall man the ball.)",
            listOf(
                "dem große", "den großen", "der großem", "dem großen"
            ),
            "dem großen"
        ),
        Question(
            "4",
            "Das ist ... schönes Mädchen (That is a beautiful girl)",
            listOf("eine", "eines", "ein"),
            "ein"
        ),
        Question(
            "5",
            "... Junge singt (The boy sings)",
            listOf(
                "den", "der", "dem",
            ),
            "der"
        )
    )
}

fun germanNounQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Ich hätte gerne einen ..., bitte  (I would like an Apple, please)",
            listOf(
                "Appel", "Apfel", "Apple"
            ),
            "Apfel"
        ),
        Question(
            "2",
            "Mein ... hat braune Augen (My father has brown eyes)",
            listOf(
                "Vater", "Father", "Vatter"
            ),
            "Vater"
        ),
        Question(
            "3",
            "Trinkst du gerne ...? (Do you like drinking coffee)",
            listOf(
                "Cafe", "Tee", "kaffee"
            ),
            "Kaffee"
        ),
        Question(
            "4",
            "Ich gehe in ... ... (I am going in the city)",
            listOf(
                "die Stadt", "den Stadt", "der Stadt"
            ),
            "die Stadt"
        ),
        Question(
            "5",
            "What's the German word for Apartment?",
            listOf(
                "das Haus", "das Gebäude", "die Wohnung"
            ),
            "die Wohnung"
        )
    )
}

fun germanPrepositionQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Which preposition means 'for'?",
            listOf("für", "um", "bis"),
            "für"
        ),
        Question(
            "2",
            "Which preposition is two way?",
            listOf("gegen", "unter", "durch"),
            "unter"
        ),
        Question(
            "3",
            "Which preposition means 'against'?",
            listOf("um", "gegen", "bis"),
            "gegen"
        ),
        Question(
            "4",
            "Which preposition is genitiv?",
            listOf("durch", "für", "wegen"),
            "wegen"
        ),
        Question(
            "5",
            "Which preposition is accusative?",
            listOf("bis", "aus", "mit"),
            "bis"
        )
    )
}