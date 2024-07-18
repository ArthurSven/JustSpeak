package com.devapps.justspeak_10.ui.Components

data class FunFact(
    val name: String,
    val content: String
)

fun getGermanTriviaContent() : List<FunFact> {
    return listOf(
        FunFact(
            "",
            ""
        )
    )
}