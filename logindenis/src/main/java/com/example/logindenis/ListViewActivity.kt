package com.example.logindenis

import android.content.DialogInterface

import android.graphics.Color
import android.graphics.drawable.Drawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.logindenis.adapter.PlaceAdapterListView
import com.example.logindenis.entity.Planet
import kotlinx.android.synthetic.main.activity_list_view.*
import org.jetbrains.anko.selector

class ListViewActivity : AppCompatActivity() {
    private val dividers = listOf(
        "不显示分隔线(分隔线高度为0)",
        "不显示分隔线(分隔线为null)",
        "只显示内部分隔线(先设置分隔线高度)",
        "只显示内部分隔线(后设置分隔线高度)",
        "显示底部分隔线(高度是wrap_content)",
        "显示底部分隔线(高度是match_parent)",
        "显示顶部分隔线(别瞎折腾了，显示不了)",
        "显示全部分隔线(看我用padding大法)"
    )
    private val dividerHeight = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        //适配器
        val adapter = PlaceAdapterListView(this, Planet.defaultList, Color.WHITE)
        list_view.adapter = adapter

        val drawable: Drawable = resources.getDrawable(R.drawable.divider_red2)
        tv_spinner.text = dividers[0]  //默认选中第一项
        tv_spinner.setOnClickListener {
            //   selector("请选择行星", )
            selector("选择分割线", dividers) { dialogInterface: DialogInterface, i: Int ->
                tv_spinner.text = dividers[i]
                var params = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
                list_view.divider = drawable
                list_view.dividerHeight = dividerHeight
                list_view.setPadding(0, 0, 0, 0)
                list_view.setBackgroundColor(Color.TRANSPARENT)

                when (i) {
                    0 -> list_view.dividerHeight = 0
                    1 -> {
                        list_view.divider = null
                        list_view.dividerHeight = dividerHeight
                    }
                    2 -> {
                        list_view.divider = drawable
                        list_view.dividerHeight = dividerHeight
                    }
                    3 -> {
                        list_view.dividerHeight = dividerHeight
                        list_view.divider = drawable
                    }
                    4 -> {
                        list_view.setFooterDividersEnabled(false)
                    }
                    5 -> {
                        params = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT
                        )
                        list_view.setFooterDividersEnabled(true)
                    }
                }
                list_view.layoutParams = params
            }
        }

    }
}
