package com.example.desidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerTabStrip
import androidx.viewpager.widget.PagerTitleStrip
import androidx.viewpager.widget.ViewPager
import com.example.desidget.adapter.ViewPagerAdapter
import com.example.desidget.data.InfoEntity
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity(), androidx.viewpager.widget.ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //页面切换结束时触发
    override fun onPageSelected(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val infos = InfoEntity.defMobile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        //设置适配器视图
        viewpager.adapter = ViewPagerAdapter(this,infos)
        viewpager.currentItem = 0
//        PagerTabStrip

    }

}
