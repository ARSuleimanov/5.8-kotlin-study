package ru.sar.l1


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


const val CORRECT_PIN = "1567"
const val KEY_PIN = "PinCode"
const val KEY_COLOR = "Color"

// hw8 when the user will press OK button - the pin code will be saved
class MainActivity : AppCompatActivity() {

    private lateinit var pinView: TextView
    private var colorError: Int = Color.BLACK
    private var colorPrimary: Int = Color.BLACK
    private var savedPin = ""
    private var savedColor = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initColors()
        initPinView()

        initNumBtn()
        initDelBtn()
        initOkBtn()

        getInstanceForm(savedInstanceState)

    }

    private fun getInstanceForm(savedInstanceState: Bundle?) {
        savedInstanceState?.getString(KEY_PIN)?.let { t -> savedPin = t }
        savedInstanceState?.getInt(KEY_COLOR)?.let { sk -> savedColor = sk }

    }

    override fun onStart() {
        super.onStart()
        if (savedColor != 0) {
            pinView.setTextColor(savedColor)
        }
        if (savedPin != "") {
            pinView.text = savedPin
        }
    }

    private fun initColors() {
        colorError = ContextCompat.getColor(this, R.color.error)
        colorPrimary = ContextCompat.getColor(this, R.color.color_primary)
    }

    private fun initPinView() {
        pinView = findViewById(R.id.tv_pin)

    }

    private fun initOkBtn() {
        findViewById<Button>(R.id.btn_ok).setOnClickListener {
            if (pinView.text.toString() == CORRECT_PIN) {
                Toast.makeText(this, getString(R.string.congratulation_msg), Toast.LENGTH_SHORT)
                    .show()
                val tr = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(tr)

            } else {
                pinView.setTextColor(colorError)
                savedPin = pinView.text.toString()
                savedColor = colorError
            }


        }

//        findViewById<TextView>(R.id.tv_pin).addTextChangedListener {
//            pinView.setTextColor(colorPrimary)
//            Log.d("test", "addTextChangedListener")
//        }
    }

    private fun initDelBtn() {
        findViewById<Button>(R.id.btn_del).setOnClickListener {
            pinView.text = pinView.text.dropLast(1)
            pinView.setTextColor(colorPrimary)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_PIN, savedPin)
        outState.putInt(KEY_COLOR, savedColor)
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