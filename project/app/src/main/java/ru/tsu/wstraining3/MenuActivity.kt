package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val sharedPreference = SharedPreference(this)
        sharedPreference.clearSharedPreference()

        val jsonHelper = JsonUtils(this)
        val isFirstGame = intent.getBooleanExtra("isFirstGame", true)

        if(isFirstGame) {
            mainText.text = getText(R.string.myVisualNovel)
            actionButton.text = getText(R.string.start)

            if(!jsonHelper.ifScenesAlreadyExist()) {
                jsonHelper.saveScenes()
            }

        } else {
            mainText.text = getText(R.string.thanksForPlaying)
            actionButton.text = getText(R.string.tryAgain)
        }

        actionButton.setOnClickListener {
            startActivity(Intent(this, EditNameActivity::class.java))
            finish()
        }
    }
}