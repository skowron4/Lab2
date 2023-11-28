package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class Activity4 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var buttonNormal: Button
    private lateinit var buttonToggle: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)

        // Inicjalizacja elementów interfejsu
        editText = findViewById(R.id.editText)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioGroup = findViewById(R.id.radioGroup)
        checkBox1 = findViewById(R.id.checkBox1)
        checkBox2 = findViewById(R.id.checkBox2)
        buttonNormal = findViewById(R.id.buttonNormal)
        buttonToggle = findViewById(R.id.buttonToggle)

        // Obsługa przycisku zwykłego
        buttonNormal.setOnClickListener {
            val enteredText = editText.text.toString()
            Toast.makeText(this, "Wprowadzony tekst: $enteredText", Toast.LENGTH_SHORT).show()
        }

        // Obsługa przycisku dwustanowego
        buttonToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Przycisk Dwustanowy jest włączony", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Przycisk Dwustanowy jest wyłączony", Toast.LENGTH_SHORT).show()
            }
        }

        // Obsługa przycisku wyboru jednokrotnego
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            Toast.makeText(this, "Wybrano opcję: ${selectedRadioButton.text}", Toast.LENGTH_SHORT).show()
        }

        // Obsługa przycisku wyboru wielokrotnego
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Zaznaczono pierwsze pole wyboru", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Odznaczono pierwsze pole wyboru", Toast.LENGTH_SHORT).show()
            }
        }

        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Zaznaczono drugie pole wyboru", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Odznaczono drugie pole wyboru", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonExit = findViewById<Button>(R.id.closeButton)
        buttonExit.setOnClickListener {
            finishAffinity()
        }

        val previousActivityButton = findViewById<Button>(R.id.backButton)
        previousActivityButton.setOnClickListener {
            finish()
        }

        previousActivityButton.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                // Zamknij wszystkie aktywności poza aktywnością główną
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
                return true
            }
        })
    }
}
