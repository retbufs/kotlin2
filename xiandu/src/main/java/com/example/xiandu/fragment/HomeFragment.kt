package com.example.xiandu.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView

import com.example.xiandu.R
import com.example.xiandu.adapter.HomeViewPagerAdapter
import com.example.xiandu.adapter.ListViewAdapter

import com.example.xiandu.data.Data
import com.example.xiandu.extars.Constant

import org.jetbrains.anko.coroutines.experimental.asReference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : androidx.fragment.app.Fragment(), BaseView {
    private val  listType  = Data.Type.initMuuTab
    private var adapter:HomeViewPagerAdapter?= null
        private var retrofit = Retrofit.Builder()
        .baseUrl(Constant.server_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    override fun showLoading() {

    }
    override fun hideLoading() {
    }
    override fun loadData() {
        //加载数据
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                var view = inflater.inflate(R.layout.fragment_home, container, false)
        var vp_content = view.findViewById<androidx.viewpager.widget.ViewPager>(R.id.vp_content)
        adapter = HomeViewPagerAdapter(activity!!,listType)
        vp_content.adapter = adapter
        vp_content.currentItem = 1 //默认当前页为1

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


//    private var categType: CategType? = null
////    private var adapter: ListViewAdapter? = null
//    private var adapter : HomeViewPagerAdapter? = null
//    private var lists: MutableList<Categories> = mutableListOf()
//    //refit
//    private var retrofit = Retrofit.Builder()
//        .baseUrl(Constant.server_url)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    //提示加载数据库中
//    override fun showLoading() {
//
//    }
//
//    override fun hideLoading() {
//
//    }
//
//    //加载数据
//    override fun loadData() {
//        showLoading()
//        println("TAG:网络获取数据")
//        //开始加载数据
//        var categType: CategType?
//        val service = retrofit.create(GetCategories::class.java)
//        val call = service.categories.enqueue(object : Callback<CategType> {
//            override fun onResponse(call: Call<CategType>, response: Response<CategType>) {
//                if (response.code() == 200) {
//                    categType = response.body()
//                    lists.clear()
//                    categType?.results?.let { lists.addAll(it) }
//                    adapter!!.notifyDataSetChanged()
//                }
//            }
//            override fun onFailure(call: Call<CategType>, t: Throwable) {
//                println("TAG:ERROR:${t.message}")
//            }
//        })
//
//
//
//
//
//
//        hideLoading()
//    }
//    //首页头部策划分类
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//        loadData()
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        var view = inflater.inflate(R.layout.fragment_home, container, false)
//        var vp_content = view.findViewById<ViewPager>(R.id.vp_content)
//        //数据不为空
//       // adapter = ListViewAdapter(activity!!, lists)
//        adapter = HomeViewPagerAdapter(activity!!,lists)
//        vp_content.adapter = adapter
//        return view
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//    }
//
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
//
//    override fun onStart() {
//        super.onStart()
//    }
}
