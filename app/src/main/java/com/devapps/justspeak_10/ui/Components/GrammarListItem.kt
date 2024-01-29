package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold)
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
fun CaseParagraph(
    case: String,
    description: String,
    example: String) {
    Column {
        Text(text = case,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)
        Spacer(modifier = Modifier
            .height(3.dp))
        Text(text = description)
        Spacer(modifier = Modifier
            .height(3.dp))
        Text(text = "e.g. $example")
        Spacer(modifier = Modifier
            .height(10.dp))
    }
}

@Composable
fun GermanDefiniteArticleTable() {
    Column {
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "der",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "das",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "den",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "das",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "die",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "dem",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "dem",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "den",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "des",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "des",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "der",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
    }
}

@Composable
fun GermanIndefiniteArticleTable() {
    Column {
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "ein",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eine",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "ein",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "einen",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eine",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "ein",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "einem",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einer",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einem",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
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
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold)
            Text(text = "eines",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "einer",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "eines",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
            Text(text = "-",
                modifier = Modifier
                    .weight(0.25f)
                    .padding(start = 5.dp))
        }
    }
}

@Composable
fun AdjectiveRow(german: String, english: String, example: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = german,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier
                .width(30.dp))
            Text(text = "-")
            Spacer(modifier = Modifier
                .width(30.dp))
            Text(text = english)
        }
        Spacer(modifier = Modifier
            .height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "e.g.",
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier
                .width(10.dp))
            Text(text = example)
        }
    }
}

@Composable
fun GermanAlphabetItem(letter: String, sound: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        Text(text = letter,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier
            .width(30.dp))
        Text(text = "-",
            fontSize = 20.sp)
        Column(
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Text(text = sound,
                fontSize = 20.sp)
        }
    }
}

@Composable
fun TextsForArticles(article: String, def: String) {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(" - $article - ")
        }
        append(def)
    }

    Text(text = text)
}


@Composable
fun GermanAlphabetList() {
    val letters = getGermanLetters()
    val sounds = getGermanSounds()

    LazyColumn {
        items(letters) { letter ->
            val index = letters.indexOf(letter)
            val sound = if (index < sounds.size) sounds[index] else ""

            NounItem(germanNoun = letter, englishNoun = sound)
        }
    }

}

@Composable
fun GermanAdjectiveList() {
    val german = getGermanAdjectives()
    val english = getEnglishAdjectives()
    val examples = getGermanAdjectiveExamples()

    LazyColumn(
        modifier = Modifier
            .height(350.dp)
    ) {
        items(german) { germanWorter ->
            val index = german.indexOf(germanWorter)
            val second = if (index < english.size) english[index] else ""
            val third = if (index < examples.size) examples[index] else ""

            AdjectiveRow(german = germanWorter, english = second, example = third)
        }
    }
}

@Composable
fun NounItem(germanNoun: String, englishNoun: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Text(
            text = germanNoun,
            modifier = Modifier
                .weight(0.33f)
        )
        Text(
            text = englishNoun,
            modifier = Modifier
                .weight(0.33f)
        )
    }
}

@Composable
fun germanPeopleNouns() : List<String> {
    return listOf(
        "die Mutter", "der Vater", "die Töchter", "der Sohn", "der Onkel", "die Tante",
        "der Großvater", "die Großmutter", "der Enkel", "die Enkelin", "die Cousine", "der Cousin",
        "der Bruder", "die Schwester", "der Mann", "die Frau", "der Junge", "das Mädchen",
        "der Urgroßvater", "die Urgroßmutter", "der Urenkel", "die Urenkelin", "der Freund von mir",
        "die Freundin von mir", "der Freund","die Freundin", "Papa", "Mama", "Opa", "Oma"
    )
}

@Composable
fun englishPeopleNouns() : List<String> {
    return listOf(
        "Mother", "Father", "Daughter", "Son", "Uncle", "Aunt", "Grandfather", "Grandmother",
        "Grandson", "Granddaughter", "Cousin (female)", "Cousin (male)", "Brother", "Sister", "Man",
        "Woman", "Boy", "Girl", "Great-Grandfather", "Great-Grandmother", "Great-Grandson",
        "Great-Granddaughter", "Friend (male)", "Friend (female)", "Boyfriend", "Girlfriend", "dad",
        "mum", "Grandpa", "Grandma"
    )
}

@Composable
fun GermanPeopleNounList() {
    val german = germanPeopleNouns()
    val english = englishPeopleNouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(german) { germanNouns ->
            val index = german.indexOf(germanNouns)
            val englishNouns = if (index < english.size) english[index] else ""

            NounItem(germanNoun = germanNouns, englishNoun = englishNouns)
        }
    }
}

@Composable
fun getGermanPlaceNouns() : List<String> {
    return listOf(
        "das Haus", "die Wohnung", "das Gebäude", "die Stadt", "das Land", "das Dorf", "der See",
        "das Meer", "der Berg", "der Strand", "der Laden", "die Straße", "die Gemeinde", "die Kirche",
        "die Moschee"
    )
}

@Composable
fun getEnglishPlaceNouns() : List<String> {
    return listOf(
        "House", "Apartment", "Building", "City", "Country", "Village", "Lake", "Sea", "Mountain",
        "Beach", "Shop", "Street/Road", "Community", "Church", "Mosque"
    )
}

@Composable
fun GermanPlaceNounList() {
    val german = getGermanPlaceNouns()
    val english = getEnglishPlaceNouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(german) { germanNouns ->
            val index = german.indexOf(germanNouns)
            val englishNouns = if (index < english.size) english[index] else ""

            NounItem(germanNoun = germanNouns, englishNoun = englishNouns)
        }
    }
}

@Composable
fun getGermanFoodNouns() : List<String> {
    return listOf(
        "der Apfel", "die Banane", "der Rindfleisch", "das Huhn", "der Schweinfleisch", "das Gemüse",
        "der Kuchen", "die Kartoffeln", "die Pommes", "das Wasser", "der Kaffee", "der Tee", "die Böhnen"
        , "der Reis", "der Saft", "das Bier", "Brot", "Frühstück", "Mittagessen", "Abendessen",
        "die Teller", "die Tasse", "die Gabel", "der Löffel", "das Messer"
    )
}

@Composable
fun getEnglishFoodNouns() : List<String> {
    return listOf(
        "Apple", "Banana", "Beef", "Chicken", "Pork", "Vegetables", "Cake", "Potatoes", "Chips/Fries",
        "Water", "Coffee", "Tea", "Beans", "Rice", "Juice", "Beer", "Bread", "Breakfast", "Lunch", "Dinner",
        "Plate", "Cup", "Fork", "Spoon", "Knife"
    )
}

@Composable
fun GermanFoodNounList() {
    val german = getGermanFoodNouns()
    val english = getEnglishFoodNouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(german) { germanNouns ->
            val index = german.indexOf(germanNouns)
            val englishNouns = if (index < english.size) english[index] else ""

            NounItem(germanNoun = germanNouns, englishNoun = englishNouns)
        }
    }
}

@Composable
fun getGermanBodyPartNouns() : List<String> {
    return listOf(
        "das Auge", "der Kopf", "der Körper", "die Nase", "der Mund", "das Ohr", "die Haare", "der Hals",
        "der Arm", "der Finger", "die Brust", "der Ellbogen", "der Knochen", "das Bein", "der Fuß",
        "das Zeh", "der Haut", "der Rücken"
    )
}

@Composable
fun getEnglishBodyPartNouns() : List<String> {
    return listOf(
        "Eye", "Head", "Body", "Mouth", "Ear", "Hair", "Neck", "Arm", "Finger", "Chest", "Elbow",
        "Bone", "Leg", "Foot", "Toe", "Skin", "Back"
    )
}

@Composable
fun GermanBodyPartNounList() {
    val german = getGermanBodyPartNouns()
    val english = getEnglishBodyPartNouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(german) { germanNouns ->
            val index = german.indexOf(germanNouns)
            val englishNouns = if (index < english.size) english[index] else ""

            NounItem(germanNoun = germanNouns, englishNoun = englishNouns)
        }
    }
}

@Composable
fun PronounTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(
                text = "Nominative",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Accusative",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Dative",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
        }
        GermanPronounList()
    }
}

@Composable
fun PronounRow(nominative: String, accusative: String, dative: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            text = nominative,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = accusative,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = dative,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun getNominativePronouns() : List<String> {
    return listOf(
        "Ich (I)", "Du (you)", "Er (he)", "Sie (she)", "Es (it)", "Wir (we)", "Ihr (you plural)",
        "Sie (You formal)", "sie (they)"
    )
}

@Composable
fun getAccusativePronouns() : List<String> {
    return listOf(
        "mich (me)", "dich (you)", "ihn (him)", "sie(her)", "es (it)", "uns (us)", "euch (you)",
        "sie (you)", "sie (them)"
    )
}

@Composable
fun getDativePronouns() : List<String> {
    return listOf(
        "mir (to me)", "dir (to you)", "ihm (to him/it)", "ihr (to her/it)", "ihm (to it)",
        "uns (to us)", "euch (to you)", "Ihnen (to you)", "ihnen (to them)"
    )
}

@Composable
fun GermanPronounList() {
    val nom = getNominativePronouns()
    val acc = getAccusativePronouns()
    val dat = getDativePronouns()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(nom) { germanPronouns ->
            val index = nom.indexOf(germanPronouns)
            val accPronouns = if (index < acc.size) acc[index] else ""
            val datPronouns = if (index < dat.size) dat[index] else ""

            PronounRow(nominative = germanPronouns, accusative = accPronouns, dative = datPronouns)
        }
    }
}

@Composable
fun germanCommonVerbs() : List<String> {
    return listOf(
        "haben", "sein", "werden", "können", "machen", "gehen", "sollen", "kommen", "geben", "sagen",
        "müssen", "sehen", "finden", "mögen", "dürfen", "fahren", "liegen", "lassen", "stehen",
        "heißen"
    )
}

@Composable
fun englishCommonVerbs() : List<String> {
    return listOf(
        "to have", "to be", "to become", "to be able to", "to do", "to go", "should", "to come",
        "to give", "to say", "must", "to see", "to find", "to like", "to be allowed to", "to drive",
        "to lay", "to let", "to stand", "to be called"
    )
}

@Composable
fun GermanVerbList() {
    val verb = germanCommonVerbs()
    val translation = englishCommonVerbs()

    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(verb) { germanVerbs ->
            val index = verb.indexOf(germanVerbs)
            val translatedVerbs = if (index < translation.size) translation[index] else ""

            VerbRow(verbs = germanVerbs, translations = translatedVerbs)
        }
    }

}

@Composable
fun VerbRow(verbs: String, translations: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            text = verbs,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp)
        )
        Text(
            text = translations,
            modifier = Modifier
                .weight(0.50f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun VerbTable() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(
                text = "Verb",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.50f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Translation",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.50f)
                    .padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier
            .height(5.dp))
        GermanVerbList()
    }
}

@Composable
fun HabenConjugationTable() {
    Column {
        ConjugationTableRow()
        HabenList()
    }
}

@Composable
fun SeinConjugationTable() {
    Column {
        ConjugationTableRow()
        SeinList()
    }
}

@Composable
fun KannConjugationTable() {
    Column {
        ConjugationTableRow()
        KannList()
    }
}

@Composable
fun ConjugationTableRow() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = AzureBlue)
        ) {
            Text(
                text = "Pronoun",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Conjugation",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
            Text(
                text = "Translation",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(0.33f)
                    .padding(start = 5.dp)
            )
        }
}

@Composable
fun ConjugationTableItem(pron: String, conj: String, trans: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)

    ) {
        Text(
            text = pron,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = conj,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
        Text(
            text = trans,
            modifier = Modifier
                .weight(0.33f)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun getHabenConjugation() : List<String> {
    return listOf(
        "Ich habe", "Du hast (informal)", "Er hat", "Sie hat", "Es hat", "Wir haben",
        "Ihr habt (informal)", "Sie haben (formal)", "Sie haben"
    )
}

@Composable
fun getHaveTranslation() : List<String> {
    return listOf(
        "I have", "You have", "He has", "She has", "It has", "We have", "You have", "You have",
        "They have"
    )
}

@Composable
fun HabenList() {
    val pro = getNominativePronouns()
    val conjugator = getHabenConjugation()
    val habeTranslate = getHaveTranslation()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { habeConj ->
            val index = pro.indexOf(habeConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(habeConj, conjugation, translation)
        }
    }
}

@Composable
fun SeinList() {
    val pro = getNominativePronouns()
    val conjugator = getSeinConjugation()
    val habeTranslate = getSeinTranslated()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { seinConj ->
            val index = pro.indexOf(seinConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(seinConj, conjugation, translation)
        }
    }
}

@Composable
fun KannList() {
    val pro = getNominativePronouns()
    val conjugator = getKannConjugation()
    val habeTranslate = getKannTranslated()

    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(pro) { kannConj ->
            val index = pro.indexOf(kannConj)
            val conjugation = if (index < conjugator.size) conjugator[index] else ""
            val translation = if (index < habeTranslate.size) habeTranslate[index] else ""

            ConjugationTableItem(kannConj, conjugation, translation)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewComponents() {
    GermanFoodNounList()
}