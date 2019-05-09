package com.example.logindenis.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

object DateUtils {
    //获取当期前时间
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }
    //获取当前年份
    val nowDate:String
    get() {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(Date())
    }
    //获取当前时间
    val nowTime:String
    get() {
        val sdf  = SimpleDateFormat("HH:mm:ss")
        return sdf.format(Date())
    }
    val nowTimeDetail: String
    get() {
        val sdf = SimpleDateFormat("HH:mm:ss.SSS")
        return sdf.format(Date())
    }
    //默认时间格式:
    fun getFormatTiem(format: String = "yyyyMMddHHmmss"):String{
        val ft:String = format
        val  sdf = SimpleDateFormat(format)

        return sdf.format(Date())
    }

}

