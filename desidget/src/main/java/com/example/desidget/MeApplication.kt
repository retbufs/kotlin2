package com.example.desidget

import android.app.Application
import android.content.Context

class MeApplication  :Application(){
    override fun onCreate() {
        super.onCreate()
        //初始化
        SharedPerfenceUtils.init(this.applicationContext,"sp_perf");
    }
}