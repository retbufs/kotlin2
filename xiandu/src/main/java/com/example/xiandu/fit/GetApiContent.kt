package com.example.xiandu.fit


import com.example.xiandu.data.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Path

import java.lang.reflect.Method

/**
 * 闲读接口
 */
interface GetApiContent {
    @GET("xiandu/categories/{en_name}")
    fun getCategories(@Path("en_name") en_name: String): Call<Data.ResultInfo>

}
