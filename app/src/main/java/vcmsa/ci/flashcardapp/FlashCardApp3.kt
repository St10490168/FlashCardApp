package vcmsa.ci.flashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashCardApp3 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_app3)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()
        val userAnswers = intent.getBooleanArrayExtra("userAnswers") ?: booleanArrayOf()

        val tvScore: TextView = findViewById(R.id.tvScore)
        val tvRemark: TextView = findViewById(R.id.tvRemark)
        val btnRestart  = findViewById<Button>(R.id.btnRestart)

        tvScore.text = "Your Score: $score / ${questions.size}"
        tvRemark.text = if (score > 3) "Good Work!" else "Keep Trying"

        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Takes you back to the start screen
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}


