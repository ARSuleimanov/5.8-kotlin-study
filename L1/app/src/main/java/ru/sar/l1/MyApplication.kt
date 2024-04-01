package ru.sar.l1

import android.app.Application
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import kotlinx.parcelize.Parcelize
//import android.util.Log
import java.io.Serializable

//var cnt = 0

class MyApplication : Application() {

    //TIP Parcelable class
    @Parcelize
    class UserParc(
        val id: Int = 0,
        val name: String = "Anonimouse",
        val birthYear: Int = 2000
    ) : Parcelable {



        fun getAge(): Int {
            return (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - birthYear)
        }

        fun toast(con: Context) {
            Toast.makeText(
                con,
                "UserParc info\nID=$id\nName=$name\nAge=${getAge()}",
                Toast.LENGTH_SHORT
            ).show()

        }


    }

    //TIP Serializable class
    class UserSer(
        val id: Int = 0,
        val name: String = "Anonimouse",
        val birthYear: Int = 2000
    ) : Serializable {
        fun getAge(): Int {
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
}


