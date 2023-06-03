package com.example.barabashka

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import java.util.Random
import java.util.concurrent.ThreadLocalRandom


class MultiplicationActivity : AppCompatActivity() {

    private lateinit var tvNumber1: TextView
    private lateinit var tvNumber2: TextView
    private lateinit var tvTimer: TextView
    private lateinit var tvCorrectSolution: TextView
    private lateinit var etSolution: EditText
    private lateinit var btnDone: Button
    private lateinit var btnMenu: Button
    private lateinit var btnBegin: Button
    private lateinit var tvQualification:TextView
    private lateinit var tvOperation:TextView

    private lateinit var handler: Handler

    private val start: Int = 11
    private val end: Int = 99
    private var num1: Int = 1
    private var num2: Int = 1
    private var resultMult: Int = 0
    private var resultCorrect: Int = 0
    private var result0:Int=0

    private var totalSeconds = 0    //timer
    private var running = false     //timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication)

        handler = Handler()     //timer
        initComponents()
        initListeners()

    }

    private fun initListeners() {
        btnBegin.setOnClickListener {
            tvCorrectSolution.setVisibility(View.INVISIBLE)
            etSolution.setText("")
            Toast.makeText(applicationContext,"¡Empezamos!",Toast.LENGTH_LONG).show()
            tvQualification.setTextColor(ContextCompat.getColor(this, R.color.background_app))
            tvOperation.setTextColor(ContextCompat.getColor(this, R.color.green_700))
            tvQualification.text="V"

            tvQualification.setTextColor(ContextCompat.getColor(this, R.color.background_app))

            initNumbers2and2()
            resultCorrect = num1 * num2
            tvCorrectSolution.text = resultCorrect.toString()

            running = false                                         //timer
            totalSeconds = 0                                        //timer
            updateTimerText(tvTimer)                                //timer
            running = true                                          //timer
            handler.postDelayed(timerRunnable, 1000)        //timer
        }

        btnMenu.setOnClickListener {
            tvOperation.setTextColor(ContextCompat.getColor(this, R.color.background_tv))
            tvQualification.setTextColor(ContextCompat.getColor(this, R.color.background_app))

            tvQualification.text="V"

            onBackPressed()
        }

        btnDone.setOnClickListener {

            running = false                             //timer
            handler.removeCallbacks(timerRunnable)      //timer

            tvCorrectSolution.setVisibility(View.VISIBLE)
            val result1:String = etSolution.getText().toString()

            if ( tvCorrectSolution.text==result1) {

                //Toast.makeText(applicationContext, "¡Hecho!", Toast.LENGTH_LONG).show()

                Toast.makeText(applicationContext,"¡Correcto!",Toast.LENGTH_LONG).show()


                tvQualification.setTextColor(ContextCompat.getColor(this, R.color.green_700))

                tvQualification.text="V"
            }
            else {
                //showAlert()
                Toast.makeText(applicationContext, "¡NO es Correcto!", Toast.LENGTH_LONG).show()
                tvQualification.text="X"
                tvQualification.setTextColor(ContextCompat.getColor(this, R.color.red_700))

            }

        }
    }

    override fun onBackPressed() {
        // Aquí puedes agregar tu lógica personalizada para el evento de retroceso

        // Por ejemplo, si quieres finalizar la actividad actual, puedes llamar a finish():
        finish()

        // Si estás trabajando con fragmentos y quieres realizar una acción específica al retroceder,
        // puedes utilizar el onBackPressedDispatcher:
        // onBackPressedDispatcher.onBackPressed()
    }

    private fun initNumbers2and2() {
        num1 = rand(start, end)
        num2 = rand(start, end)
        tvNumber1.text = num1.toString()
        tvNumber2.text = num2.toString()
    }

    private fun rand(start: Int, end: Int): Int {
        //require(start <= end) { "Illegal Argument" }
        //return ThreadLocalRandom.current().nextInt(start, end + 1)
        require(!(start > end || end - start + 1 > Int.MAX_VALUE)) { "Illegal Argument" }
        return Random(System.nanoTime()).nextInt(end - start + 1) + start
    }

    private fun initComponents() {
        tvNumber1 = findViewById(R.id.tvNumber1)
        tvNumber2 = findViewById(R.id.tvNumber2)
        tvTimer = findViewById(R.id.tvTimer)
        tvCorrectSolution = findViewById(R.id.tvCorrectSolution)
        etSolution = findViewById(R.id.etSolution)
        btnBegin = findViewById(R.id.btnBegin)
        btnDone = findViewById(R.id.btnDone)
        btnMenu = findViewById(R.id.btnMenu)
        tvQualification=findViewById(R.id.tvQualification)
        tvOperation=findViewById(R.id.tvOperation)
    }

    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  Timer   xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    private val timerRunnable = object : Runnable {
        override fun run() {
            //val timerTextView = findViewById<TextView>(R.id.timer_text)
            totalSeconds++
            updateTimerText(tvTimer)
            handler.postDelayed(this, 1000)
        }
    }

    private fun updateTimerText(tvTimer: TextView) {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        val formattedTime = String.format("%02d:%02d", minutes, seconds)
        tvTimer.text = formattedTime
    }
}