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

fun getChichewaPlaceNouns() : List<String> {
    return listOf(
        "Nyumba", "Mzinda", "Dziko", "Mudzi", "Nyanja", "Nyanja ya nchele", "Mtsinje", "Phiri",
        "Tchire", "Nkhalango", "Nsewu", "Tchalitchi", "Mzikiti", "Chipatala"
    )
}

fun getEnglischPlaceNouns() : List<String> {
    return listOf(
        "House", "City", "Country", "Village", "lake", "Ocean", "River", "Mountain", "Bush", "Forest",
        "Road", "Church", "Mosque", "Hospital"
    )
}

@Composable
fun ChichewaPlaceNounsList() {
    val chichewa = getChichewaPlaceNouns()
    val englisch = getEnglischPlaceNouns()
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

fun getChichewaFoodAndDrinkNouns() : List<String> {
    return listOf(
        "Chakudya", "Zokumwa", "Madzi", "Nyama", "Masamba", "Zipaso", "Nthochi", "Nsomba", "Nkhuku",
        "Mbatatesi", "Nyemba", "Anyezi", "Mpunga", "Dzungu", "Chinangwa", "Ufa", "Mbale", "Kapu",
        "Nsuzi", "Nteza", "Chimanga", "Mowa", "Foloko", "Spuni", "Mpeni"
    )
}

fun getEnglischFoodAndDrinkNouns() : List<String> {
    return listOf(
        "Food", "Drinks", "Water", "Meat", "Vegetables", "Fruits", "Bananas", "Fish", "Chicken",
        "Potatoes", "Beans", "Onions", "Rice", "Pumpkin", "Cassava", "Flour", "Plate", "Cup", "Soup",
         "Groundnuts", "Maize", "Beer", "Fork", "Spoon", "Knife"
    )
}

@Composable
fun ChichewaFoodAndDrinksList() {
    val chichewa = getChichewaFoodAndDrinkNouns()
    val englisch = getEnglischFoodAndDrinkNouns()
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

fun getChichewaBodyPartsNouns() : List<String> {
    return listOf(
        "Maso", "Mutu", "Thupi", "Mphuno", "Kamwa", "Khutu", "Tsitsi", "Khosi", "Nkono", "Chifuwa",
        "Fupa", "Mwendo", "Phazi", "Chala", "Chala chakuphazi", "Khungu", "Nsana"
    )
}

fun getEnglischBodyPartsNouns() : List<String> {
    return listOf(
        "Eyes", "Head", "Body", "Nose", "Mouth", "Ear", "Hair", "Neck", "Arm", "Chest", "Bone", "Leg",
         "Foot", "Finger", "Toe", "Skin", "Back"
    )
}

@Composable
fun ChichewaBodyPartsNounList() {
    val chichewa = getChichewaBodyPartsNouns()
    val englisch = getEnglischBodyPartsNouns()
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

fun getChichewaNumbers() : List<String> {
    return listOf(
        "Chimodzi", "Ziwiri", "Zitatu", "Zinayi", "Zisano", "Zisano ndi chimodzi", "Zisano ndi ziwiri"
        , "Zisano ndi zitatu", "Zisano ndi zinayi", "Khumi", "Khumi ndi chimodzi", "Khumi ndi ziwiri",
        "Khumi ndi zitatu", "Khumi ndi anayi", "Khumi ndi asanu", "Khumi ndi zisanu ndi chimodzi",
        "Khumi ndi zisanu ndi ziwiri", "Khumi ndi zisanu ndi zitatu", "Khumi ndi zisanu ndi anayi",
        "Makumi awiri"
    )
}

fun getEnglischNumbers() : List<String> {
    return listOf(
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
         "Twenty"
    )
}

@Composable
fun ChichewaNumbersList() {
    val chichewa = getChichewaNumbers()
    val englisch = getEnglischNumbers()
    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

fun getChichewaPronouns() : List<String> {
    return listOf(
        "Ine", "Iwe", "Inu", "Iwo/Awo", "Iye", "Ife"
    )
}

fun getEnglischPronouns() : List<String> {
    return listOf(
        "I/me", "You (informal)", "You (formal or plural)", "They/them", "He/She", "We/Us"
    )
}

@Composable
fun ChichewaPronounList() {
    val chichewa = getChichewaPronouns()
    val englisch = getEnglischPronouns()
    LazyColumn(
        modifier = Modifier
            .height(200.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

fun getChichewaPrefixes() : List<String> {
    return listOf(
        "Ndi", "U", "Mu", "A", "Ti"
    )
}

fun getEnglischPrefixes() : List<String> {
    return listOf(
        "I", "You (informal)", "You (formal/plural)", "He/She/They", "We"
    )
}

@Composable
fun ChichewaPrefixesList() {
    val chichewa = getChichewaPrefixes()
    val englisch = getEnglischPrefixes()
    LazyColumn(
        modifier = Modifier
            .height(180.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

fun getChichewaVerbs() : List<String> {
    return listOf(
        "Kudya", "Kumwa", "Kugona", "Kudzuka", "kupita", "Kubwera", "Kuyenda", "Kukhala",
        "Kukhala ndi", "Kulandila", "Kupeleka/Kupasa", "Kuwona", "Kununkhisa", "Kuyenera", "Kunena",
        "kulankhula", "Kumva", "Kupeza", "Kufunsa", "Kukonda", "Kuloledwa", "Kulola", "Kuyendesa",
        "Kusiya", "Kukana", "Kuyimilila", "Kuphika", "Kupanga", "Kuyamba", "Kumaliza", "Kuphunzira",
         "Kutseka", "Kutsegula", "Kulemba", "Kuwerenga", "Kugula", "Kugulisa", "Kufuna", "Kuwuza"
    )
}

fun getEnglischVerbs() : List<String> {
    return listOf(
        "To eat", "To drink", "To sleep", "To wake up", "To go", "To come", "To walk",
        "To sit/to be/to become", "To have", "To receive/to get", "To give", "To see", "To smell",
        "should/must", "To say", "To speak", "To hear/listen", "to find", "to ask", "to like/love",
         "to be allowed", "to allow", "to drive", "to stop/to leave", "to deny", "to stand up",
         "To cook", "To make/to do", "To start", "To finish", "To learn", "To close", "To open",
        "To write", "To read", "To buy", "To sell", "To want", "To tell"
    )
}

@Composable
fun ChichewaVerbList() {
    val chichewa = getChichewaVerbs()
    val englisch = getEnglischVerbs()
    LazyColumn(
        modifier = Modifier
            .height(400.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

fun getKudyaConjugation() : List<String> {
    return listOf(
        "Ndikudya", "Ukudya", "Mukudya", "Akudya", "Tikudya"
    )
}

fun getEatingConjugation() : List<String> {
    return listOf(
        "I am eating", "You are eating", "You are eating (formal/plural)", "He/She/They is/are eating",
         "We are eating"
    )
}

@Composable
fun ChichewaEatingConjugation() {
    val chichewa = getKudyaConjugation()
    val englisch = getEatingConjugation()
    LazyColumn(
        modifier = Modifier
            .height(160.dp)
    ) {
        items(chichewa) { letter ->
            val index = chichewa.indexOf(letter)
            val chizungu = if (index < englisch.size) englisch[index] else ""

            NounItem(germanNoun = letter, englishNoun = chizungu)
        }
    }
}

fun getKunenaConjugation() : List<String> {
    return listOf(
        "Ndikunena", "Ukunena", "Mukunena", "Akunena", "Tikunena"
    )
}

fun getSayingConjugation() : List<String> {
    return listOf(
        "I am saying", "You are saying (informal)", "You are saying (formal/plural)", "They are saying",
         "We are saying"
    )
}

@Composable
fun ChichewaSayingConjugation() {
    val chichewa = getKunenaConjugation()
    val englisch = getSayingConjugation()
    LazyColumn(
        modifier = Modifier
            .height(160.dp)
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
    ChichewaEatingConjugation()
}