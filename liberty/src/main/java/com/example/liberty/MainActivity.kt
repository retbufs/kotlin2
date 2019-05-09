package com.example.liberty

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.liberty.view.RoundProgressBar
import kotlinx.android.synthetic.main.activity_main.*


/**
 * at_most 至多
 *
 * 首先自定义属性
 *
 *1:测量模式
 *EXACTLY  用户为空间声明了宽高
 *AT_MOST 自己测量：不能超过父类的传入的长度
 *UNSPECIFIED
 *通过：MeasureSpec
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<RoundProgressBar>(R.id.mProgress)

        view.setOnClickListener {
            ObjectAnimator.ofInt(view, "progress", 0, 100).setDuration(1000).start()
        }
    }

}
