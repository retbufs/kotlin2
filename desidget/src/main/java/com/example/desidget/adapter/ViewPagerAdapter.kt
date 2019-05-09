package com.example.desidget.adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.desidget.data.InfoEntity

class ViewPagerAdapter(private val context :
                       Context,private val infos:MutableList<InfoEntity>) : androidx.viewpager.widget.PagerAdapter(){
    private val views = mutableListOf<ImageView>()
    //
    init {
        for(item in infos){
            val view = ImageView(context)
            view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            view.setImageResource(item.image)
            view.scaleType = ImageView.ScaleType.CENTER_CROP
            views.add(view)
        }
    }
    override fun isViewFromObject(p0: View, p1: Any): Boolean {

        return p0 ==p1
    }
    override fun getCount(): Int = views.size

    //实列每一个view
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]
    }
    //回收视图View
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }


    override fun getPageTitle(position: Int): CharSequence? {

        return infos[position].name;
    }
}