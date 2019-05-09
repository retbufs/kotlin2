package com.example.desidget.data

import com.example.desidget.R

data class InfoEntity(var image: Int = 0, var name: String = "", var desc: String = "") {
    companion object {
        var yearArray = arrayOf(
            "鼠年", "牛年", "虎年", "兔年", "龙年",
            "蛇年", "马年", "羊年", "猴年", "鸡年",
            "狗年", "猪年")
        val defYearData: MutableList<InfoEntity>
            get() {
//            val InfosEntity()
                val yearList = mutableListOf<InfoEntity>()
                for (name in yearArray) {
                    yearList.add(InfoEntity(name = name))
                }
                return yearList
            }

        val pay_menu = arrayOf(
            "支付", "体育服务", "充值服务",
            "芝麻信用", "蚂蚁保险", "商家服务",
            "我的快递", "运动", "蚂蚁森林",
            "生活缴费", "外卖", "更多")
        val pay_icon = intArrayOf(R.drawable.icon_plus,R.drawable.ads_data)
        //
        val defMenuItem:MutableList<InfoEntity>
        get() {
            val menuInfo  = mutableListOf<InfoEntity>()
            for(index in pay_menu.indices){
                var icon:Int
                //取下标的余数
                if(index %2 == 0){
                  icon = pay_icon[0]
                }else{
                    icon = pay_icon[1]
                }
                menuInfo.add(InfoEntity(icon, pay_menu[index]))
            }
            return menuInfo
        }
        //手机品牌翻页数据
        val mobile = arrayOf("华为","小米","魅族","Vivo","苹果")
        val mobilePic = intArrayOf(
            R.drawable.huawei,R.drawable.xiaomi,
            R.drawable.meizu,R.drawable.vivo,R.drawable.iphone)
        val defMobile:MutableList<InfoEntity>
        get() {
            val mobileList = mutableListOf<InfoEntity>()
            for (index in mobile.indices){
                mobileList.add(InfoEntity(image = mobilePic[index],name = mobile[index]))
            }
            return mobileList
        }




    }
}
