package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class FunFact(
    val name: String,
    val content: String
)

fun getGermanTriviaContent() : List<FunFact> {
    return listOf(
        FunFact(
            "Germany loves bread",
            "Germany brands over 300 different types of Bread"
        ),
        FunFact(
            "Germany was officially born on 18th January, 1871",
            "The German speaking states were officially united to becoming a country in 1871." +
                    " Before that, it was a bunch of small duchies and kingdoms with a common language."
        ),
        FunFact(
            "German is quite popular",
            "The German language is the most common native language in Europe and comes third" +
                    " on languages most taught in schools."
        ),
        FunFact(
            "Germany loves its fußball",
            "Germany has the most football fan clubs in the world. Both the mens and women's" +
                    " team boast a trophy cabinet of up to 18 trophies in total, World cups, Euros" +
                    " and Confederations cup combined."
        ),
        FunFact(
            "Land of the fairy tales",
            "Some of the most famous fairy tales in the world have German origins, these " +
                    "include Hansel and Gretel, Snow white, Repunzel, Little red riding hood. Most " +
                    "of these were written by the Brothers Grimm. Germany also boasts about 2100 " +
                    "castles."
        ),
        FunFact(
            "SME's make up most of Germany's economic output",
            "Backbone of German economy is actually, contributing over 52% output to the economy." +
                    " They are called Mittelstand."
        ),
    )
}

@Composable
fun GermanyFactList() {
    val germanFacts = getGermanTriviaContent()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(10.dp)
    ) {
        items(germanFacts) { germanFact ->
            germanFacts.indexOf(germanFact)
            TriviaCard(title = germanFact.name, fact = germanFact.content)
        }
    }
}

fun getChichewaTriviaContent() : List<FunFact> {
    return listOf(
        FunFact(
            "The calendar lake",
            "Malawi's biggest tourist attraction is Lake Malawi, a freshwater lake which stretches" +
                    " over 365 miles from the Northern region to the Southern region."
        ),
        FunFact(
            "Pioneer of tea",
            "Malawi was the first country in Africa to grow tea commercially. Tea seeds were " +
                    "brought to Malawi by Scottish missionaries as early sd 1886"
        ),
        FunFact(
            "Largest number of fish species",
            "Lake Malawi holds the largest number of fish in the world. There are over 500 - 1000" +
                    " different species of fish in lake Malawi. The most popular species are the " +
                    "bright coloured Cichlids"
        ),
        FunFact(
            "Free in 1964",
            "Malawi gained it independence from the British in 1964, with Dr Hastings Kamuzu " +
                    "Banda sa Prime minister and then President."
        ),
        FunFact(
            "18.6 million people from Malawi",
            "Malawi has a population of 18.6 million people. Of these, 70% live on less than " +
                    "$1.90. 83% lives in rural areas."
        ),
    )
}

@Composable
fun MalawiFactList() {
    val malawiFacts = getChichewaTriviaContent()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(10.dp)
    ) {
        items(malawiFacts) { chichewaFact ->
            malawiFacts.indexOf(chichewaFact)
            TriviaCard(title = chichewaFact.name, fact = chichewaFact.content)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GermanTriviaCheck() {
    GermanyFactList()
}