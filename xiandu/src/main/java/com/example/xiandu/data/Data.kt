package com.example.xiandu.data

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Data{
    data class Type(var name: String, var id: String) {
        companion object {
            val main_tab = listOf<String>(
                "科技资讯",
                "趣味软件/游戏",
                "Android",
                "iOS",
                "团队博客",
                "创业新闻",
                "装备党",
                "独立思想",
                "草根新闻"
            )
            val en_name = listOf<String>(
                "wow",
                "apps",
                "android",
                "iOS",
                "teamblog",
                "diediedie",
                "imrich",
                "thinking",
                "funny"
            )
            val initMuuTab :MutableList<Type>
            get() {
             val listType = mutableListOf<Type>()
                for (index in main_tab.indices){
                    listType.add(Type(main_tab[index], en_name[index]))
                }
                return listType
            }
        }
    }

    //下级分类数据
    data class ResultInfo(var error:Boolean,var result: List<Category>):Serializable{
        data class Category(var _Id:String,
                            var created_at:String,
                            var icon:String,
                            var id: String, var title:String ):Serializable

    }
}
