package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val scoreText = findViewById<TextView>(R.id.txtScore)
        val feedbackText = findViewById<TextView>(R.id.txtFinalFeedback)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)

        scoreText.text = "Your Score: $score/5"
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practicing!"

        reviewButton.setOnClickListener {
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", answers)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity() // Exit app
        }
    }
}
