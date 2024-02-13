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
        "Grüezi", "Moin"
    )
}
@Composable
fun getEnglishGreetings() : List<String> {
    return listOf(
        "Good day", "Good morning", "Good evening", "Good night", "Hello", "Hello (Southern Germany" +
                " and Austria)", "Hello (Bavaria and Austria)", "Hello (Switzerland)", "Hello " +
                "(Northern Germany)"
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
@Preview(showBackground = true)
fun viewPhraseContents() {
    GermanGreetingList()
}