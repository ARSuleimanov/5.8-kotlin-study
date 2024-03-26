package ru.sar.l1

import android.app.Application
import android.util.Log
var cnt=0
class MyApplication: Application() {
//    var cnt=0
    override fun onCreate() {
        super.onCreate()
        Log.d("MyApplication", "MyApplication onCreate the testing")
    }
    fun inc() {
        cnt++
    }
}