package com.example.logindenis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import com.example.logindenis.adapter.GridAdapter
import com.example.logindenis.entity.Planet
import kotlinx.android.synthetic.main.activity_grid2.*

/**
 * 网格布局的使用
 *
 */
class GridActivity : AppCompatActivity() {
    private val planet  = Planet.defaultList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val adapter = GridAdapter(this,planet)
        gl_grid.adapter = adapter
        gl_grid.onItemClickListener = adapter
        gl_grid.numColumns = 2
        gl_grid.horizontalSpacing = 0
        gl_grid.verticalSpacing= 0
        gl_grid.stretchMode = GridView.STRETCH_COLUMN_WIDTH
    }
}
