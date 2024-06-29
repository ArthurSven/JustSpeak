package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun getChichewaLetters() : List<String> {

    return listOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    )
}

fun getChichewaSounds() : List<String> {

    return listOf(
        "eh", "bee", "see", "dee", "eeh", "efu", "jee", "etchi", "eye-eeh", "jay", "kay", "elo", "emu",
        "eni", "oh", "pee", "kyu", "ala", "ess", "tee", "you", "vee", "dabyu", "eks", "wayi", "zedi"
    )
}

@Composable
fun ChichewaAlphabetList() {

    val letters = getChichewaLetters()
    val sound = getChichewaSounds()
    LazyColumn(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(letters) { letter ->
            val index = letters.indexOf(letter)
            val pronounce = if (index < sound.size) sound[index] else ""

            NounItem(germanNoun = letter, englishNoun = pronounce)
        }
    }
}

fun getChichewaVowels() : List<String> {
    return listOf(
        "A", "E", "I", "O", "U"
    )
}

fun getChichewaVowelSounds() : List<String> {
    return listOf(
        "aah", "ehh", "eeeeh", "ohhh", "oooooh"
    )
}

@Composable
fun ChichewaVowelsList() {
    val vowels = getChichewaVowels()
    val vSound = getChichewaVowelSounds()
    LazyColumn(
        modifier = Modifier
            .height(150.dp)
    ) {
        items(vowels) { letter ->
            val index = vowels.indexOf(letter)
            val pronounce = if (index < vSound.size) vSound[index] else ""

            NounItem(germanNoun = letter, englishNoun = pronounce)
        }
    }
}

fun getChichewaAdjectives() : List<String> {
    return listOf(
        "kale/kukalamba", "sopano", "kutalika", "kufupika", "kunenepa", "kuwonda", "kukula", "kuchepa",
        "kukongola", "kunyasa",  "kufulumila", "kuchedwa", "kuchuluka", "kufewa", "kulimba", "kuphweka",
        "kuvuta"
    )
}

fun getEnglischAdjectives() : List<String> {
    return listOf(
        "old", "new", "tall", "short", "fat", "thin", "big/ to grow", "small/few", "beautiful", "ugly",
        "early", "late", "many", "soft", "hard", "easy", "difficult"
    )
}

fun getChichewaAdjectiveExamples() : List<String> {
    return listOf(
        "Galuyo akukalamba (the dog is getting old)", "Katunduyo ndiwasopano (Those goods are new)",
        "Mwanayo akutalika (The child is growing tall)", "Munthuyo ndi wamfupi (That person is short)",
        "Mwanenepatu (You have become fat)", "Mukuwonda (You are becoming thin)", "Chimanga chikukula " +
                "(The maize is growing)", "Ndalama zachepa (The money is less)", "Nkaziyo ndiwokongola " +
                "(That girl is beautiful)", "Chikwamacho ndi chonyasa (That bag is ugly)", "Fulumilani chonde" +
                " (Hurry up, please)", "Afika mochedwa (They arrived late)", "Anthu achuluka " +
                "(There are a lot of people)", "Nyama yofewa (Soft meat)", "Mafupa olimba (strong bones)"
        , " Sukulu siyophweka (School is not easy)", "Masamu ndi ovuta (Math is difficult)"
    )
}


@Composable
fun ChichewaAdjectiveList() {
    val chichewa = getChichewaAdjectives()
    val english = getEnglischAdjectives()
    val examples = getChichewaAdjectiveExamples()

    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(chichewa) { chichewaWords ->
            val index = chichewa.indexOf(chichewaWords)
            val second = if (index < english.size) english[index] else ""
            val third = if (index < examples.size) examples[index] else ""

            AdjectiveRow(german = chichewaWords, english = second, example = third)
        }
    }
}

fun getChichewaPeopleNouns() : List<String> {
    return listOf(
        "Munthu", "Anthu", "Amayi", "Abambo", "Mwana", "Mkazi", "Mamuna", "Ntsikana", "Mnyamata",
        "Agogo", "malume", "azakhali", "Mchemwali", "Mlongo", "Mchimwene", "Mlongo", "Msuweni",
        "Mzanga", "Chibwezi", "m'bale", "Banja"
    )
}

fun getEnglischPeopleNouns() : List<String> {
    return listOf(
        "Person", "People", "Mother", "Father", "Child", "Female/Wife", "Male/Husband", "Girl", "Boy",
        "Grandparent", "Uncle", "Aunt", "Sister (for female)", "Sister (for male)", "Brother (for female)",
        "Brother (for male)", "Cousin", "Friend", "Girlfriend/Boyfriend", "Relative", "Family"
    )
}

@Composable
fun ChichewaPeopleNounList() {
    val chichewa = getChichewaPeopleNouns()
    val englisch = getEnglischPeopleNouns()
    LazyColumn(
        modifier = Modifier
            .height(350.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TiwoneNawo() {
    ChichewaPeopleNounList()
}