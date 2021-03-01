package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity: AppCompatActivity() {
    private var sharedPreference : SharedPreference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val jsonHelper = JsonUtils(this)
        val isFirstGame = intent.getBooleanExtra(AppConstants.isFirstGameString, true)
        sharedPreference = SharedPreference(this)

        if(isFirstGame) {
            mainText.text = getText(R.string.myVisualNovel)
            actionButton.text = getText(R.string.start)

            if(!jsonHelper.ifScenesAlreadyExist()) {
                sharedPreference?.clearSharedPreference()
                jsonHelper.saveScenes()
            }

        } else {
            mainText.text = getText(R.string.thanksForPlaying)
            actionButton.text = getText(R.string.tryAgain)
        }

        actionButton.setOnClickListener {
            startActivity(Intent(this, EditNameActivity::class.java))
            overridePendingTransition(R.anim.zoom_anim, R.anim.static_animation)
            finish()
        }
    }
}