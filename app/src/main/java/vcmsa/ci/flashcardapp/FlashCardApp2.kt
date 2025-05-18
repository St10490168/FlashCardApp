package vcmsa.ci.flashcardapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardApp2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        private val  questions = arrayOf(
            "Did the french revolution end in 1799?" +
                    "Is Donald trump the 31st President of the USA?" +
                    "Nelson Mandela was President in 1994?" +
                    "The springbok won the rugby world cup in 2019?" +
                    "North America won the Vietnam War?"
        )
        val answers = booleanArrayOf(true,false,true,true,false)
        var = 0
        var  currentQuestionIndex = 0
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card_app2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}