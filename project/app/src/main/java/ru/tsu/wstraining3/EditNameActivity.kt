package ru.tsu.wstraining3

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_name.*

class EditNameActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)

        okButton.setOnClickListener {
            val intent = Intent(this, FirstChoiceActivity::class.java)
            val inputName = nameEditText.text.toString()
            if(inputName.isEmpty()) {
                Toast.makeText(this, R.string.emptyNameError, Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra(AppConstants.nameString, inputName)
                startActivity(intent)
                overridePendingTransition(R.anim.zoom_anim, R.anim.static_animation)
                finish()
            }
        }
    }
}