package com.devapps.justspeak_10.ui.Components

import android.widget.Space
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.devapps.justspeak_10.R
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.viewmodels.FlashcardViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

data class GridItem(
    val germanWord: String,
    val englishWord: String,
    val height: Dp,
    val color: Color,
)

@Composable
fun RandomColorBox(
    item: GridItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()
    var isFront by remember { mutableStateOf(true) }

    val rotationState = remember {
        Animatable(0f)
    }

    val showOptions = remember { mutableStateOf(false) }
    val showDeleteDialog = remember { mutableStateOf(false) }

    val frontRotation = 0f
    val backRotation = 180f

    Column(modifier = Modifier
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
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { showOptions.value = true}) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Options",
                    tint = Color.White
                )
            }
        }
        DropdownMenu(
            expanded = showOptions.value,
            onDismissRequest = {
                showOptions.value = false
            },
            modifier = Modifier
                .background(color = Color.White)
                .width(80.dp)) {
            DropdownMenuItem(
                text = {
                    Text(text = "Edit",
                        color = Color.Black)
                },
                onClick = {
                    onEdit()
                    showOptions.value = false
                },
                modifier = Modifier
                    .background(color = Color.White)
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Delete",
                        color = Color.Black)
                },
                onClick = {
                    onDelete()
                    showOptions.value = false
                },
                modifier = Modifier
                    .background(color = Color.White)
            )
        }
        Text(
            text = if (isFront) item.germanWord else item.englishWord,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }

    if (showDeleteDialog.value) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog.value = false },
            title = { Text("Delete Flashcard") },
            text = { Text("Are you sure you want to delete this flashcard?") },
            confirmButton = {
                Button(
                    onClick = {
                            onDelete()
                        showDeleteDialog.value = false
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(onClick = { showDeleteDialog.value = false }) {
                    Text("No")
                }
            }
        )
    }
}
