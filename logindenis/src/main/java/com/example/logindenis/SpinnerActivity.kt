package com.example.logindenis

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_spinner.*
import kotlinx.android.synthetic.main.item_tv_spinner.*
import org.jetbrains.anko.selector
        import org.jetbrains.anko.toast

        class SpinnerActivity : AppCompatActivity() {
            private val satellites = listOf("水星", "金星", "木星", "火星", "土星", "地球", "冥王星", "海王星")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_spinner)
                //第一种原生spinner
//                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, satellites)
//                sp_dialog.adapter = adapter
//                sp_dialog.prompt ="点击选择"
                //
               // sp_dialog.onItemClickListener = MyItemClickListener()
//                sp_dialog.onItemSelectedListener = MyItemClickListener()

                //第二种spinner布局的实现
        sp_dialog.visibility = View.GONE
        tv_dialog_text.visibility = View.VISIBLE
        tv_dialog_text.text = satellites[0]
        tv_dialog_text.setOnClickListener {
            selector("请选择行星", satellites) { dialogInterface: DialogInterface, i: Int ->
                tv_dialog_text.text = satellites[i]
                toast("你选择的行星是${tv_dialog_text.text}")
            }
        }

    }


   internal inner class MyItemClickListener :AdapterView.OnItemSelectedListener{
       override fun onNothingSelected(parent: AdapterView<*>?) {
           TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       }

       override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          toast("选中的是：${satellites[position]}")
       }

   }
}
