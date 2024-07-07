package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun getChichewaGreetings() : List<String> {
    return listOf(
        "Bho!", "Wadzuka bwanji?", "Mwadzuka bwanji?", "Uli bwanji?", "Muli bwanji",
        "Waswera bwanji?", "Mwaswera bwanji?", "Ugone bwino", "Mugone bwino"
    )
}

fun getEnglischGreetings() : List<String> {
    return listOf(
        "Hey!", "How are you? (morning)", "How are you? (morning) - formal", "How are you? (midday)",
        "How are you? (midday) - formal", "How are you? (evening)", "How are you? (evening) - formal",
         "Goodnight", "Goodnight - formal"
    )
}

@Composable
fun ChichewaGreetingsList() {
    val chichewaGreetings = getChichewaGreetings()
    val english = getEnglischGreetings()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(chichewaGreetings) { chichewaGreeting ->
            val index = chichewaGreetings.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaGoodbyes() : List<String> {
    return listOf(
        "Ndikupita", "Ine nde ndikuthaweni", "Tiwonaneso sabata la mawa", "Tiwonana", "Tiwonana mawa",
         "Ine ndisanzike"
    )
}

fun getEnglischGoodbyes() : List<String> {
    return listOf(
        "I am going/I am leaving", "I should take leave", "See you next week", "see you later",
        "See you tomorrow", "I should bid farewell"
    )
}

@Composable
fun ChichewaGoodbyeList() {
    val chichewaGreetings = getChichewaGoodbyes()
    val english = getEnglischGoodbyes()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(chichewaGreetings) { chichewaGreeting ->
            val index = chichewaGreetings.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaIntroductionPhrases() : List<String> {
    return listOf(
    "Awa ndi a ...", "Uyu ndi ...", "Ine, dzina langa ndi...", "Dzina lanu ndi ndani?",
        "Dzina lako ndi ndani?", "M'machokela kuti?", "Umachokela kuti?", "Mumakhala kuti?",
        "Umakhala kuti?"
    )
}

fun getEnglischIntroductionPhrases() : List<String> {
    return listOf(
        "This is ...(formal/plural)", "This is ...", "My name is...", "What is your name? (formal)",
        "What is your name? (informal)", "Where do you come from? (formal)",
        "Where do you come from? (informal)", "Where do you stay? (formal)", "Where do you stay? (informal)"
    )
}

@Composable
fun ChichewaIntroductionPhraseList() {
    val chichewaGreetings = getChichewaIntroductionPhrases()
    val english = getEnglischIntroductionPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(chichewaGreetings) { chichewaGreeting ->
            val index = chichewaGreetings.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaExpressionList() : List<String> {
    return listOf(
        "Pepani", "Tifunse nawo", "Ndimafuna thandizo", "Ndithandizeni", "Eya", "Ayi", "Mwina",
        "Zikomo", "Ndathokoza", "Mumanena bwanji ... mchizungu?", "Ichi ndi chan?", "Icho ndi chan?",
         "Lankhulani pang'ono pang'ono, chonde", "Khalani chete, chonde", "Chonde", "Ndimamva chichewa pangóno",
         "Ndamva", "Sindinamvesese", "Zonse zilibwino", "Bwela kuno", "Choka"
    )
}

fun getEnglischExpressionList() : List<String> {
    return listOf(
        "Sorry/Excuse me", "May I ask?", "I need some help", "Help me", "Yes", "No", "Maybe", "Thank you",
         "Thank you", "How do you say... in chichewa?", "What is this?", "What is that?", "Speak slowly, please",
         "Keep quiet", "Please", "I understand little chichewa", "I understand", "I do not understand", "Everything's fine",
         "Come here", "Get out!"
    )
}

@Composable
fun ChichewaExpressionList() {
    val chichewaGreetings = getChichewaExpressionList()
    val english = getEnglischExpressionList()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        items(chichewaGreetings) { chichewaGreeting ->
            val index = chichewaGreetings.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaShoppingList() : List<String> {
    return listOf(
        "Kugula", "Ndukagula ...", "Ndupita kokashopa", "Ntengo", "Ichi ndibwa?",
        "kugulisa", "Mukugulisa chan?", "Zovala", "Shopu", "Muli ndi ...?", "Mumagulisa...?", "Ndimafuna...",
         "Chikudhula", "Chikutchipa", "Ndipaseni lisiti", "Kodi ndingapeze ... pati?", "Chandisangalasa",
        "Sichinandisangalase", "Yesani"
    )
}

fun getEnglischShoppingList() : List<String> {
    return listOf(
        "To buy", "I am going to buy...", "I am going shopping", "Price", "How much is this?", "To sell",
         "What are you selling?", "Clothes", "Shop", "Do you have...?", "Do you sell...?", "I am looking for...",
         "It's expensive", "It's cheap", "Give me a receipt", "Where can I find...?", "I like that", "I do not like that",
        "Try it on"
    )
}

@Composable
fun ChichewaShoppingList() {
    val chichewa = getChichewaShoppingList()
    val english = getEnglischShoppingList()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(chichewa) { chichewaGreeting ->
            val index = chichewa.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaDiningPhrases() : List<String> {
    return listOf(
        "Kudya", "Ndimafuna tebulo la anthu awiri", "Tikhoza kukhala apa?", "Ndiwone nawo menu", "Muli ndi chan?",
         "Mudya chan?", "Mumwa chan?", "Ine ndufuna ...", "Ndidya...", "Ndimwa...", "Apapa chabwino ndi chiti?",
         "Iyayi sindinayitanise izi", "Zilibwino?", "Onjezelani", "Chiliponso china ngati?", "Ndufuna ndilipile",
         "Ndilipila ndi card", "Ndilipila ndi cash", "Mundibwelesele billu"
    )
}

fun getEnglischDiningPhrases() : List<String> {
    return listOf(
        "To eat", "A table for two", "Can we sit here?", "May I see the menu?", "What do you have?", "What will you eat?",
         "What will you drink?", "I want ...", "I will eat...", "I will drink ...", "What can you recommend here?", "No, I didn't order this",
         "Is everything good?", "Add more", "Anything else?", "I would like to pay", "I will pay with a card", "I will pay with cash",
         "Bring me the bill"
    )
}

@Composable
fun ChichewaDiningPhraseList() {
    val chichewa = getChichewaDiningPhrases()
    val english = getEnglischDiningPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        items(chichewa) { chichewaGreeting ->
            val index = chichewa.indexOf(chichewaGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(chichewaGreeting, englishGreeting)
        }
    }
}

fun getChichewaGeneralEmergencies() : List<String> {
    return listOf(
        "Ndithandizeni!", "Bwino!", "Samalani!", "Changu!", "Fulumilani!", "Mungandithandizeko?",
        "Ungandithandizeko?", "Ndikuthandizeni bwanji?", "Chachitika ndi chan?", "Kwachitika ngozi",
        "Kwachitika zadzidzidzi"
    )
}

fun getEnglischGeneralEmergencies() : List<String> {
    return listOf(
        "Help me!", "Careful!", "Take care!", "Hurry up!", "Hurry up!", "May you please help me?",
        "Can you please help me? (informal)", "How may I help you?", "What happened?", "An accident happened",
         "An emergency happned"
    )
}



@Composable
@Preview(showBackground = true)
fun Tiwoneseni() {
    ChichewaDiningPhraseList()
}