package ru.sar.l1

import android.os.Bundle
import android.util.Log


import android.widget.Button
import android.widget.TextView
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity

class UserInfoActivity : AppCompatActivity(R.layout.activity_userinfo) {
    lateinit var A: MyApplication.UserSer
    lateinit var B: MyApplication.UserParc
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userinfo)
        A=intent.getSerializableExtra(KEY_OBJ_SER) as MyApplication.UserSer
       //    B = MyApplication.UserSer(12, "Dima", 1995)
        B = intent.getParcelableExtra(KEY_OBJ_PARC) ?: MyApplication.UserParc()
        //
        Log.d(LOG_TAG, "B: $B")


        findViewById<Button>(R.id.Btn_userInfoActivity).setOnClickListener {
            //Toast.makeText(this, "Rigth - you pressed", Toast.LENGTH_LONG).show()
            B.toast(this)


        }
    }

    override fun onResume() {
        super.onResume()
        findViewById <TextView>(R.id.Name).text=A.name

        findViewById<TextView>(R.id.id).text=A.id.toString()
        findViewById<TextView>(R.id.BirthYear).text=A.birthYear.toString()
        findViewById<TextView>(R.id.Age).text=A.getAge().toString()

        Toast.makeText(this, "ATTENTION! Parcelable doesn't work!", Toast.LENGTH_SHORT).show()
    }
}