package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhraseComponent(german: String, english: String) {
    Column {
        Text(text = german,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp)
        Text(text = "- $english",
            fontSize = 16.sp,
            color = Color.Gray,
            fontStyle = FontStyle.Italic)
        Spacer(modifier = Modifier
            .height(5.dp))
    }
}

@Composable
fun getGermanGreetings() : List<String> {
    return listOf(
        "Guten Tag", "Guten Morgen", "Guten Abend", "Gute Nacht", "Hallo", "Grüß Gott", "Servus",
        "Grüezi", "Moin", "Guete Morge", "Guete Abig", "Grias di"
    )
}
@Composable
fun getEnglishGreetings() : List<String> {
    return listOf(
        "Good day", "Good morning", "Good evening", "Good night", "Hello", "Hello (Southern Germany" +
                " and Austria)", "Hello (Bavaria and Austria)", "Hello (Switzerland)", "Hello " +
                "(Northern Germany)", "Good morning (Switzerland)", "Good evening (Switzerland)",
        "Hello (Bavaria/Austria)"
    )
}

@Composable
fun GermanGreetingList() {
val germanGreetings = getGermanGreetings()
    val english = getEnglishGreetings()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(germanGreetings) { germanGreeting ->
            val index = germanGreetings.indexOf(germanGreeting)
            val englishGreeting = if (index < english.size) english[index] else ""

            PhraseComponent(germanGreeting, englishGreeting)
        }
    }
}

@Composable
fun getGermanGoodByes() : List<String> {
    return listOf(
        "Tschüss", "Tschau", "Auf Wiedersehen", "Auf Wiederhören", "Bis bald", "Bis später",
        "Bis dann", "Pfiad di", "Ade", "Uf Wiederluege"
    )
}

@Composable
fun getEnglishGoodByes() : List<String> {
    return listOf(
        "Bye", "Bye", "See you again", "See you later (phone)", "See you soon", "See you later",
        "Until then", "Bye (Bavaria/Austria)", "Bye (Switzerland)", "See you again (Switzerland)"
    )
}

@Composable
fun GermanGoodbyeList() {

    val germanGoodbye = getGermanGoodByes()
    val englishGoodbye = getEnglishGoodByes()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(germanGoodbye) { germanGoodbyes ->
            val index = germanGoodbye.indexOf(germanGoodbyes)
            val englishGoodbyes = if (index < englishGoodbye.size) englishGoodbye[index] else ""

            PhraseComponent(germanGoodbyes, englishGoodbyes)
        }
    }
}

@Composable
fun getGermanGreetingExpressions() : List<String> {
    return listOf(
        "Wie geht es dir/Ihnen?", "Mir geht es gut", "und dir/Ihnen?", "auch gut danke",
        "Mir geht es nicht gut", "so lala", "Mir geht es schlecht", "Mir geht es besser",
        "Wie göht's dr/ine?", "Mir gaihts guet", "wia gehd's/ wia gehd's eana", "guad und dir/eana",
        "Alles gut bei dir?", "Alles in Ordnung?", "Na?"
    )
}

@Composable
fun getEnglishGreetingExpressions() : List<String> {
    return listOf(
        "How are you (informal/formal)", "I am doing well", "And you?", "Good too, thanks",
        "I am not doing well", "So and so", "I am not well", "I am doing better",
        "How are you - inf/fornmal (Switzerland)", "I am doing well (Switzerland)",
        "How are you - inf/formal (Bavaria)", "Good and you? - inf/formal (Bavaria)",
        "Everything alright?", "Everything in order?", "How's it going"
    )
}

@Composable
fun GermanGreetingExpressionList() {
    val german = getGermanGreetingExpressions()
    val english = getEnglishGreetingExpressions()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun getGermanIntroductories() : List<String> {
    return listOf(
    "Darf ich ... vorstellen?", "Das ist", "Wie heißt du/heißen Sie?", "Ich heiße",
        "Wie ist dein/Ihr Name?", "Mein Name ist", "Ich bin ...", "Wia hoaßt du", "I hoaß",
        "Wie häissisch", "Woher kommst du", "Ich komme aus ...", "Wohar chunsch", "Ich chume us",
        "Wo wohnst du", "Ich wohne in"
    )
}

@Composable
fun getEnglishIntroductories() : List<String> {
    return listOf(

    )
}

@Composable
fun getGermanPhrases() : List<String> {
    return listOf(
        "Entschuldigung", "Sprechen Sie Englisch/Sprichst du Englisch", "Ja", "Nein", "Bitte",
        "Danke", "Gern geschehen", "Wie sagt man... auf deutsch", "Was ist das?",
        "Sprechen Sie bitte langsamer", "Leise bitte!", "Mein Deutsch ist begrenzt",
        "Ich verstehe nicht", "Ich verstehe", "Wie kann ich..", "Alles in Ordnung", "Komm her",
        "Hau ab"
    )
}



@Composable
@Preview(showBackground = true)
fun viewPhraseContents() {
    GermanGreetingList()
}