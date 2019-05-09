package com.example.logindenis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.logindenis.adapter.StaggeredGridAdapter
import com.example.logindenis.entity.RecyclerInfo
import kotlinx.android.synthetic.main.activity_staggered_recycler_view.*

class StaggeredRecyclerViewActivity : AppCompatActivity() {
    private var infos = RecyclerInfo.defaultStag
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered_recycler_view)

        val staggeredManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
            2,
            androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
        )
        //设置布局
        val adapter =StaggeredGridAdapter(this,infos)
        //需要先适配器
        staggered_recycler.layoutManager =staggeredManager
        staggered_recycler.adapter = adapter
        staggered_recycler.itemAnimator  = androidx.recyclerview.widget.DefaultItemAnimator()
        adapter.setOnItemClickListener(adapter)
        adapter.setOnItemLongClickListener(adapter)
        staggered_recycler.addItemDecoration(SpanItemDecoration(2))
    }
}
