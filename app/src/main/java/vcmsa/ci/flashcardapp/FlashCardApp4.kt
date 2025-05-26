package vcmsa.ci.flashcardapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashCardApp4 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_app4)

        val ltReview = findViewById<LinearLayout>(R.id.ltReview)
        val btnReset = findViewById<Button>(R.id.btnRestart)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        val userAnswers = intent.getBooleanArrayExtra("userAnswers")

        if (questions != null && answers != null && userAnswers != null) {
            for (i in questions.indices) {
                val textView = TextView(this)
                val correct = answers[i]
                val user = userAnswers[i]
                val result = if (correct == user) "Correct" else "Incorrect"

                textView.text = """
                    Q${i + 1}: ${questions[i]}
                    Your Answer: $user
                    Correct Answer: $correct
                    Result: $result
                """.trimIndent()

                textView.textSize = 16f
                textView.setPadding(0, 20, 0, 20)

                ltReview.addView(textView)
            }
        }

        btnReset.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Optional: clear back stack
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
