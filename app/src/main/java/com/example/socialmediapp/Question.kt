package com.example.socialmediapp

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: String
) {
    fun isCorrectAnswer(selectedAnswer: String) {

    }
}
