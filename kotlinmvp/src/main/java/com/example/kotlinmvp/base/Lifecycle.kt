package com.example.kotlinmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

interface Lifecycle {
    fun onCreate(savedInstanceState: Bundle?)

    fun onRestart():Unit

    fun onPause():Unit

    fun onResume():Unit

    fun onDestroy():Unit

    fun onStart():Unit

    fun onStop():Unit
}
