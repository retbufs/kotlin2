package com.example.xiandu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem
import com.example.xiandu.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
     return   true
    }
  //  private val bottomMenu = arrayOf("首页","每日干货","闲读","福利","个人中心")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomTab()
    }
    //底部导航栏
    private fun initBottomTab() {
       val fragment =  HomeFragment?.let {
           it.newInstance()
       }
        supportFragmentManager.beginTransaction().add(R.id.fragment_content,fragment).commit()
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

}
