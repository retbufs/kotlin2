package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_text_hello.text = "你好呀"
        btn_click.setOnClickListener {
            btn_click.text= "当前按钮点击过了"
        }
        //按钮的点击事件
        btn_toast_click.setOnClickListener {
            toast("小提示：当前点击了一下按钮")
        }
        btn_toast_click.setOnLongClickListener {
            toast("长按了当前按钮A");true
        }

        btn_long_click.setOnLongClickListener {
            toast("小提示:长按了当前按钮btn_long");true
        }
        btn_toast_click_long.setOnLongClickListener {
            toast("长按了当前按钮${this.tv_text_hello.text}");true
        }
        //跳转到下一的activity
        btn_redirect.setOnClickListener {
            val intent = Intent(this,Main2Activity::class.java)
            startActivity(intent)
        }






    }
    //数组的初始化
    fun initArray(){
        val isIntArray = intArrayOf(1,2,3,4,5,6,7,8,9,0)
       // val isLongArray = longArrayOf(1L,4L,5L,6L,7L)

    }
}
