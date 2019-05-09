package com.example.logindenis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import  kotlinx.android.synthetic.main.activity_desidget.*

class DesidgetActivity : AppCompatActivity() {
    private var  fabShowOrHide = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desidget)
        btn_log.setOnClickListener {
            Snackbar.make(cc_mian,"这是一个简单的提示体啊",
                Snackbar.LENGTH_INDEFINITE).show()
        }
        btn_fab.setOnClickListener {
            if(fabShowOrHide){
                fabShowOrHide = false
                fab.hide()
            }else{
                fabShowOrHide = true
                fab.show()
            }
        }
    }
}
