package com.devapps.justspeak_10.ui.Screens.German

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devapps.justspeak_10.ui.Components.germanDiningQuestions
import com.devapps.justspeak_10.ui.Components.germanEmergencyQuestions
import com.devapps.justspeak_10.ui.Components.germanExpressionQuestions
import com.devapps.justspeak_10.ui.Components.germanIntroductionQuestions
import com.devapps.justspeak_10.ui.Components.germanQuestionQuestions
import com.devapps.justspeak_10.ui.Components.germanTimeQuestions
import com.devapps.justspeak_10.ui.Components.germanVerbConjugationQuestions
import com.devapps.justspeak_10.ui.theme.AzureBlue

@Composable
fun GermanIntroductionQuiz() {
    val germanIntroductionQuestions = germanIntroductionQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanIntroductionQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanIntroductionQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanIntroductionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanIntroductionQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanIntroductionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanIntroductionQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanIntroductionQuestions.size) { j ->
                val introductionQuizList = germanIntroductionQuestions[j]
                // Display the current question
                Text(
                    text = "${introductionQuizList.number} ${introductionQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                introductionQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != introductionQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${introductionQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanIntroductionQuestions.indices) {
                    if (selectedOptions[i] == germanIntroductionQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanExpressionQuiz() {
    val germanExpressionQuestions = germanExpressionQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanExpressionQuestions.size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanExpressionQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanExpressionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanExpressionQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanExpressionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanExpressionQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanExpressionQuestions.size) { j ->
                val expressionQuizList = germanExpressionQuestions[j]
                // Display the current question
                Text(
                    text = "${expressionQuizList.number} ${expressionQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                expressionQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != expressionQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${expressionQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanExpressionQuestions.indices) {
                    if (selectedOptions[i] == germanExpressionQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanDiningQuiz() {
    val germanDiningQuestions = germanDiningQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanDiningQuestions .size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanDiningQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanDiningQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanDiningQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanDiningQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanDiningQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanDiningQuestions.size) { j ->
                val diningQuizList = germanDiningQuestions[j]
                // Display the current question
                Text(
                    text = "${diningQuizList.number} ${diningQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                diningQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != diningQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${diningQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanDiningQuestions.indices) {
                    if (selectedOptions[i] == germanDiningQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanEmergencyQuiz() {
    val germanEmergencyQuestions = germanEmergencyQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanEmergencyQuestions .size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanEmergencyQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanEmergencyQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanEmergencyQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanEmergencyQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanEmergencyQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanEmergencyQuestions.size) { j ->
                val emergencyQuizList = germanEmergencyQuestions[j]
                // Display the current question
                Text(
                    text = "${emergencyQuizList.number} ${emergencyQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                emergencyQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != emergencyQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${emergencyQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanEmergencyQuestions.indices) {
                    if (selectedOptions[i] == germanEmergencyQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanQuestionQuiz() {
    val germanQuestionQuestions = germanQuestionQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanQuestionQuestions .size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanQuestionQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanQuestionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanQuestionQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanQuestionQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanQuestionQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanQuestionQuestions.size) { j ->
                val questionQuizList = germanQuestionQuestions[j]
                // Display the current question
                Text(
                    text = "${questionQuizList.number} ${questionQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                questionQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != questionQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${questionQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanQuestionQuestions.indices) {
                    if (selectedOptions[i] == germanQuestionQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun GermanTimeQuiz() {
    val germanTimeQuestions = germanTimeQuestions()

    val selectedOptions = remember { mutableStateListOf<String?>() }
    var score by remember { mutableStateOf<Int?>(null) }
    var showCorrectAnswers by remember { mutableStateOf(false) }

    // Initialize the selection state with null values
    if (selectedOptions.size != germanTimeQuestions .size) {
        selectedOptions.clear()
        selectedOptions.addAll(List(germanTimeQuestions.size) { null })
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
            .background(Color.LightGray)
    ) {

        // Display score if available
        score?.let {

            if (it == germanTimeQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanTimeQuestions.size}",
                    color = Color.Magenta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            } else if (it != germanTimeQuestions.size) {
                Text(
                    text = "Your Score: $it/${germanTimeQuestions.size}",
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        // LazyColumn to display questions
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            items(germanTimeQuestions.size) { j ->
                val timeQuizList = germanTimeQuestions[j]
                // Display the current question
                Text(
                    text = "${timeQuizList.number} ${timeQuizList.question}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Display the options as radio buttons
                timeQuizList.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOptions[j] == option,
                            onClick = {
                                selectedOptions[j] = option
                                // Reset score and showCorrectAnswers state when an option is changed
                                score = null
                                showCorrectAnswers = false
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(text = option)
                    }
                }
                if (showCorrectAnswers && selectedOptions[j] != timeQuizList.correctAnswer) {
                    Text(
                        text = "Correct Answer: ${timeQuizList.correctAnswer}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        // Submit Button
        Button(
            onClick = {
                var tempScore = 0
                for (i in germanTimeQuestions.indices) {
                    if (selectedOptions[i] == germanTimeQuestions[i].correctAnswer) {
                        tempScore++
                    }
                }
                score = tempScore
                showCorrectAnswers = true
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzureBlue
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(text = "Submit")
        }
    }
}