package com.devapps.justspeak_10.ui.Components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun profileCard(
    backgroundColor: Color,
    country: Int,
    language: String,
    borderColor: Color,
) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.elevatedCardColors(
                containerColor = backgroundColor
            )

            ,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(all = 20.dp)
                .height(120.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Image(
                    painter = painterResource(country),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(5.dp, borderColor),
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier
                    .width(10.dp))
                Column {
                    Text(text = language,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White)
                    Text(text = "Kick off your learning today",
                        fontSize = 14.sp,
                        color = Color.White)
                }
            }
        }

}

@Composable
fun GermanPhraseCard(
    selected: Boolean,
    phraseTitle: String,
    phraseDescription: String,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(10.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors( containerColor = Color.White),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp)
        ) {
            Spacer(modifier = Modifier
                .height(10.dp))
            Text(text = phraseTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Spacer(modifier = Modifier
                .height(5.dp))
            Text(
                text = phraseDescription,
                textAlign = TextAlign.Justify)
        }
    }
}

@Composable
fun makeBulletedList(items: List<String>): AnnotatedString {
    val bulletString = "\u2022\t\t"
    val textStyle = LocalTextStyle.current
    val textMeasurer = rememberTextMeasurer()
    val bulletStringWidth = remember(textStyle, textMeasurer) {
        textMeasurer.measure(text = bulletString, style = textStyle).size.width
    }
    val restLine = with(LocalDensity.current) { bulletStringWidth.toSp() }
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = restLine))

    return buildAnnotatedString {
        items.forEach { text ->
            withStyle(style = paragraphStyle) {
                append(bulletString)
                append(text)
            }
        }
    }
}

@Composable
fun getCurrentDate() : String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    return currentDate.format(formatter)
}

@Composable
@Preview(showBackground = true)
fun CheckComponents() {

}