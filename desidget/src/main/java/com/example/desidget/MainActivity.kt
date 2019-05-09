package com.example.desidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPerfenceUtils.getInstance().put("user_name",10000L)
        setContentView(R.layout.activity_main)
        btn_toolbar.setOnClickListener { startActivity<ToolBarActivity>() }
        collapsing_title.setOnClickListener { startActivity<CollapsingActivity>() }
        btn_aliplay.setOnClickListener {
            startActivity<PlayToolbarActivity>()
        }
        btn_view_pager.setOnClickListener {
            startActivity<ViewPagerActivity>()
        }
        btn_about.setOnClickListener { startActivity<AboutActivity>() }
        btn_brodcast.setOnClickListener { startActivity<BroadcastActivity>() }
        val textView = TextView(this)
        textView.text  =DateUtils.nowDate
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        addContentView(textView,layoutParams)

    }
}
