package ru.sar.l1

import android.os.Bundle

import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG = "activity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "onCreate")
    }


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG,"onSaveInstanceState")
    }


    override fun onPause() {
        super.onPause()
        Log.d (LOG_TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }




}

