package com.example.logindenis.entity

import com.example.logindenis.R

data class RecyclerInfo(val pic_id: Int = 0, val title: String = "", val desc: String = "") {
    var id: Int = 0

    init {
        id = RecyclerInfo.seq
        RecyclerInfo.seq++

    }

    companion object {
        private var seq = 0

        //gridManager需要的数据
        private val listPic = intArrayOf(
            R.drawable.pic_01,
            R.drawable.pic_02,
            R.drawable.pic_03,
            R.drawable.pic_04,
            R.drawable.pic_06,
            R.drawable.pic_08,
            R.drawable.pic_09,
            R.drawable.pic_10,
            R.drawable.pic_11,
            R.drawable.pic_13,
            R.drawable.pic_14
        )


        private val listTitle = arrayOf(
            "时钟",
            "爱心",
            "橄榄球",
            "雪糕",
            "铅笔",
            "帽子",
            "瓶子",
            "礼物",
            "青苹果",
            "棒棒糖",
            "钻石"
        )
        //不可变得
        val defaultGrid: MutableList<RecyclerInfo>
            get() {
                var mutableList = mutableListOf<RecyclerInfo>()
                for (i in listPic.indices) {
                    mutableList.add(RecyclerInfo(pic_id = listPic[i], title = listTitle[0]))
                }
                return mutableList
            }
        private val stagImageArray = intArrayOf(
            R.drawable.skirt01,
            R.drawable.skirt02,
            R.drawable.skirt03,
            R.drawable.skirt04,
            R.drawable.skirt05,
            R.drawable.skirt06,
            R.drawable.skirt07,
            R.drawable.skirt08,
            R.drawable.skirt09,
            R.drawable.skirt10,
            R.drawable.skirt11,
            R.drawable.skirt12,
            R.drawable.skirt13,
            R.drawable.skirt14,
            R.drawable.skirt15,
            R.drawable.skirt16,
            R.drawable.skirt17,
            R.drawable.skirt18,
            R.drawable.skirt19,
            R.drawable.skirt20,
            R.drawable.skirt21,
            R.drawable.skirt22,
            R.drawable.skirt23
        )
        private val stagTitleArray = arrayOf(
            "促销价", "惊爆价", "跳楼价", "白菜价", "清仓价", "割肉价",
            "实惠价", "一口价", "满意价", "打折价", "腰斩价", "无人问津",
            "算了吧", "大声点", "嘘嘘", "嗯嗯", "呼呼", "呵呵",
            "哈哈", "嘿嘿", "嘻嘻", "嗷嗷", "喔喔"
        )
        val defaultStag: MutableList<RecyclerInfo>
            get() {
                val stagArray = mutableListOf<RecyclerInfo>()
                for (i in stagImageArray.indices) {
                    stagArray.add(RecyclerInfo(stagImageArray[i], stagTitleArray[i]))
                }
                return stagArray
            }
    }


}