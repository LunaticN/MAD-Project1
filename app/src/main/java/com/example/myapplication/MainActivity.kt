package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var gameStarted: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.start)
        val blueButton: TextView = findViewById(R.id.blue_button)
        val orangeButton: TextView = findViewById(R.id.orange_button)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    //implement various lambda expressions for each button/clickable thing.
    //for the orange and blue text views, check to see that the start button has been clicked by updating some kind of instance variable.
}