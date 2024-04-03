package ru.sar.l1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestClassParcelable(
    val text:String,
    val number:Int
):Parcelable
