package com.example.desidget

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desidget.adapter.RecyclerScollAdapter
import com.example.desidget.data.InfoEntity
import kotlinx.android.synthetic.main.activity_collapsing.*
import kotlinx.android.synthetic.main.activity_tool_bar.*

class CollapsingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)
        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
            false
        )
        recycler.adapter = RecyclerScollAdapter(this, InfoEntity.defYearData)
        coll_toolbar.title = "Title"
        coll_toolbar.setTitleTextColor(Color.RED)
        setSupportActionBar(coll_toolbar)
    }
}
