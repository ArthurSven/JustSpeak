package com.devapps.justspeak_10.ui.Components

// Data class to hold a question and its options
data class Question(
    val number: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

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
        Question()
    )
}