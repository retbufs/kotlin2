package com.example.desidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desidget.adapter.AboutFragmentAdapter
import com.example.desidget.bean.Goods
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutActivity : AppCompatActivity() {
    private val goodList = Goods.defGoods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        //  fragment_content
        vp_content.adapter = AboutFragmentAdapter(supportFragmentManager, goodList)
        //
        vp_content.currentItem = 0
        //

    }
}
