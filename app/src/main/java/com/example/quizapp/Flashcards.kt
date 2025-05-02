package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Flashcards : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is visible from the Moon.",
        "World War I ended in 1918.",
        "Julius Caesar was a Roman Emperor.",
        "The Berlin Wall fell in 1989."
    )

    private val answers = booleanArrayOf(true, false, true, false, true)

    private var currentIndex = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var nextButton: Button
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private var selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flashcards)

        questionText = findViewById(R.id.txtQuestion)
        feedbackText = findViewById(R.id.txtFeedback)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)
        nextButton = findViewById(R.id.btnNext)

        updateQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            if (currentIndex < questions.size - 1) {
                currentIndex++
                updateQuestion()
            } else {
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun updateQuestion() {
        questionText.text = questions[currentIndex]
        feedbackText.text = ""
        selected = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (selected) return

        val correct = answers[currentIndex]
        if (userAnswer == correct) {
            score++
            feedbackText.text = "Correct!"
        } else {
            feedbackText.text = "Incorrect!"
        }
        selected = true
    }
}
