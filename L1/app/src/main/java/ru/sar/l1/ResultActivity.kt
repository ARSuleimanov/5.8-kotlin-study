package ru.sar.l1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
const val EXTRA_RESET="EXTRA_RESET"
class ResultActivity : AppCompatActivity(R.layout.activity_result) {

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "onCreate Result form")
        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        resultTextView.text = getString(R.string.title_result,counter)

        val ResetBtn=findViewById<Button>(R.id.resetBtn)
        ResetBtn.setOnClickListener {
            resultTextView.text=getString(R.string.title_result,0)
            setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_RESET, true))
        }
//        savedInstanceState?.getInt(EXTRA_COUNTER)?.let {
//            Toast.makeText(this, "Результат=$it", Toast.LENGTH_SHORT).show()
//        Log.d("test","получен$it")}

    }
}


