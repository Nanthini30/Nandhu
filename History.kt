package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*




class History : AppCompatActivity() {


    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

     var firsts: TextView = findViewById(R.id.first)

   /* var seconded: TextView = findViewById(R.id.second)
        val temp1=intent.getStringExtra("input")
        val temp2=intent.getStringExtra("output")
        ("input :"+temp1).also { firsts.text = it }
        ("output :"+temp2).also { seconded.text = it }
*/

        val numbersList = intent.getSerializableExtra("key")
      // ArrayList<String> numberslist = (ArrayList<String>) getIntent().getSerializableExtra("key")
        firsts.text = java.lang.String.valueOf(numbersList)


        /*  var first: TextView = findViewById(R.id.first)
          val intent = intent
          val temp1=intent.getStringArrayExtra("array")
          val c = first.text[Arrays.toString().temp1];*/

    }
}


