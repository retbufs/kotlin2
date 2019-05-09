package com.example.hello.template

/**
 * 模板类
 * 在类名后添加一个泛型
 *
 */
class River <T> (var name:String,var lenght:T){
    //模板类使用的需要调用当前放方法
    fun getInfo():String{
        var unit:String = when(lenght){
            is String -> "米"
            is Number -> "m"
            else ->""
        }
        return "${name}的长度是${lenght}$unit"
    }
}



