package ru.sar.l1

import android.app.Application
import android.content.Context
import android.widget.Toast
//import android.util.Log
import java.io.Serializable

//var cnt = 0

class MyApplication : Application() {
    //    var cnt=0
    class User(
        val id: Int = 0,
        val name: String = "Anonimouse",
        val birthYear: Int = 2000
    ) : Serializable {
        private fun getAge(): Int {
            return (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - birthYear)
        }
        fun toast(con: Context) {
            Toast.makeText(
                con,
                "User info\nID=$id\nName=$name\nAge=${getAge()}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
//        override fun onCreate() {
//            super.onCreate()
//            Log.d("MyApplication", "MyApplication onCreate the testing")
//        }

//        fun inc() {
//            cnt++
//        }
    }