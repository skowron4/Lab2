package com.example.lab2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAboutAuthor = findViewById<Button>(R.id.button1)
        buttonAboutAuthor.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        // Przycisk "Hobby"
        val buttonHobby = findViewById<Button>(R.id.button2)
        buttonHobby.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        //Przycisk "Ciekawe zajecie"
        val buttonInteresingActivities = findViewById<Button>(R.id.button3)
        buttonInteresingActivities.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }

        // Przycisk "Numer Kontaktowy"
        val buttonContact = findViewById<Button>(R.id.button4)
        buttonContact.setOnClickListener {
            val phoneNumber = "+48605866874" // Wprowadź właściwy numer telefonu
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        // Przycisk "Zamknij Aplikację"
        val buttonExit = findViewById<Button>(R.id.button5)
        buttonExit.setOnClickListener {
            finishAffinity()
        }
    }
}