package com.example.logindenis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import  kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var starArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        starArray = resources.getStringArray(R.array.starArray)
        toLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        spinner_dialog.setOnClickListener { startActivity<SpinnerActivity>() }
        //list
        btn_list_view.setOnClickListener { startActivity<ListViewActivity>() }
        btn_grid2_view.setOnClickListener { startActivity<Grid2Activity>() }
        btn_grid_view.setOnClickListener { startActivity<GridActivity>() }
        btn_recycler_view.setOnClickListener { startActivity<RecyclerViewActivity>() }
        btn_recyclergrid_view.setOnClickListener { startActivity<RecyclerGridActivity>() }
        btn_staggered_view.setOnClickListener { startActivity<StaggeredRecyclerViewActivity>() }
        btn_desidget.setOnClickListener { startActivity<DesidgetActivity>() }

    }

    //
    fun initSpinner() {
        var adapter = ArrayAdapter(this, R.layout.item_select, starArray)
        adapter.setDropDownViewResource(R.layout.item_dropdown)
//        val sp = statr_item as Spinner
        statr_item.prompt = "选择星星"
        statr_item.adapter = adapter
        statr_item.setSelection(0)
        statr_item.onItemSelectedListener = MyselectListener()
    }

    internal inner class MyselectListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(
            parent: AdapterView<*>?, view: View?,
            position: Int, id: Long
        ) {

            toast("当前选中：${starArray[position]}")
        }

    }
}
