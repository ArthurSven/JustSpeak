package com.devapps.justspeak_10.ui.Components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

data class GridItem(
    val germanWord: String,
    val englishWord: String,
    val height: Dp,
    val color: Color
)

@Composable
fun RandomColorBox(item: GridItem) {

    val coroutineScope = rememberCoroutineScope()
    var isFront by remember { mutableStateOf(true) }

    val rotationState = remember {
        Animatable(0f)
    }

    val frontRotation = 0f
    val backRotation = 180f

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(item.height)
        .clip(RoundedCornerShape(10.dp))
        .background(item.color)
        .clickable {
            coroutineScope.launch {
                rotationState.animateTo(
                    targetValue = if (isFront) backRotation else frontRotation,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearEasing
                    )
                )
            }
            isFront = !isFront
        },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isFront) item.germanWord else item.englishWord,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
