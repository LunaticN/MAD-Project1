package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var blueButton: TextView
    private lateinit var orangeButton: TextView
    private lateinit var layout: LinearLayout
    private lateinit var scoreText: TextView
    private lateinit var strikesText: TextView
    private lateinit var screenText: TextView


    var gameStarted: Boolean = false
    var score: Int = 0
    var strikes: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start)
        blueButton = findViewById(R.id.blue_button)
        orangeButton = findViewById(R.id.orange_button)
        layout = findViewById(R.id.main)
        scoreText = findViewById(R.id.score)
        strikesText = findViewById(R.id.strikes)
        screenText = findViewById(R.id.screenText)

        startButton.setOnClickListener {
                layout.setBackgroundColor(Color.parseColor("#FFFDEF74"))
                startButton.text = "START"
                scoreText.setTextColor(Color.BLACK)
                strikesText.setTextColor(Color.BLACK)
                strikes = 0
                score = 0
                screenText.text = "Tap the larger number!"
                gameStarted = true
                blueButton.text = (0..100).random().toString()
                orangeButton.text = (0..100).random().toString()
                scoreText.text = "Score: " + score
                strikesText.text = "Strikes: " + strikes
        }

        blueButton.setOnClickListener {
            if (gameStarted){
                mainMechanic(blueButton, orangeButton, layout, scoreText, strikesText)
                endgame(startButton, blueButton, orangeButton, screenText, layout, scoreText, strikesText)
            }
        }

        orangeButton.setOnClickListener {
            if (gameStarted){
                mainMechanic(orangeButton, blueButton, layout, scoreText, strikesText)
                endgame(startButton, blueButton, orangeButton, screenText, layout, scoreText, strikesText)
            }
        }
    }

    fun endgame(startButton: Button, blueButton: TextView, orangeButton: TextView, screenText: TextView, layout: LinearLayout, scoreText: TextView, strikesText: TextView): Unit {
        if (score == 10 || strikes == 3){
            blueButton.text = ""
            orangeButton.text = ""
            screenText.text = "Tap restart to play again!"
            startButton.text = "RESTART"
            layout.setBackgroundColor(Color.parseColor("#FFFDEF74"))
            gameStarted = false
            if (score == 10){
                Toast.makeText(this, "Congrats, you won!", Toast.LENGTH_SHORT).show()
                scoreText.setTextColor(Color.GREEN)
                strikesText.setTextColor(Color.BLACK)
            }
            else {
                Toast.makeText(this, "Sorry, you lost", Toast.LENGTH_SHORT).show()
                scoreText.setTextColor(Color.BLACK)
                strikesText.setTextColor(Color.RED)
            }
        }
        else{
            blueButton.text = (0..100).random().toString()
            orangeButton.text = (0..100).random().toString()
        }
    }

    fun mainMechanic(buttonA: TextView, buttonB: TextView, layout: LinearLayout, scoreText: TextView, strikesText: TextView): Unit {
        scoreText.setTextColor(Color.BLACK)
        strikesText.setTextColor(Color.BLACK)
        if (Integer.parseInt(buttonA.text.toString()) > Integer.parseInt(buttonB.text.toString())){
            layout.setBackgroundColor(Color.GREEN)
            score++
            scoreText.text = "Score: " + score
            scoreText.setTextColor(Color.YELLOW)
        }
        else if (Integer.parseInt(buttonA.text.toString()) < Integer.parseInt(buttonB.text.toString())){
            layout.setBackgroundColor(Color.RED)
            strikes++
            strikesText.text = "Strikes: " + strikes
            strikesText.setTextColor(Color.YELLOW)
        }
    }
}