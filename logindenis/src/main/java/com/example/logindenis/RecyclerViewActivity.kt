package com.example.logindenis

import android.app.ActionBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.AbsListView
import android.widget.LinearLayout
import com.example.logindenis.adapter.RecyclerLinearAdapter
import com.example.logindenis.entity.Planet
import kotlinx.android.synthetic.main.activity_recycler_linear.*

class RecyclerViewActivity : AppCompatActivity() {
    val datas  = Planet.defaultList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_linear)
        val adapterListView = RecyclerLinearAdapter(this,datas)
        //默认不设置为左右滑动
        val lineatManager = androidx.recyclerview.widget.LinearLayoutManager(this, LinearLayout.VERTICAL, false)
       // lineatManager.orientation =LinearLayout.VISIBLE
       // lineatManager.orientation =LinearLayout.HORIZONTAL
        recycler_linear.layoutManager = lineatManager
        //设置点击事件
        adapterListView.setOnItemClickListener(adapterListView)
        adapterListView.setOnItemLongClickListener(adapterListView)
        recycler_linear.adapter = adapterListView
    }
}