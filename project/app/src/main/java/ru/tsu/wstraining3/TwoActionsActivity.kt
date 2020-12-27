package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_two_options.*

open class TwoActionsActivity: AppCompatActivity() {
    private var jsonHelper : JsonUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_options)

        jsonHelper = JsonUtils(this)
        val curScene = intent.getStringExtra("currentScreen")

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

        setScene(curScene!!)
        when(curScene) {
            "preparingHalloween" -> setPrepareHalloweenButtons()
            "film" -> setFilmButtons()
            "costumes" -> setCostumesButtons()
            else -> setDefaultButtons()
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

    private fun setScene(scene: String) {
        val jsonScene = jsonHelper?.getScene(scene)
        val curScene = Gson().fromJson(jsonScene, TwoActionsData::class.java)
        val picID = resources.getIdentifier(curScene.picture, "drawable", packageName)

        backImage.setImageDrawable(resources.getDrawable(picID))
        speechText.text = curScene.speech
        optionOneButton.text = curScene.optionOne
        optionTwoButton.text = curScene.optionTwo
    }
}