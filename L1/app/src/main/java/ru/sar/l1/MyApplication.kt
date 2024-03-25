package ru.sar.l1

import android.app.Application
import android.util.Log

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MyApplication", "MyApplication onCreate the testing")
    }
}