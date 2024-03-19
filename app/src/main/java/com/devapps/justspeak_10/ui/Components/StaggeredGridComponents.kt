package com.devapps.justspeak_10.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class GridItem(
    val germanWord: String,
    val englishWord: String,
    val height: Dp,
    val color: Color
)

@Composable
fun RandomColorBox(item: GridItem) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(item.height)
        .clip(RoundedCornerShape(10.dp))
        .background(item.color)
    ) {
        Text(
            text = item.germanWord,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center // Adjust text alignment as needed
        )
    }
}
