package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_one_option.*

open class OneActionActivity: AppCompatActivity() {
    private var jsonHelper : JsonUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_option)

        jsonHelper = JsonUtils(this)
        val curScene = intent.getStringExtra("currentScreen")

        setScene(curScene!!)

        optionButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("isFirstGame", false)
            startActivity(intent)
            finish()
        }
    }

    private fun setScene(scene: String) {
        val jsonScene = jsonHelper?.getScene(scene)
        val curScene = Gson().fromJson(jsonScene, OneActionData::class.java)
        val picID = resources.getIdentifier(curScene.picture, "drawable", packageName)

        backImage.setImageDrawable(resources.getDrawable(picID))
        speechText.text = curScene.speech
        optionButton.text = curScene.option
    }
}