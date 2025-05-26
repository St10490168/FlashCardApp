package vcmsa.ci.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FlashCardApp2() : AppCompatActivity(), Parcelable {

        val  questions = arrayOf(
            "Did the french revolution end in 1799?",
            "Is Donald trump the 31st President of the USA?",
            "Nelson Mandela was President in 1994?",
            "The springbok won the rugby world cup in 2019?",
            "North America won the Vietnam War?"
        )
        val answers = booleanArrayOf(true,false,true,true,false)
        val userAnswer = mutableListOf<Boolean>()

        private var score = 0
        private var currentQuestionIndex = 0
        private var hasAnswered = false

        
        lateinit var tvQuestion: TextView
        lateinit var trueButton: Button
        lateinit var falseButton: Button
        lateinit var nextButton: Button
        lateinit var tvAnswer: TextView

    constructor(parcel: Parcel) : this() {
        score = parcel.readInt()
        currentQuestionIndex = parcel.readInt()
        hasAnswered = parcel.readByte() != 0.toByte()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_flash_card_app2)

            tvQuestion = findViewById(R.id.tvQuestions)
            falseButton = findViewById(R.id.btnFalse)
            trueButton = findViewById(R.id.btnTrue)
            nextButton = findViewById(R.id.btnNext)
            tvAnswer = findViewById(R.id.tvAnswer)

            displayQuestion()
        
            trueButton.setOnClickListener {
                if (!hasAnswered)
                checkAnswer(true)
           }

            falseButton.setOnClickListener {
                if (!hasAnswered)
                checkAnswer(false)
           }

            nextButton.setOnClickListener {
                if (hasAnswered)
                    currentQuestionIndex++
                    if (currentQuestionIndex < questions.size) {
                    displayQuestion()
                    tvAnswer.text=""
                    hasAnswered = false
                } else {
                    val intent = Intent(this,FlashCardApp3::class.java)
                    intent.putExtra("score", score)
                    intent.putExtra("userAnswers", userAnswer.toBooleanArray())
                    intent.putExtra("questions", questions)
                    intent.putExtra("answers", answers)
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
        hasAnswered = true



        if (userAnswer == answers[currentQuestionIndex]) {
           tvAnswer.text= "Correct"
            score++
        }else {
            tvAnswer.text = "Incorrect"
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<FlashCardApp2> {
        override fun createFromParcel(parcel: Parcel): FlashCardApp2 {
            return FlashCardApp2(parcel)
        }

        override fun newArray(size: Int): Array<FlashCardApp2?> {
            return arrayOfNulls(size)
        }
    }
}



