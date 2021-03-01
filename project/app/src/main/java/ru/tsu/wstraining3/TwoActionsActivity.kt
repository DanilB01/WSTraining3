package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_two_options.*

open class TwoActionsActivity: AppCompatActivity() {
    private var jsonHelper : JsonUtils? = null
    private val consts = AppConstants

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_options)

        jsonHelper = JsonUtils(this)
        val curScene = intent.getStringExtra(consts.currentScreenString)

        fun setDefaultButtons() {
            optionOneButton.setOnClickListener {
                changeScreenDefault(consts.filmString)
            }

            optionTwoButton.setOnClickListener {
                changeScreenDefault(consts.preparingHalloweenString)
            }
        }

        fun setFilmButtons() {
            optionOneButton.setOnClickListener {
                changeToLastScreen(consts.filmPositiveString)
            }
            optionTwoButton.setOnClickListener {
                changeToLastScreen(consts.filmNegativeString)
            }
        }

        fun setCostumesButtons() {
            optionOneButton.setOnClickListener {
                changeToLastScreen(consts.costumesPositiveString)
            }
            optionTwoButton.setOnClickListener {
                changeToLastScreen(consts.costumesNegativeString)
            }
        }

        fun setPrepareHalloweenButtons() {
            optionOneButton.setOnClickListener {
                changeScreenDefault(consts.filmString)
            }

            optionTwoButton.setOnClickListener {
                changeScreenDefault(consts.costumesString)
            }
        }

        setScene(curScene!!)
        when(curScene) {
            consts.preparingHalloweenString -> setPrepareHalloweenButtons()
            consts.filmString -> setFilmButtons()
            consts.costumesString -> setCostumesButtons()
            else -> setDefaultButtons()
        }
    }

    private fun changeScreenDefault(value: String) {
        val intent = Intent(this, TwoActionsActivity::class.java)
        intent.putExtra(consts.currentScreenString, value)
        startActivity(intent)
        finish()
    }

    private fun changeToLastScreen(value: String) {
        val intent = Intent(this, OneActionActivity::class.java)
        intent.putExtra(consts.currentScreenString, value)
        startActivity(intent)
        overridePendingTransition(R.anim.zoom_anim, R.anim.static_animation)
        finish()
    }

    private fun setScene(scene: String) {
        val jsonScene = jsonHelper?.getScene(scene)
        val curScene = Gson().fromJson(jsonScene, TwoActionsData::class.java)
        val picID = resources.getIdentifier(curScene.picture, consts.drawableDefType, packageName)

        backImage.setImageDrawable(resources.getDrawable(picID))
        speechText.text = curScene.speech
        optionOneButton.text = curScene.optionOne
        optionTwoButton.text = curScene.optionTwo
    }
}