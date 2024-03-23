package ru.sar.l1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val CORRECT_PIN = "1567"

class MainActivity : AppCompatActivity() {

    private lateinit var pinView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pinView = findViewById(R.id.tv_pin)

        initNumBtn()
        initDelBtn()
        initOkBtn()


    }

    private fun initOkBtn() {
        findViewById<Button>(R.id.btn_ok).setOnClickListener {
            if (pinView.text == CORRECT_PIN) {
                Toast.makeText(this, getString(R.string.congratulation_msg), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initDelBtn() {
        findViewById<Button>(R.id.btn_del).setOnClickListener {
            pinView.text = pinView.text.dropLast(1)
        }
    }

    private fun initNumBtn() {
        findViewById<Button>(R.id.btn_0).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_1).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_2).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_3).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_4).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_5).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_6).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_7).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_8).setOnClickListener { btnPressed(it) }
        findViewById<Button>(R.id.btn_9).setOnClickListener { btnPressed(it) }
    }


    private fun btnPressed(btn: View) {
        if (btn !is Button) return
        pinView.text = buildString {
            append(pinView.text.toString())
            append(btn.text)
        }
    }
}