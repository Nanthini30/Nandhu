package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonZero: Button
    private lateinit var buttonAC: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonPercent: Button
    private lateinit var buttonHis: Button
    private var check = 0
    private lateinit var input: TextView
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonZero = findViewById(R.id.buttonZero)
        buttonAC = findViewById(R.id.buttonAC)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonDot = findViewById(R.id.buttonDot)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonHis = findViewById(R.id.buttonHis)
       input = findViewById(R.id.input)
        output = findViewById(R.id.output)

        buttonAC.setOnClickListener {
            input.text = " "
            output.text = " "

        }
         var tex: String

        buttonZero.setOnClickListener {
            tex = input.text.toString() + 0
            input.text = tex
            result(tex)
        }
        button1.setOnClickListener {
            tex = input.text.toString() + 1
            input.text = tex
            result(tex)
        }
        button2.setOnClickListener {
            tex = input.text.toString() + 2
            input.text = tex
            result(tex)
        }
        button3.setOnClickListener {
            tex = input.text.toString() + 3
            input.text = tex
            result(tex)
        }
        button4.setOnClickListener {
            tex = input.text.toString() + 4
            input.text = tex
            result(tex)
        }
        button5.setOnClickListener {
            tex = input.text.toString() + 5
            input.text = tex
            result(tex)
        }
        button6.setOnClickListener {
            tex = input.text.toString() + 6
            input.text = tex
            result(tex)
        }
        button7.setOnClickListener {
            tex = input.text.toString() + 7
            input.text = tex
            result(tex)
        }
        button8.setOnClickListener {
            tex = input.text.toString() + 8
            input.text = tex
            result(tex)
        }
        button9.setOnClickListener {
            tex = input.text.toString() + 9
            input.text = tex
            result(tex)
        }
        buttonDot.setOnClickListener {
            tex = input.text.toString() + "."
            input.text = tex
            result(tex)
        }
        buttonDivide.setOnClickListener {
            tex = input.text.toString() + "/"
            input.text = tex

        }
        buttonMultiply.setOnClickListener {
            tex = input.text.toString() + "*"
            input.text = tex

        }
        buttonAdd.setOnClickListener {
            tex = input.text.toString() + "+"
            input.text = tex

        }
        buttonSubtract.setOnClickListener {
           tex = input.text.toString() + "-"
           input.text = tex
        }

        buttonPercent.setOnClickListener {

            (input.text.toString().toDouble()/100).toString().also { tex = it }
            input.text = tex

        }

        buttonHis.setOnClickListener {

            val numbers: ArrayList<String> = ArrayList()
            val intent = Intent(this@MainActivity, History::class.java)
            intent.putExtra("key", numbers)
            startActivity(intent)
        }
            /*
                 val value = startActivity(
                Intent(this, History::class.java)
                    .putExtra("input", input.text.toString())
                    .putExtra("output", output.text.toString()))


        }



          //      getserilised
         //       pareseableit

           val n = ArrayList<String>()
            if(buttonAC.isPressed)
                n.add(input.text.toString());
            val num = Intent(this@MainActivity, History::class.java)
            num.putExtra("array", n)
            startActivity(`num`)

            val n = ArrayList<String>()
            val intent = Intent(this@MainActivity, History::class.java)
            intent.putExtra("Array", n)
            startActivity(intent)

        }*/

        buttonEqual.setOnClickListener {
            check += 1

        }
    }
    private fun result(tex: String) {

        fun getInputExpression(): String {
            val expression=input.text
            return expression.toString()
        }

        try {
            val expression=getInputExpression()
            val result= Expression(expression).calculate()
            if(result.isNaN()) {
                output.text="Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.purple_200))
            }

            else
            {
                output.text= DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.purple_200))

            }
        }
        catch (e:Exception)
        {
            output.text="Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.purple_200))
        }

    }

}



