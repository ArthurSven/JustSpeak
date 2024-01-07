package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_10.ui.theme.AzureBlue

@Composable
fun getGermanSounds(): List<String> {
    return listOf(
        "Ah", "Beh", "Tseh", "Deh", "Eh", "Eff", "Geh", "Haa", "Eeh", "Yot", "Kah", "El", "Em", "En",
        "Oh", "Peh", "Koo", "Er", "Ess", "Teh", "Ooh", "Fow", "Veh", "Eeks", "uepsi-lohn", "Tset",
        "Aeh", "Oeh", "Ueh", "SS"
    )
}

@Composable
fun getGermanLetters(): List<String> {
    return listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Ä", "Ö", "Ü", "ß")
}

@Composable
fun getGermanAdjectives(): List<String> {
    return listOf("Alt", "Neu", "Jung", "Groß", "Klein", "Schön", "Hässlich", "Früh", "Spät", "Leicht",
        "Schwierig", "Langsam", "Schnell", "Lang", "Kurz", "Dick", "Dünn")
}

@Composable
fun getEnglishAdjectives(): List<String> {
    return listOf("Old", "New", "Young", "Tall", "Short/Small", "Beautiful", "Ugly", "Early", "Late",
        "Easy", "Hard", "Slow", "Fast", "Long", "Short", "Fat", "Thin")
}

@Composable
fun getGermanAdjectiveExamples() : List<String> {
    return listOf(
        "Der Hund ist alt (The Dog is old)", "Das Handy ist neu (The phone is new)",
        "Das junge Mädchen isst (The young girl is eating)", "Die große Frau lächelt (The tall woman" +
                "smile)", "Die Kleine Katze springt (The small cat jumps)", "Die Berge sind schön " +
                "(The mountains are beautiful)", "Die hässliche Hexe lacht (The ugly witch is laughing)"
        , "Ich stehe morgens früh auf (I wake up early in the morning)", "Er kommt zu spät (He is late)",
         "Das Lied ist leicht zu lernen (The song is easy to learn)", "Die Prüfung war schwierig " +
                "(The exam was hard)", "Das Internet ist heute langsam (The internet is slow today)",
        "Das Fahrrad ist ziemlich schnell (The bike is pretty fast)", "Der Hals ist lang (The neck is long)",
        "Sie hat kurze lockige Haare (She has short curly hair)", "Der Mann ist dick", "Der Junge ist dÜnn"
    )
}

@Composable
fun GermanDefEndTable() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(color = AzureBlue)
    ) {
        Text(text = "Case",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Masc",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Fem",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Neu",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Plu",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Nom",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Acc",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Dat",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Gen",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
}

@Composable
fun GermanIndEndTable() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(color = AzureBlue)
    ) {
        Text(text = "Case",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Masc",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Fem",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Neu",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "Plu",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Nom",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "er",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "es",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Acc",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "e",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "es",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Dat",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(text = "Gen",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
        Text(text = "en",
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 5.dp))
    }
}

@Composable
fun CaseParagraph(case: String, description: String) {
    Column {
        Text(text = case,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)
        Spacer(modifier = Modifier
            .height(3.dp))
        Text(text = description)
        Spacer(modifier = Modifier
            .height(10.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun ViewComponents() {

}