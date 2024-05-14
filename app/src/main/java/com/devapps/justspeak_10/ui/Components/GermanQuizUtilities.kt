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
            "",
            listOf(
                "", "", ""
            ),
            ""
        )
    )
}