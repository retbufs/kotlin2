package com.example.desidget

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desidget.data.ColorEntoty
import kotlinx.android.synthetic.main.activity_broadcast.*
import org.jetbrains.anko.act
import org.jetbrains.anko.ctx
import org.jetbrains.anko.selector
import kotlin.math.log10

class BroadcastActivity : AppCompatActivity() {
    private  var  ACTION_COLOR:String = "com.exmple.action_color"
    //申明一个私有变量不立刻赋值时需要为起指定 变量的类型
    private var receiver:ColorReceiver? = null
    private var mColor:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        //注册广播
        initSpinner()
        //为其设置空间对象
    }

    private var mSeq = 0
    private  val colors = ColorEntoty.defColor
    private val ayColorName = listOf("红色","绿色","黑色","暗红色","白色")

    private val ayColor = intArrayOf(
        R.color.red,
        R.color.green,
        R.color.black,
        R.color.colorAccent,
        R.color.white)

    //这里发送广播
    private fun initSpinner() {
        sp_color.setOnClickListener{
            selector("请选择颜色",ayColorName){ dialogInterface: DialogInterface, i: Int ->
                sp_color.text = ayColorName[i]
                //发送广播
                val intent = Intent(ACTION_COLOR)
                mSeq = i
                intent.putExtra("color",ayColor[i])
                intent.putExtra("seq",mSeq)
                //发送广播
                sendBroadcast(intent)

            }
        }
    }
    //广播接收
   inner class ColorReceiver :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!=null){
                if(ACTION_COLOR.equals(intent.action)){
                    //当接受的color不为空时将其设置到布局当中
                        intent.getIntExtra("color",0)?.let { item_ll_layout.setBackgroundColor(it) }

                }
            }
        }
    }
    override fun onStop() {
        unregisterReceiver(receiver)
       super.onStop()

    }

    override fun onStart() {
        receiver = ColorReceiver()
        //指定拦截广播
        val inFilter = IntentFilter(ACTION_COLOR)
        registerReceiver(receiver, inFilter)

        super.onStart()

    }
}
