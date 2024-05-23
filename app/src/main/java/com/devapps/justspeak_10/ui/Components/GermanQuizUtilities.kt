package com.devapps.justspeak_10.ui.Components

import androidx.compose.runtime.Composable

// Data class to hold a question and its options
data class Question(
    val number: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

fun germanAdjectiveQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1.",
            "What's the German word for beautiful?",
            listOf(
                "Schon", "Schön", "Gut"
            ),
            "Schön",
        ),
        Question(
            "2.",
            "Der Hals ist ... (The neck ist long)",
            listOf(
                "Klein", "groß", "lang"
            ),
            "lang"
        ),
        Question(
            "3.",
            "Das ... Auto (The red car)",
            listOf(
                "roter", "rote", "rot"
            ),
            "rote"
        ),
        Question(
            "4.",
            "Hast du den ... Mann gesehen? (Have you seen the short man?)",
            listOf(
                "kleinen", "klein", "kleiner"
            ),
            "kleinen"
        ),
        Question(
            "5.",
            "What's the german word for slow",
            listOf(
                "Langsam", "Schnell", "Schlow"
            ),
            "Langsam"
        )
    )
}
fun germanCaseQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Der, die das are examples of...",
            listOf(
                "Definite Articles", "Indefinite Articles",
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
        Question(
            "4",
            "Das ist ... schönes Mädchen (That is a beautiful girl)",
            listOf("eine", "eines", "ein"),
            "ein"
        ),
        Question(
            "5",
            "... Junge singt (The boy sings)",
            listOf(
                "den", "der", "dem",
            ),
            "der"
        )
    )
}

fun germanNounQuizQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Ich hätte gerne einen ..., bitte  (I would like an Apple, please)",
            listOf(
                "Appel", "Apfel", "Apple"
            ),
            "Apfel"
        ),
        Question(
            "2",
            "Mein ... hat braune Augen (My father has brown eyes)",
            listOf(
                "Vater", "Father", "Vatter"
            ),
            "Vater"
        ),
        Question(
            "3",
            "Trinkst du gerne ...? (Do you like drinking coffee)",
            listOf(
                "Cafe", "Tee", "Kaffee"
            ),
            "Kaffee"
        ),
        Question(
            "4",
            "Ich gehe in ... ... (I am going in the city)",
            listOf(
                "die Stadt", "den Stadt", "der Stadt"
            ),
            "die Stadt"
        ),
        Question(
            "5",
            "What's the German word for Apartment?",
            listOf(
                "das Haus", "das Gebäude", "die Wohnung"
            ),
            "die Wohnung"
        )
    )
}

fun germanPrepositionQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Which preposition means 'for'?",
            listOf("für", "um", "bis"),
            "für"
        ),
        Question(
            "2",
            "Which preposition is two way?",
            listOf("gegen", "unter", "durch"),
            "unter"
        ),
        Question(
            "3",
            "Which preposition means 'against'?",
            listOf("um", "gegen", "bis"),
            "gegen"
        ),
        Question(
            "4",
            "Which preposition is genitiv?",
            listOf("durch", "für", "wegen"),
            "wegen"
        ),
        Question(
            "5",
            "Which preposition is accusative?",
            listOf("bis", "aus", "mit"),
            "bis"
        )
    )
}

fun germanPronounQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Which pronoun is dative",
            listOf(
                "mich", "mir", "ich"
            ),
            "mir"
        ),
        Question(
            "2",
            "Which pronoun means 'me'",
            listOf(
                "mich", "mir", "ich"
            ),
            "mich"
        ),
        Question(
            "3",
            "What's the english equivalent for 'euch'",
            listOf(
                "you", "you (plural informal)", "you (plural formal)"
            ),
            "you (plural informal)"
        ),
        Question(
            "4",
            "What english word does ihnen correspond to",
            listOf(
                "You (plural formal)", "You (singular formal)", "them"
            ),
            "them"
        ),
        Question(
            "5",
            "Choose the correct set of pronouns",
            listOf(
                "ich dich dir", "du dich ihr", "Er ihn ihm"
            ),
            "Er ihn ihm"
        )
    )
}

fun germanSentenceQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "Ich gehe jetzt ins Bett ... ich bin müde - (I am going to bed because I am tired))",
            listOf(
                "weil", "denn", "aber"
            ),
            "denn"
        ),
        Question(
            "2",
            "Ich schlafe im Auto ...",
            listOf(
                "ein", "an", "dann"
            ),
            "ein"
        ),
        Question(
            "3",
            "Heute, komme ich nicht ... ich krank bin - (I am not coming today because I am sick)",
            listOf(
                "wenn", "denn", "weil"
            ),
            "weil"
        ),
        Question(
            "4",
            "Ich esse ... Apfel - (I am eating an apple)",
            listOf(
                "den", "einen", "eine"
            ),
            "einen"
        ),
        Question(
            "5",
            "How would you say 'I am coming'",
            listOf(
                "Ich kam", "Ich bin kommen", "Ich komme"
            ),
            "Ich komme"
        )
    )
}

fun germanTenseQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "What tense is this sentence - (Ich besuchte meine Oma)",
            listOf(
                "Past simple", "Present perfect", "Past perfect"
            ),
            "Past simple"
        ),
        Question(
            "2",
            "How would you write 'You will achieve it' in Futur I tense",
            listOf(
                "Du hast es geschafft", "Du wirst es schaffen", "Sie wird es schaffen"
            ),
            "Du wirst es schaffen"
        ),
        Question(
            "3",
            "Translate this sentence into the present perfect tense: 'I have visited my grandma.'",
            listOf(
                "Ich habe meine Oma besucht", "Ich besuche meine Oma", "Ich werde meine Oma besuchen"
            ),
            "Ich habe meine Oma besucht"
        ),
        Question(
            "4",
            "Bevor sie ins Bett ..., hatte sie bereits das Buch beendet",
            listOf(
                "gegangen ist", "ging", "geht"
            ),
            "ging"
        ),
        Question(
            "5",
            "What is the Futur II tense of this sentence: 'Er wird das Spiel gewinnen'?",
            listOf(
                "Er wird das Spiel gewonnen haben", "Er hat das Spiel gewinnen werden", "Er wird das Spiel gewinnen wird"
            ),
            "Er wird das Spiel gewonnen haben"
        )
    )
}

fun germanVerbConjugationQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "How would you conjugate: They have",
            listOf(
                "Sie haben", "Ihr habt", "er hat"
            ),
            "Sie haben"
        ),
        Question(
            "2",
            "... du mir bitte helfen? - (Can you please help me)",
            listOf(
                "Können", "Kannst", "Könnt"
            ),
            "Kannst"
        ),
        Question(
            "3",
            "Wo ... ich das Badezimmer? (Where do I find the bathroom)",
            listOf(
                "kann", "finde", "gehe"
            ),
            "finde"
        ),
        Question(
            "4",
            "Choose the correct pattern",
            listOf(
                "Wir sind, Ihr sind, Sie sind", "Wir sind, Ihr seid, Sie sind", "Wir seid, Ihr seid" +
                        ", Sie seid"
            ),
            "Wir sind, Ihr seid, Sie sind"
        ),
        Question(
            "5",
            "What's the verb for - to stand",
            listOf(
                "standen", "gehen", "stehen"
            ),
            "stehen"
        )
    )
}

fun germanIntroductionQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "How would you greet someone at 18:00",
            listOf(
                "Guten Tag","Guten Abend","Guten Morgen"
            ),
            "Guten Abend"
        ),
        Question(
            "2",
            "How do you say 'See you soon' while on the phone",
            listOf(
                "Auf wiedersehen", "Bis morgen", "Auf wiederhören"
            ),
            "Auf wiederhören"
        ),
        Question(
            "3",
            "How do you say 'Bye' in Swiss German",
            listOf(
                "Ade", "Pfiad di", "Tschüß"
            ),
            "Ade"
        ),
        Question(
            "4",
            "How would you appropriately respond to 'Wie geht's dir?'",
            listOf(
                "Mir geht es gut", "Ich bin gut", "Einfach"
            ),
            "Mir geht es gut"
        ),
        Question(
            "5",
            "Woher kommst du",
            listOf(
                "Ich komme heute nicht", "Ich gehe nach Deutschland", "Ich komme aus der Schweiz"
            ),
            "Ich komme aus der Schweiz"
        )
    )
}

fun germanExpressionQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "How would you say 'I don't understand'",
            listOf(
                "Ich verstehe nicht", "Ich weiß nicht", "Ich kenne ihn nicht"
            ),
            "Ich verstehe nicht"
        ),
        Question(
            "2",
            "How would you say 'Speak more slowly please'",
            listOf(
                "Leise bitte!", "Sprechen Sie bitte langsamer", "Hau ab"
            ),
            "Sprechen Sie bitte langsamer"
        ),
        Question(
            "3",
            "How would you say 'My German is limited'",
            listOf(
                "Ich spreche nicht Deutsch", "Mein Deutsch ist begrenzt", "Mein Deutsch ist schlecht"
            ),
            "Mein Deutsch ist begrenzt"
        ),
        Question(
            "4",
            "How would you say 'Quiet please'",
            listOf(
                "Leise, bitte!", "Hau ab, bitte!", "Hör auf, bitte!"
            ),
            "Leise, bitte!"
        ),
        Question(
            "5",
            "Wie sagt man 'a boy' auf deutsch?",
            listOf(
                "Eine Junge", "Einer Junge", "Ein Junge"
            ),
            "Ein Junge"
        ),
    )
}

fun germanDiningQuestions() : List<Question> {
    return listOf(
        Question(
            "1",
            "How would you request to pay with cash",
            listOf(
                "Ich bezahle mit Karte", "Ich bezahle mit Cash", "Ich bezahle mit Bargeld"
            ),
            "Ich bezahle mit Bargeld"
        ),
        Question(
            "2",
            "How would you politely ask for your food to be wrapped",
            listOf(
                "darf ich dass gewrapped lassen", "Könnte ich das einpacken lassen", "Pack das bitte"
            ),
            "Könnte ich das einpacken lassen"
        ),
        Question(
            "3",
            "How would you order Schnityel?",
            listOf(
                "Ich hätte gern Schnitzel", "Ich will Pommes mit Wurst", "Ich hätte gern Eis"
            ),
            "Ich hätte gern Schnitzel"
        ),
        Question(
            "4",
            "",
            listOf(),
            ""
        ),
        Question(
            "5",
            "",
            listOf(),
            ""
        )
    )
}