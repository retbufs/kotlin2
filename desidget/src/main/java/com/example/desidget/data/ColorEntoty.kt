package com.example.desidget.data

import com.example.desidget.R

data class ColorEntoty ( var name:String,var color:Int){
    companion object{
        val ayColorName = arrayOf("红色","绿色","黑色","暗红色","白色")
        val ayColor = intArrayOf(
            R.color.red,
            R.color.green,
            R.color.black,
            R.color.colorAccent,
            R.color.white)
        val defColor:MutableList<ColorEntoty>
            get(){
                val colors = mutableListOf<ColorEntoty>()
                for(i in ayColor.indices){
                    colors.add(ColorEntoty(ayColorName[i],ayColor[i]))
                }
                return colors
            }
    }



}