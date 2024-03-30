package ru.sar.l1


import android.content.Intent
import android.os.Bundle


import android.util.Log
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity



const val LOG_TAG = "activity"
const val KEY_OBJ = "MyObject"

class MainActivity : AppCompatActivity() {
    //@Parcelize




    private val aleks: MyApplication.User = MyApplication.User(0, "Aleks", 1980)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "onCreate")
        initBtn()


    }

    private fun initBtn() {
        val btnUserInfo = findViewById<Button>(R.id.BtnUserInfo)
        btnUserInfo.setOnClickListener {
            aleks.toast(this)
            val tr = Intent(this, UserInfoActivity::class.java)
            tr.putExtra(KEY_OBJ, aleks)
            startActivity(tr)
        }
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
        Log.d(LOG_TAG, "onSaveInstanceState")
    }


    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }


}

