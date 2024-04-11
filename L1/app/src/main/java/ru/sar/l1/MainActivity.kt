package ru.sar.l1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast


import androidx.fragment.app.Fragment
import ru.sar.L1.ActivityInterface

class MainActivity : AppCompatActivity(R.layout.activity_main), ActivityInterface {
    override fun onBackPressed() {
        Log.d(TAG,"Back pressed-----")

        super.onBackPressed()
    }

    /*the test function declared in the ActivityInterface*/
    override fun test (){
        Toast.makeText(this, "The main Activity fun test", Toast.LENGTH_LONG).show()
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

        findViewById<Button>(R.id.BtnHide).setOnClickListener {
        val fragment:Fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) ?:return@setOnClickListener
                                                            //В случае нулевого значения - выход из процедуры
            supportFragmentManager.beginTransaction().hide(fragment).commit()

        }
        findViewById<Button>(R.id.BtnShow).setOnClickListener {
            val fragment:Fragment =supportFragmentManager.findFragmentById(R.id.fragmentContainer) ?:return@setOnClickListener
            supportFragmentManager.beginTransaction().show(fragment).commit()
        }

    }
}