package com.example.array02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txtResults: TextView
    private lateinit var editNumber: EditText
    private lateinit var btnIncrease: Button
    private lateinit var btnMultiply: Button

    private var numberArray = arrayOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResults = findViewById<TextView>(R.id.txtResults)
        editNumber = findViewById<EditText>(R.id.editNumber)
        btnIncrease = findViewById<Button>(R.id.btnIncrease)
        btnMultiply = findViewById<Button>(R.id.btnMultipy)

        generateRandomNumbers()
        displayNumbers()

        btnIncrease.setOnClickListener {

            val number = editNumber.text.toString().toIntOrNull()
            if(number != null)
            {
                increaseNumber(number)
                displayNumbers()
            }
            else
            {
                txtResults.text = "Please enter a number"
            }
        }
        btnMultiply.setOnClickListener {
            val number = editNumber.text.toString().toIntOrNull()
            if(number != null)
            {
                multiplyNumber(number)
                displayNumbers()
            }
            else
            {
                txtResults.text = "Please enter a number"
            }
        }
    }

    private fun generateRandomNumbers() {
        numberArray = Array(10) { (0..10).random() }
    }

    private fun displayNumbers() {
        txtResults.text = numberArray.joinToString (",\n")
    }
1
    private fun increaseNumber(value: Int) {
        for (x in 0..9) {
            numberArray[x] += value // numberArray[x] = numberArray[x] + value
        }
    }
    private fun multiplyNumber(value:Int)
    {
        for(x in 0..9)
        {
            numberArray[x] = numberArray[x] * value
        }
    }
}