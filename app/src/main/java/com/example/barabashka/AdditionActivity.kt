package com.example.barabashka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView


class AdditionActivity : AppCompatActivity() {

    private lateinit var tvNumber1: TextView
    private lateinit var tvNumber2: TextView
    private lateinit var tvTimer: TextView
    private lateinit var tvCorrectSolution: TextView
    private lateinit var etSolution: EditText
    private lateinit var btnDone: Button
    private lateinit var btnMenu: Button
    private lateinit var btnBegin: Button
    private lateinit var tvQualification: TextView
    private lateinit var tvOperation: TextView
    private lateinit var tvAddOperation: TextView
    private lateinit var switchAddOper: Switch


    private lateinit var handler: Handler

    private val start: Int = 11
    private val end: Int = 99
    private var num1: Int = 1
    private var num2: Int = 1
    private var resultMult: Int = 0
    private var resultCorrect: Int = 0
    private var result0:Int=0

    private var numSequence:Int=5

    private var totalSeconds = 0    //timer
    private var running = false     //timer

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        handler = Handler()     //timer
        initComponents()
        initListeners()

    }

    private fun initListeners() {
        TODO("Not yet implemented")
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
        tvAddOperation=findViewById(R.id.tvAddOperation)
        switchAddOper=findViewById(R.id.switchAddOper)
    }
}