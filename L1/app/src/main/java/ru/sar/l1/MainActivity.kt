package ru.sar.l1

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_COUNTER = "count"
const val EXTRA_COUNTER="EXTRA_COUNTER"
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var currentCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Test", "mainActivity onCreate")
        val plusButton: Button = findViewById(R.id.plusBtn)

//        if (savedInstanceState != null) currentCounter=savedInstanceState.getInt(KEY_COUNTER)
        savedInstanceState?.getInt(KEY_COUNTER)?.let { counter ->
            currentCounter = counter}

        val counterTextView: TextView = findViewById(R.id.counterTextView)
        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
        }

        val resultButton = findViewById<Button>(R.id.resultBtn)

        resultButton.setOnClickListener {
            val intent= Intent(this,ResultActivity::class.java)
            intent.putExtra(EXTRA_COUNTER,currentCounter)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Test", "Destroy main activity")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Test", "save instance")
        super.onSaveInstanceState(outState)
        //outState.putInt(KEY_COUNTER, currentCounter )
        outState.putInt(KEY_COUNTER,currentCounter)

    }

//    override fun onRestoreInstanceState(
//        savedInstanceState: Bundle
//    ) {
//        Log.d("Test", "Load instance")
//        super.onRestoreInstanceState(savedInstanceState)
//
//        currentCounter = savedInstanceState.getInt(KEY_COUNTER)
//        val counterTextView: TextView = findViewById(R.id.counterTextView)
//        counterTextView.text = currentCounter.toString()
//
//
//
//    }
}

