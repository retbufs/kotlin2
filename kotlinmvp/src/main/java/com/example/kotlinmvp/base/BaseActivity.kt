package com.example.kotlinmvp.base

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

public abstract class BaseActivity : AppCompatActivity(), Lifecycle {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
    }
    /**
     * 初始内容
     */
    abstract fun initView()

    /**
     * fragment
     */
    abstract fun initFragment()

    /**
     * 事件
     */
    abstract fun initEvent()

    /**
     * 初始首页内容
     */
    abstract fun getContentView(): Int

}