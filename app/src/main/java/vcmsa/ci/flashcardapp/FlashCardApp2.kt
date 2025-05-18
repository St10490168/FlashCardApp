package vcmsa.ci.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FlashCardApp2 : AppCompatActivity() {

        val  questions = arrayOf(
            "Did the french revolution end in 1799?" +
                    "Is Donald trump the 31st President of the USA?" +
                    "Nelson Mandela was President in 1994?" +
                    "The springbok won the rugby world cup in 2019?" +
                    "North America won the Vietnam War?"
        )
        val answers = booleanArrayOf(true,false,true,true,false)
        
        var score = 0
        var currentQuestionIndex = 0
        
        lateinit var tvQuestion: TextView
        lateinit var trueButton: Button
        lateinit var falseButton: Button
        lateinit var nextButton: Button
        lateinit var tvAnswer: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_flash_card_app2)

        questions = findViewById(tvQuestion)
        falseButton = findViewById(R.id.btnFalse)
        trueButton = findViewById(R.id.btnTrue)
        nextButton = findViewById(R.id.btnNext)
        answers = findViewById(R.id.tvAnswer)

        
        displayQuestion()
        
        trueButton.setOnClickListener { 
            checkAnswer(
                true,
                userAnswer = TODO()
            )
        }
        falseButton.setOnClickListener { 
            checkAnswer(
                false,
                userAnswer = TODO()
            )
        }
        nextButton.androidx.compose.foundation.layout.Box {
            setOnClickListener {
                currentQuestionIndex
                if (currentQuestionIndex < questions.size) {
                    tvAnswer()
                } else {
                    val intent = Intent(this,AppCompatActivity::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }


            }
        }


    fun displayQuestion() {
        tvQuestion.text = questions[currentQuestionIndex]
    }

    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            score++
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
        }
    }
}
