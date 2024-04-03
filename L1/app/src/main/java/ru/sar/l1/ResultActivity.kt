package ru.sar.l1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_RESET = "EXTRA_RESET"

class ResultActivity : AppCompatActivity(R.layout.activity_result) {

    lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultTextView = findViewById<TextView>(R.id.resultTextView)

        initGetObj()
        /**получить объекты serializable & parcelable**/
        initResult()
        /**get a result**/
        initBtn()
    }


    private fun initBtn() {
        findViewById<Button>(R.id.resetBtn).setOnClickListener {
            resultTextView.text = getString(R.string.title_result, 0)
            setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_RESET, true))
        }
        findViewById<Button>(R.id.btnShare).setOnClickListener { sendText() }
        findViewById<Button>(R.id.btnEmail).setOnClickListener { sendMail() }
        findViewById<Button>(R.id.btnCall).setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$+79111234567")
            }
            startActivity(callIntent)
        }
        findViewById<Button>(R.id.btnCamera).setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }

    private fun sendText() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "The simple text for sharing by my app.")
        startActivity(
            Intent.createChooser(
                shareIntent,
                "Please choice an application for send"
            )
        )
    }

    private fun sendMail() {
        val recipient = arrayOf("sar@au.ru")
        val subject = "Subject of the email"
        val body = "Body of the email"

        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, recipient)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        val chooserIntent = Intent.createChooser(emailIntent, "Please choice app for send e-mail")
        startActivity(chooserIntent)

    }

    private fun initResult() {
        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)
        resultTextView.text = getString(R.string.title_result, counter)
    }

    private fun initGetObj() {
        /** Прием Serializable объекта
         * getSerializableExtra - depricated, но используем,
         * т.к. новый метод требует min API 31 - а в этом проек тетребуется  минимум 17
         **/
        val testClass: TestClass? = intent.getSerializableExtra(KEY_SERIALIZABLE) as? TestClass

        testClass?.let {
            /** Обработка если ненулевой объект  **/

            Log.d(KEY_LOG, "${testClass?.text}:${testClass?.number}")
        }

        /** Прием Parcelable объекта
         * depricated используем по той же причине **/
        val testClassParcelable: TestClassParcelable? =
            intent.getParcelableExtra<TestClassParcelable>(KEY_PARCELIZABLE)

        testClassParcelable?.let {
            Log.d(KEY_LOG, "${testClassParcelable?.text}:${testClassParcelable?.number}")
        }

    }
}


