package com.devapps.justspeak_10.ui.Components

import androidx.compose.runtime.Composable

@Composable
fun getGermanSounds(): List<String> {
    return listOf(
        "Ah", "Beh", "Tseh", "Deh", "Eh", "Eff", "Geh", "Haa", "Eeh", "Yot", "Kah", "El", "Em", "En",
        "Oh", "Peh", "Koo", "Er", "Ess", "Teh", "Ooh", "Fow", "Veh", "Eeks", "uepsi-lohn", "Tset",
        "Aeh", "Oeh", "ueh"
    )
}

@Composable
fun getGermanLetters(): List<String> {
    return listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
}



