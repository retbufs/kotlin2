package com.example.logindenis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.widget.GridLayout
import com.example.logindenis.adapter.RecyclerGridAdapter
import com.example.logindenis.entity.RecyclerInfo
import kotlinx.android.synthetic.main.activity_recycler_grid.*

class RecyclerGridActivity : AppCompatActivity() {
    private var infos = RecyclerInfo.defaultGrid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_grid)
        //设置网格布局
        val gridLayoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2, GridLayout.VERTICAL, false)
        grid_recycler.layoutManager = gridLayoutManager
        val adapter = RecyclerGridAdapter(this,infos)
        adapter.setOnItemClickListener(adapter)
        adapter.setOnItemLongClickListener(adapter)
        grid_recycler.adapter = adapter
        grid_recycler.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
       // StaggeredGridLayoutManager 实现瀑布流布局
    }
}
