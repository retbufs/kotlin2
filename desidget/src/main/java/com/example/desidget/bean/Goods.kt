package com.example.desidget.bean

import com.example.desidget.R

data class Goods(var name:String,var image:Int){
    companion object{
        val pic  = intArrayOf(R.drawable.huawei,R.drawable.xiaomi)
        val name = arrayOf("华为","小米")
        //这里返回修饰的需要为val否则会提示错误
        val defGoods:MutableList<Goods>
            get() {
                var goods = mutableListOf<Goods>()
                for(i in pic.indices){
                    goods.add(Goods(name[i], pic[i]))
                }
                return goods
        }
    }
}
