# QuizApp

This is a simple quiz application built with Kotlin and Jetpack Compose for Android. It presents users with a series of multiple-choice questions, tracks their score, and allows them to play again after completing the quiz.

## Features

*   **Multiple-Choice Questions:** The quiz presents questions with several answer options.
*   **Score Tracking:** The app keeps track of the user's score as they answer questions correctly.
*   **Play Again:** Users can restart the quiz after finishing to try and improve their score.
*   **Jetpack Compose UI:** The user interface is built using Jetpack Compose, providing a modern and declarative way to create UI.
*   **Material 3 Design:** The app utilizes Material 3 components for a consistent and up-to-date visual style.

## Project Structure

The project is organized as follows:

*   `MainActivity.kt`: Contains the main activity, the `QuizScreen` composable function, the `Question` data class, and the list of quiz questions.
*   `Question`: A data class representing a single quiz question, with fields for the question text, answer options, and the correct answer.
*   `quizQuestions`: A list of `Question` objects that defines the content of the quiz.
*   `QuizScreen`: A composable function that handles the presentation of the quiz, user interaction, score tracking, and the "Play Again" functionality.
*   `ui.theme`: (If present) Contains theme-related files (e.g., `Theme.kt`, `Color.kt`, `Type.kt`) for customizing the app's appearance. (Note: In the simplified version, the app uses default Material 3 styling and may not have this directory).

## How to Run the App

1.  **Prerequisites:** Ensure you have Android Studio installed and set up with the necessary SDK components.
2.  **Clone the Repository:** Clone this repository to your local machine using Git:

(Replace `<repository_url>` with the actual URL of your GitHub repository).
3.  **Open in Android Studio:** Open the project in Android Studio.
4.  **Build and Run:** Build and run the app on an emulator or a physical Android device.

## Code Overview

### `MainActivity.kt`
