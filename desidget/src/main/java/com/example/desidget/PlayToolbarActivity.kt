package com.example.desidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import com.example.desidget.adapter.RecyclerMenuAdapter
import com.example.desidget.adapter.RecyclerScollAdapter
import com.example.desidget.data.InfoEntity
import kotlinx.android.synthetic.main.activity_play_toolbar.*

import  kotlinx.android.synthetic.main.life_play.*
import kotlinx.android.synthetic.main.view_item.*
import kotlinx.android.synthetic.main.item_toolbar_right.*


class PlayToolbarActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    //监听偏移时间
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, ver: Int) {
        //偏移的角度
        var offset = Math.abs(ver)
        val total = appBarLayout!!.totalScrollRange  //不能为空
        //偏移
        if (offset <= total * 0.45) {
            item_ll_collapse.visibility = View.GONE
            item_ll_expand.visibility = View.VISIBLE
        } else {
            item_ll_collapse.visibility = View.VISIBLE
            item_ll_expand.visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_toolbar)
        //       var layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        pay_recycler.layoutManager = layoutManager
        //     val adapter = RecyclerScollAdapter(this,InfoEntity.defYearData)

        val gridLayoutManager = androidx.recyclerview.widget.GridLayoutManager(
            this, 4,
            androidx.recyclerview.widget.GridLayoutManager.VERTICAL, false
        )
        val adapter = RecyclerMenuAdapter(this, InfoEntity.defMenuItem)
        //设置布局
        pay_recycler.layoutManager = gridLayoutManager
        //适配器
        pay_recycler.adapter = adapter
        //设置偏移事件
        app_bar.addOnOffsetChangedListener(this)
        //设置菜单itemOnClick
        adapter.setOnItemDeleteListenr(adapter)
        adapter.setOnItemLongClickListener(adapter)
        adapter.setOnItemClickListenr(adapter)
        //

    }
}
