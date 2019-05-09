package com.example.desidget.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.desidget.bean.Goods
import com.example.desidget.data.InfoEntity
import com.example.desidget.fragment.AboutFragment

class AboutFragmentAdapter(val fm: androidx.fragment.app.FragmentManager, val goodLIst:MutableList<Goods>) :
    androidx.fragment.app.FragmentPagerAdapter(fm){
    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        var item = goodLIst[p0]
        //通过伴生对象进行初始化
        return AboutFragment.newInstance(item.name,item.image)
    }

    override fun getCount(): Int {
       return goodLIst.size
    }

    //设置ViewPager需要重写getPageTitle
    override fun getPageTitle(position: Int): CharSequence? {
        return goodLIst[position].name
    }
}
