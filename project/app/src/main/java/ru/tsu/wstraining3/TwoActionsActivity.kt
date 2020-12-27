package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_two_options.*

open class TwoActionsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_options)

        fun setDefaultButtons() {
            optionOneButton.setOnClickListener {
                changeScreenDefault("film")
            }

            optionTwoButton.setOnClickListener {
                changeScreenDefault("preparingHalloween")
            }
        }

        fun setFilmButtons() {
            optionOneButton.setOnClickListener {
                changeToLastScreen("filmPositive")
            }
            optionTwoButton.setOnClickListener {
                changeToLastScreen("filmNegative")
            }
        }

        fun setCostumesButtons() {
            optionOneButton.setOnClickListener {
                changeToLastScreen("costumesPositive")
            }
            optionTwoButton.setOnClickListener {
                changeToLastScreen("costumesNegative")
            }
        }

        fun setPrepareHalloweenButtons() {
            optionOneButton.setOnClickListener {
                changeScreenDefault("film")
            }

            optionTwoButton.setOnClickListener {
                changeScreenDefault("costumes")
            }
        }

        when(intent.getStringExtra("currentScreen")) {
            "field" -> {
                setFieldContent()
                setDefaultButtons()
            }
            "camping" -> {
                setCampingContent()
                setDefaultButtons()
            }
            "running" -> {
                setRunningContent()
                setDefaultButtons()
            }
            "preparingHalloween" -> {
                setPreparingHalloweenContent()
                setPrepareHalloweenButtons()
            }
            "film" -> {
                setFilmContent()
                setFilmButtons()
            }
            "costumes" -> {
                setCostumesContent()
                setCostumesButtons()
            }
        }
    }

    private fun changeScreenDefault(value: String) {
        val intent = Intent(this, TwoActionsActivity::class.java)
        intent.putExtra("currentScreen", value)
        startActivity(intent)
        finish()
    }

    private fun changeToLastScreen(value: String) {
        val intent = Intent(this, OneActionActivity::class.java)
        intent.putExtra("currentScreen", value)
        startActivity(intent)
        finish()
    }

    private fun setFieldContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.fields_back))
        speechText.text = getString(R.string.speechField)
        optionOneButton.text = getString(R.string.optionOneField)
        optionTwoButton.text = getString(R.string.optionTwoField)
    }

    private fun setCampingContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.camping_back))
        speechText.text = getString(R.string.speechCamping)
        optionOneButton.text = getString(R.string.optionOneCamping)
        optionTwoButton.text = getString(R.string.optionTwoCamping)
    }

    private fun setRunningContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.running_back))
        speechText.text = getString(R.string.speechRunning)
        optionOneButton.text = getString(R.string.optionOneRunning)
        optionTwoButton.text = getString(R.string.optionTwoRunning)
    }

    private fun setFilmContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.film_back))
        speechText.text = getString(R.string.speechFilm)
        optionOneButton.text = getString(R.string.optionOneFilm)
        optionTwoButton.text = getString(R.string.optionTwoFilm)
    }

    private fun setPreparingHalloweenContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.halloween_preparing_back))
        speechText.text = getString(R.string.speechPreparingHalloween)
        optionOneButton.text = getString(R.string.optionOnePreparingHalloween)
        optionTwoButton.text = getString(R.string.optionTwoPreparingHalloween)
    }

    private fun setCostumesContent() {
        backImage.setImageDrawable(getDrawable(R.drawable.halloween_costumes_back))
        speechText.text = getString(R.string.speechCostumes)
        optionOneButton.text = getString(R.string.optionOneCostumes)
        optionTwoButton.text = getString(R.string.optionTwoCostumes)
    }
}