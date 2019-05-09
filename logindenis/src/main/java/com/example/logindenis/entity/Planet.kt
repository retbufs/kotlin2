package com.example.logindenis.entity

import com.example.logindenis.R

/**
 * 行星实体数据类
 */
data class Planet(var image: Int, val name: String, var desc: String) {
    companion object {
        private val iconArray = intArrayOf(
            R.drawable.shuixing,
            R.drawable.muxing,
            R.drawable.diqiu,
            R.drawable.huoxing,
            R.drawable.tuxing
        )
        private val nameArray = arrayOf("水星", "木星", "地球", "火星", "土星")
        private val descArray = arrayOf(
            "水星是太阳系八大行星最内侧也是最小的一颗行星，也是离太阳最近的行星",
            "木星是太阳系八大行星中体积最大、自转最快的行星，排行第五。它的质量为太阳的千分之一",
            "按离太阳由近及远的次序排为第三颗，也是太阳系中直径、质量和密度最大的类地行星，距离太阳1.5亿公里。",
            "火星（Mars）是太阳系八大行星之一，是太阳系由内往外数的第四颗行星，属于类地行星，直径约为地球的53%，质量为地球的11%。",
            "是太阳系八大行星之一，距日距离（由近到远）第6位。质量、直径仅次于木星，并与木星同属气态巨行星"
        )
        val defaultList: MutableList<Planet>
            get() {
                val planetList = mutableListOf<Planet>()
                for (i in iconArray.indices) {
                    planetList.add(Planet(iconArray[i], nameArray[i], descArray[i]))
                }
                return planetList
            }
    }


}