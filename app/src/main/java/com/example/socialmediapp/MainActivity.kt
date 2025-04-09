package com.example.socialmediapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Removed Theme wrapping
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background


            ) {
                QuizScreen(quizQuestions)
            }
        }
    }
}



val quizQuestions = listOf(
    Question(
        "What is the capital of France?",
        listOf("Berlin", "Madrid", "Paris", "Rome"),
        "Paris"
    ),
    Question(
        "Which planet is known as the 'Red Planet'?",
        listOf("Earth", "Mars", "Jupiter", "Venus"),
        "Mars"
    ),
    // Add more questions...
)


@Composable
fun QuizScreen(quizQuestions: List<Question>) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var quizFinished by remember { mutableStateOf(false) }

    if (quizFinished) {
        // Display final score
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Quiz Finished!")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Your score: $score / ${quizQuestions.size}")
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                currentQuestionIndex = 0
                score = 0
                selectedAnswer = null
                quizFinished = false
            }) {
                Text("Play Again")
            }

        }
    } else if (currentQuestionIndex < quizQuestions.size) {
        val currentQuestion = quizQuestions[currentQuestionIndex]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Question ${currentQuestionIndex + 1} / ${quizQuestions.size}")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = currentQuestion.text, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))

            currentQuestion.options.forEach { option ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedAnswer == option,
                        onClick = { selectedAnswer = option }
                    )
                    Text(text = option)
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    if (selectedAnswer != null) {
                        if (currentQuestion.isCorrectAnswer(selectedAnswer!!)) {
                            score++
                        }
                        selectedAnswer = null
                        currentQuestionIndex++
                        if (currentQuestionIndex == quizQuestions.size) {
                            quizFinished = true
                        }
                    } else {
                        // Handle case where no option is selected
                    }

                },
                enabled = selectedAnswer != null
            ) {
                Text("Next Question")
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Removed Theme wrapping
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        QuizScreen(quizQuestions)
    }
}