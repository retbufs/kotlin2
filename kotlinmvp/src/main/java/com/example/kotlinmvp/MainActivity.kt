package com.example.kotlinmvp

import android.os.Bundle
import android.view.KeyEvent
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.kotlinmvp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {
    private val ZREO: Int = 0
    override fun initView() {
    }

    override fun initFragment() {
    }

    override fun initEvent() {

    }

    override fun getContentView(): Int {
        return R.layout.activity_main;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initView()
        initFragment()
        initTab()
    }

    private fun initTab() {
        val mall =
            BottomNavigationItem(R.mipmap.ic_mall, "最新")
                .setInactiveIconResource(R.mipmap.ic_mall)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColor(R.color.colorAccent)


        val shop = BottomNavigationItem(R.mipmap.ic_shop, "闲读")
            .setInactiveIconResource(R.mipmap.ic_shop)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColor(R.color.colorAccent)

        val ticket = BottomNavigationItem(R.mipmap.ic_ticket, "福利")
            .setInactiveIconResource(R.mipmap.ic_ticket)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColor(R.color.colorAccent)

        val setting = BottomNavigationItem(R.mipmap.ic_setting, "设置")
            .setInactiveIconResource(R.mipmap.ic_setting)
            .setActiveColorResource(R.color.colorPrimary)
            .setInActiveColor(R.color.colorAccent)


        bottom_tab.addItem(mall)
            .addItem(shop)
            .addItem(ticket)
            .addItem(setting)
            .setMode(BottomNavigationBar.MODE_FIXED)
            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
            .setBarBackgroundColor(R.color.white)
            .setFirstSelectedPosition(ZREO)
            .initialise()
        /**
         * 菜单栏时间
         */
        bottom_tab.setTabSelectedListener(object :
            BottomNavigationBar.SimpleOnTabSelectedListener() {
        })
    }
    private var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                //判断连续点击返回的时间在1000毫秒。则认为是连续点击事件
                if (System.currentTimeMillis() - mExitTime > 1000) {
                    toast("再按一次退出")
                    mExitTime = System.currentTimeMillis()
                } else {
                    finish()
                }
                return true
            }
        }
        return super.onKeyDown(keyCode, event)

    }

}
