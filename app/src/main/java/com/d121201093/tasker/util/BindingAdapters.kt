package com.d121201093.tasker.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter


@SuppressLint("SetTextI18n")
@BindingAdapter("setPriority")
fun setPriority(view: TextView, priority: Int){
    when(priority){
        0 -> {
            view.text = "Penting mendesak"
            view.setTextColor(Color.parseColor("#DD0000"))
        }
        1 -> {
            view.text = "Tidak penting mendesak"
            view.setTextColor(Color.parseColor("#DD7700"))
        }
        2 -> {
            view.text = "Penting tidak mendesak"
            view.setTextColor(Color.parseColor("#0073DD"))
        }
        else -> {
            view.text = "Tidak penting tidak mendesak"
            view.setTextColor(Color.parseColor("#00DD16"))
        }
    }
}