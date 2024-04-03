package ru.sar.l1

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

const val KEY_COUNTER = "count"
const val EXTRA_COUNTER = "EXTRA_COUNTER"
const val KEY_SERIALIZABLE="Key_serializable"
const val KEY_PARCELIZABLE="Key_parcelizable"
const val KEY_LOG="SAR"
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var currentCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init_result_act()
        val resultActivityResult: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val isRes=it.data?.getBooleanExtra(EXTRA_RESET,false)?:false
                    if (isRes){
                        currentCounter=0
                        findViewById<TextView>(R.id.counterTextView).text=currentCounter.toString()

                    }
                    Toast.makeText(this, "result is achieved", Toast.LENGTH_SHORT).show()
                }
            }
        Log.d("Test", "mainActivity onCreate")


        initBtn(savedInstanceState)

        val resultButton = findViewById<Button>(R.id.resultBtn)
        resultButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(EXTRA_COUNTER, currentCounter)


            intent.putExtra(KEY_SERIALIZABLE, TestClass("hello",123))
            intent.putExtra(KEY_PARCELIZABLE,TestClassParcelable("hello-parcelable",555))
            resultActivityResult.launch(intent)
            //startActivity(intent)
        }
    }


    private fun initBtn(savedInstanceState: Bundle?) {
        val plusButton: Button = findViewById(R.id.plusBtn)


        savedInstanceState?.getInt(KEY_COUNTER)?.let { counter ->
            currentCounter = counter
        }

        val counterTextView: TextView = findViewById(R.id.counterTextView)
        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
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
        outState.putInt(KEY_COUNTER, currentCounter)

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

