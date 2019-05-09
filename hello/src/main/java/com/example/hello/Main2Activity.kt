package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hello.template.River
import kotlinx.android.synthetic.main.activity_main.*
import  kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.btn_click
import org.jetbrains.anko.toast
import java.math.BigDecimal

class Main2Activity : AppCompatActivity(), View.OnLongClickListener, View.OnClickListener {
    var count = 0
    //长按事件
    override fun onLongClick(v: View?): Boolean {
        when (v!!.id) {
            R.id.btn_click -> toast("按钮长按了")
        }
        return true
    }

    //点击事件
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_click -> toast("你点击了当前按钮")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn_click.setOnClickListener(this)
        btn_click.setOnLongClickListener(this)
        //多选按钮
        check_play.setOnClickListener {
            toast("爱好：打球")
        }
        check_run.setOnClickListener {
            toast("你选择跑步")
        }
        //单选按钮
        btn_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_man -> toast("你是一个帅气的男孩")
                R.id.radio_woman -> toast("哇哦，你是一个活泼可爱的小姐姐")
                else -> ""
            }
        }

        val lotus = Plant("荷花", "根", "荷叶")
        // val plant2 = Plant("莲花","莲藕","莲藕")
        var lotus2 = lotus.copy()
        check_plant.setOnClickListener {
            
            lotus2 = when (count++ % 2) {
                0 -> lotus.copy(name = "植物")
                else -> lotus.copy(name = "舌草花")
            }
            text_list.text = lotus2.toString()
        }

        //模板类的使用
        template_btn.setOnClickListener {
//         var river = River<Int> ("绳子",100)
            when(count++%4){
                0->  text_list.text = River<Int> ("绳子",100).getInfo()
                1 ->  text_list.text = River ("梯子",8).getInfo()
                3 -> text_list.text =  River<String> ("地球","40076千").getInfo()
                4 -> text_list.text = River<Double>("小河",10.0).getInfo()
            }
        }



    }
}
