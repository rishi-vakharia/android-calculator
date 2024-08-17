package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addBtn: Button = findViewById(R.id.btnAdd);
        var subBtn: Button = findViewById(R.id.btnSub);
        var mulBtn: Button = findViewById(R.id.btnMul);
        var divideBtn: Button = findViewById(R.id.btnDivide);

        addBtn.setOnClickListener {performOperation('+')}
        subBtn.setOnClickListener {performOperation('-')}
        mulBtn.setOnClickListener {performOperation('*')}
        divideBtn.setOnClickListener {performOperation('/')}
    }

    private fun performOperation(operator: Char) {

        val num1String: String = findViewById<EditText>(R.id.number1).text.toString();
        val num2String: String = findViewById<EditText>(R.id.number2).text.toString();

        if(num1String.isEmpty() || num2String.isEmpty()){
            findViewById<TextView>(R.id.answer).text = "Enter both numbers!";
            return;
        }
        val num1: Double = num1String.toDouble()
        val num2: Double = num2String.toDouble()
        val result: Double = when(operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> if(num2 == 0.0) Double.NaN else num1 / num2
            else -> Double.NaN
        }
        if(result.isNaN()){
            findViewById<TextView>(R.id.answer).text = "Can not divide by zero!";
            return;
        }
        findViewById<TextView>(R.id.answer).text = "Answer = " + String.format("%.2f", result);
    }
}