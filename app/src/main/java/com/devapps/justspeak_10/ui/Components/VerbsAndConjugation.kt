package com.devapps.justspeak_10.ui.Components

import androidx.compose.runtime.Composable

@Composable
fun getSeinConjugation() : List<String> {
    return listOf(
        "Ich bin", "Du bist (informal)", "Er ist", "Sie ist", "Es ist", "Wir sind", "Ihr seid  (informal)",
        "Sie haben (formal)", "Sie haben"
    )
}

@Composable
fun getSeinTranslated() : List<String> {
    return listOf(
        "I am", "You are", "He is", "She is", "It is", "We are", "You are", "You are", "They are"
    )
}

fun getKannConjugation() : List<String> {
    return listOf(
        "Ich kann", "Du kannst (informal)", "Er kann", "Sie kann", "Es kann", "Wir können", "Ihr könnt (informal)",
        "Sie können (formal)", "Sie können"
    )
}

fun getKannTranslated() : List<String> {
    return listOf(
        "I can", "You can", "He can", "She can", "It can", "We can", "You can", "You can", "They can"
    )
}