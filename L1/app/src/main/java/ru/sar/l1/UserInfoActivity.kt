package ru.sar.l1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserInfoActivity:AppCompatActivity(R.layout.activity_userinfo) {
    lateinit var A:MyApplication.User
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        A=intent.getSerializableExtra(KEY_OBJ) as MyApplication.User

    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.Name).text=A.name
        findViewById<TextView>(R.id.id).text=A.id.toString()
    }
}