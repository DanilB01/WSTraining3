package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_one_option.*

open class OneActionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_option)

        when(intent.getStringExtra("currentScreen")) {
            "filmPositive" -> setFilmPositiveContent()
            "filmNegative" -> setFilmNegativeContent()
            "costumesPositive" -> setCostumesPositiveContent()
            "costumesNegative" -> setCostumesNegativeContent()
        }
        setAnswer()

        optionButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("isFirstGame", false)
            startActivity(intent)
            finish()
        }
    }

    private fun setAnswer() {
        optionButton.text = getString(R.string.answerLast)
    }

    private fun setFilmPositiveContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.film_back))
        speechText.text = getString(R.string.speechFilmPositive)
    }

    private fun setFilmNegativeContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.film_back))
        speechText.text = getString(R.string.speechFilmNegative)
    }

    private fun setCostumesPositiveContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.halloween_costumes_back))
        speechText.text = getString(R.string.speechCostumesPositive)
    }

    private fun setCostumesNegativeContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.halloween_costumes_back))
        speechText.text = getString(R.string.speechCostumesNegative)
    }
}