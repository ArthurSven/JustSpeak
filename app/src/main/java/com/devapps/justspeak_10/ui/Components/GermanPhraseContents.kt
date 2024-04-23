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
        "Wie ist dein/Ihr Name?", "Mein Name ist", "Ich bin ...", "Wia hoaßt du", "Wie heissisch du"
        , "Woher kommst du", "Ich komme aus ...", "Wohar chunsch", "Ich chume us", "Wo wohnst du",
        "Ich wohne in..."
    )
}

@Composable
fun getEnglishIntroductories() : List<String> {
    return listOf(
        "May I introduce...", "This is", "What's your name - inf/formal", "I am called",
        "What's your name", "My name is", "I am ...", "What's your name (Bavarian)",
        "What's your name (Switzerland)", "Where are you from", "I come from",
        "Where are you from (Switzerland)", "I come from (Switzerland)", "Where do you live",
        "I live in..."
    )
}

@Composable
fun GermanIntroductionExpressionList() {
    val german = getGermanIntroductories()
    val english = getEnglishIntroductories()

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
fun getGermanPhrases() : List<String> {
    return listOf(
        "Entschuldigung", "Sprechen Sie Englisch/Sprichst du Englisch", "Ja", "Nein", "Bitte",
        "Danke", "Gern geschehen", "Wie sagt man... auf deutsch", "Was ist das?",
        "Sprechen Sie bitte langsamer", "Leise bitte!", "Mein Deutsch ist begrenzt",
        "Ich verstehe nicht", "Ich verstehe", "Wie kann ich...", "Alles in Ordnung", "Komm her",
        "Hau ab"
    )
}

@Composable
fun getEnglishPhrases() : List<String> {
    return listOf(
        "Excuse me", "Do you speak english", "Yes", "No", "Please", "Thanks", "Pleasure",
        "How do you say... in german", "What is that?", "Speak slowly please", "Keep quiet!",
        "My german is limited", "I do not understand", "I understand", "How can I...",
        "Everything's alright", "Come here", "Get out!"
    )
}

@Composable
fun GermanBasicExpressionList() {
    val german = getGermanPhrases()
    val english = getEnglishPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun germanEatingRestaurantPhraseList() : List<String> {
    return listOf(
        "Einen Tisch für vier, bitte", "Ist dieser Platz frei?", "Die Speiserkarte, bitte",
        "Ich möchte bestellen", "Ich hätte gern...", "Was würden Sie empfehlen",
        "Nein, das habe ich nicht bestellt", "Hat es ihnen/dir geschmeckt", "Noch eins",
        "Guten Appetite", "Prost", "Sonst noch was?", "Entschuldingen Sie bitte", "Zahlen, bitte",
        "Könnte ich das einpacken lassen?", "Ich möchte eine Reservierung machen", "an Guadn",
        "en Guete", "Kann ich mit Karte bezahlen?", "Kann ich mit Bargeld bezahlen?",
        "Ich bezahle mit Karte", "Ich bezahle mit Bargeld"
    )
}

fun englishEatingRestaurantPhraseList() : List<String> {
    return listOf(
        "A table for four, please", "Is this seat free?", "Menu, please", "I would like to order",
        "I would like...", "What would you recommend?", "No, I did not order this", "Did you enjoy the food?", "One more",
        "Have a nice meal", "Cheers!", "Anything else?", "Excuse me", "Bill please",
        "Can I have this wrapped?", "I would like to make a reservation",
        "Have a nice meal (Bavarian)", "Have a nice meal (Switzerland)", "Can I pay with a card?",
        "Can I pay with cash?", "I will pay with a card", "I will pay with cash"
    )
}

@Composable
fun GermanEatingPhraseList() {
    val german = germanEatingRestaurantPhraseList()
    val english = englishEatingRestaurantPhraseList()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun getGermanShoppingPhrases() : List<String> {
    return listOf(
        "Ich gehe einkaufen", "Wo kann ich .. finden?", "Wie viel kostet das?", "der Preis", "die Kleidung",
        "das Geschäft", "Haben Sie...?", "Verkaufen Sie?", "Ich suche...", "Ich möchte ...", "Das ist teuer",
        "Das ist billig", "Kann ich eine Quittung haben?", "auf welcher Stock kann ich ... finden",
        "Wo finde ich ...", "Das gefällt mir", "Das gefällt mir nicht", "Probier es an"
    )
}

@Composable
fun getEnglishShoppingPhrases() : List<String> {
    return listOf(
        "I am going shopping", "Where can I find...?", "How much does this cost?", "The price",
        "the clothes", "the shop", "Do you have...?", "Do you sell...?", "I am looking for...",
        "I would like...", "That's expensive", "That's cheap", "Can I have a receipt?",
        "On which floor can I find...?", "Where can I find...?", "I like that", "I don't like that",
        "Try it on"
    )
}

@Composable
fun GermanShoppingList() {
    val german = getGermanShoppingPhrases()
    val english = getEnglishShoppingPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun getGermanEmergencyPhrases() : List<String> {
    return listOf(
        "Hilfe!", "Achtung!", "Beeilen Sie sich", "Beeil dich", "Sei Vorsichtig!", "Pass auf!",
        "Können Sie mir helfen?", "Kannst du mir helfen?", "Wie kann ich Ihnen helfen?",
        "Wie kann ich dir helfen?", "Was ist passiert?", "Ich habe einen Notfall", "Es gab einen Unfall"
    )
}

@Composable
fun getEnglishEmergencyPhrases() : List<String> {
    return listOf(
       "Help", "Attention!", "Hurry up (formal)", "Hurry up (informal)", "Be careful", "Take care",
        "Can you help me? (formal)", "Can you help me? (informal)", "How can I help you? (formal)",
        "How can I help you? (informal)", "What happened?", "I have an emergency",
        "There was an accident"
    )
}

@Composable
fun GermanEmergencyList() {
    val german = getGermanEmergencyPhrases()
    val english = getEnglishEmergencyPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun getGermanMedicalEmergencyPhrases() : List<String> {
    return listOf(
        "Ich bin krank", "Bring mich zum Krankenhaus", "Ich bin verletzt", "Ruf den KrankenWagen",
        "Feuer!", "Ich habe eine Erkältung", "Sie ist in Ohnmacht gefallen", "Er ist tot",
        "Ich brauche einen Arzt", "Ich habe mich verbrannt", "Ich habe mich geschnitten",
        "Ist alles in Ordnung?"
    )
}

@Composable
fun getEnglishMedicalEmergencyPhrases() : List<String> {
    return listOf(
        "I am sick", "Take me to the hospital", "I am injured", "Call the ambulance", "Fire!",
        "I have a cold", "She fainted", "He is dead", "I need a doctor", "I burned myself",
        "I cut myself", "Is everything alright?"
    )
}

@Composable
fun GermanMedicalEmergencyList() {
    val german = getGermanMedicalEmergencyPhrases()
    val english = getEnglishMedicalEmergencyPhrases()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(german) { germanPhrases ->
            val index = german.indexOf(germanPhrases)
            val englishPhrases = if (index < english.size) english[index] else ""

            PhraseComponent(germanPhrases , englishPhrases)
        }
    }
}

@Composable
fun getGermanCrimeEmergencyPhrases() : List<String> {
    return listOf(
        "Ich wurde beraubt", "Mein Gepäck wurde gestohlen", "Ruf die Polizei", "Haltet den Dieb!",
        "Meine Wohnung wurde eingebrochen", "Ich möchte ein Verbrechen melden"
    )
}

@Composable
fun getEnglishCrimeEmergencyPhrases() : List<String> {
    return listOf(
        "I was robbed", "My backpack was stolen", "Call the police", "Stop the thief!",
        "My apartment was broken into", "I would like to report a crime"
    )
}

@Composable
fun GermanCrimeEmergencyList() {
    val german = getGermanCrimeEmergencyPhrases()
    val english = getEnglishCrimeEmergencyPhrases()

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
fun getGermanQuestionStarters() : List<String> {
    return listOf(
        "Was", "Wie", "Wo", "Wann", "Welche", "Wer", "Warum", "Wieso", "Woher", "Wohin", "Was für"
    )
}

@Composable
fun getEnglishQuestionStarters() : List<String> {
    return listOf(
        "What", "How", "Where", "When", "Which", "Who", "Why", "Why", "Where... from", "Where... to", "What " +
                "kind of"
    )
}

@Composable
fun GermanQuestionStarterList() {
    val german = getGermanQuestionStarters()
    val english = getEnglishQuestionStarters()

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
fun getGermanFormQuestions() : List<String> {
    return listOf(
        "Was ist das?", "Wie komme ich zum Bahnhof??", "Wo ist das Badezimmer?",
        "Wann kommt der Bus an?", "Welche Mannschaft unterstützen Sie",
        "Wer hat mein Pizza gegessen?", "Woher kommt er?", "Wohin geht Ihr?", "Was für ein Auto ist" +
                " das?"

    )
}

@Composable
fun getEnglishFormQuestions() : List<String> {
    return listOf(
        "What's this/that?", "How do I get to the train station?", "Where is the bathroom",
        "When does the bus arrive?", "Which team do you support?", "Who ate my pizza?",
        "Where does he come from?", "Where are you guys going to?", "What kind of car is that?"
    )
}

@Composable
fun GermanFormQuestionList() {
    val german = getGermanFormQuestions()
    val english = getEnglishFormQuestions()

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
fun getGermanVerbQuestions() : List<String> {
    return listOf(
        "Kannst du mir eine Nachricht schicken?", "Trinkst du auch Bier?", "Kommen Sie zur Party?",
        "Arbeitest du bei IKEA?", "Bist du müde?", "Sind sie jetzt besser?"
    )
}

@Composable
fun getEnglishVerbQuestion() : List<String> {
    return listOf(
        "Can you send me a Message?", "Do you also drink beer?", "Are you coming to the party?",
        "Do you work at IKEA?", "Are you tired?", "Are they better now?"
    )
}

@Composable
fun GermanVerbQuestionList() {
    val german = getGermanVerbQuestions()
    val english = getEnglishVerbQuestion()

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
@Preview(showBackground = true)
fun viewPhraseContents() {
    GermanIntroductionExpressionList()
}