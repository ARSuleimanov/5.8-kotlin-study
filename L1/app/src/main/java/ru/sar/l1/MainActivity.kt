package ru.sar.l1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox


import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onBackPressed() {
        Log.d(TAG,"Back pressed-----")
        super.onBackPressed()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var addToBackStack = false

        findViewById<Button>(R.id.resetCounter).setOnClickListener {
            val fragment:Fragment?=
                supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            Log.d(TAG,"Reset button " +if (addToBackStack) "BackStack" else "")
            if (fragment is MainFragment) {
                fragment.resetCounter()
            }
        }

        findViewById<CheckBox>(R.id.checkBox).setOnCheckedChangeListener { _, isChecked ->
            addToBackStack = isChecked
        }

        findViewById<Button>(R.id.add).setOnClickListener {
            val transaction = supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, MainFragment(), "MainFragment")
            Log.d(TAG,"Add button " +if (addToBackStack) "BackStack" else "")
            if (addToBackStack) transaction.addToBackStack(null)

            transaction.commit()
        }

        findViewById<Button>(R.id.replace).setOnClickListener {
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment2(), "MainFragment2")
            Log.d(TAG,"Replace button " +if (addToBackStack) "BackStack" else "")
            if (addToBackStack) transaction.addToBackStack(null)

            transaction.commit()
        }
    }
}