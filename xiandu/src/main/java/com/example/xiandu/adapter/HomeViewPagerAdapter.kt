package com.example.xiandu.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.xiandu.R
import com.example.xiandu.data.Data
import com.example.xiandu.extars.PageClickListener


/**
 * 首页按照分类现实
 */
class HomeViewPagerAdapter(
    val context: Context,
    val mutableList: MutableList<Data.Type>
) : androidx.viewpager.widget.PagerAdapter(), androidx.viewpager.widget.ViewPager.OnPageChangeListener,PageClickListener {
    override fun onClick(view: View, position: Int) {

    }

    override fun getCount(): Int  = mutableList.size

   // 此方法是在状态改变的时候调用，其中arg0这个参数
    //有三种状态（0，1，2）。arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
    override fun onPageScrollStateChanged(p0: Int) {

    }

    // onPageScrolled(int arg0,float arg1,int arg2)    ，当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回一直得到
    //
    //调用。其中三个参数的含义分别为：
    //
    //arg0 :当前页面，及你点击滑动的页面
    //
    //arg1:当前页面偏移的百分比
    //
    //arg2:当前页面偏移的像素位置
    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPageSelected(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var pageClickListener: PageClickListener? = null
    fun setPagerClickListener(pageClickListener: PageClickListener) {
        this.pageClickListener = pageClickListener
    }
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }
    //这里处理视图
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = View.inflate(context, R.layout.item_layout, null)
        val text = view.findViewById<TextView>(R.id.id_text)
        text.text = mutableList[position].name
        //这里添加到view中
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }
}
