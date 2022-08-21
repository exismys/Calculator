package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var workingTextView: TextView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        workingTextView = findViewById(R.id.working_view)
        resultTextView = findViewById(R.id.result_view)
    }

    fun addToTextView(view: View) {
        workingTextView.text = "${workingTextView.text}${(view as Button).text}"
    }

    fun onClickClear(view: View) {
        workingTextView.text = ""
    }

    fun onClickBackspace(view: View) {
        workingTextView.text = workingTextView.text.slice(0..workingTextView.text.length-2)
    }

    fun onClickEqual(view: View) {
        val expression = ExpressionBuilder(workingTextView.text as String?).build()
        try {
            val result = expression.evaluate()
            resultTextView.text = result.toString()
        } catch (ex: Exception) {
            resultTextView.text = "Error"
        }

    }
}
