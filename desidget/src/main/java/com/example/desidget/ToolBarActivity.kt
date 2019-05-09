package com.example.desidget

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.desidget.adapter.RecyclerScollAdapter
import kotlinx.android.synthetic.main.activity_tool_bar.*

class ToolBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar)
        toolbar.title = "这里是标题"
        //工具栏字体颜色
        toolbar.setTitleTextColor(Color.RED)
        //设置左边logo
        toolbar.setLogo(R.drawable.ic_launcher_foreground)
        //设置副标题
        toolbar.subtitle = "这是副标题"
        //设置副标题颜色
        toolbar.setSubtitleTextColor(Color.YELLOW)
        //设置背景颜色
        toolbar.setBackgroundResource(R.color.blue_light)
        //使用toolbar
        setSupportActionBar(toolbar)
        //工具栏设置最左侧作为返回
        toolbar.setNavigationIcon(R.drawable.back)
        //设置ClickListener监听事件

        toolbar.setNavigationOnClickListener {
            finish()  //直接退出
        }
//        var adapter = RecyclerScollAdapter(this,yearArray)
//        val layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
//        recycler.layoutManager = layoutManager
//        recycler.adapter = adapter

        nested_scroll


    }
}
