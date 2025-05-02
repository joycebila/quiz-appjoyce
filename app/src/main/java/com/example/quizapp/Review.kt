package com.example.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Review : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = findViewById<TextView>(R.id.Review)
        val sb = StringBuilder()
        if (questions != null && answers != null) {
            for (i in questions.indices) {
                sb.append("${i + 1}. ${questions[i]}\nAnswer: ${answers[i]}\n\n")
            }
        }
        reviewText.text = sb.toString()
    }
}
