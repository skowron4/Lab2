package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        // Przycisk przenoszący do kolejnej aktywności
        val nextActivityButton = findViewById<Button>(R.id.buttonInterestingPhoto)
        nextActivityButton.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }

        // Przycisk przenoszący do poprzedniej aktywności
        val previousActivityButton = findViewById<Button>(R.id.buttonBack)
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

    override fun onStart() {
        super.onStart()
        val toast: Toast = Toast.makeText(this, "Activity 3 is started",
            Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER,0, 0)
        toast.show()
    }
}
