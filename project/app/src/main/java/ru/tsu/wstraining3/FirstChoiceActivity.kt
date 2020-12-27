package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first_choice.*

class FirstChoiceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_choice)

        val name = intent.getStringExtra("name")
        val speech = "${getText(R.string.great)}, $name! ${getText(R.string.whatWillDo)}"
        speechText.text = speech

        goFieldWalkingButton.setOnClickListener {
            changeScreen("field")
        }

        goCampingButton.setOnClickListener {
            changeScreen("camping")
        }

        goRunningButton.setOnClickListener {
            changeScreen("running")
        }
    }

    private fun changeScreen(value: String) {
        val intent = Intent(this, TwoActionsActivity::class.java)
        intent.putExtra("currentScreen", value)
        startActivity(intent)
        overridePendingTransition(R.anim.zoom_anim, R.anim.static_animation)
        finish()
    }
}