package com.example.logindenis.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

abstract class  RecyclerViewBaseAdapter<VH : androidx.recyclerview.widget.RecyclerView.ViewHolder>  :
    androidx.recyclerview.widget.RecyclerView.Adapter<VH>(),
    RecyclerExtras.OnItemClickListener,
    RecyclerExtras.OnItemDeleteClickListener,
    RecyclerExtras.OnItemLongClickListener{
    override abstract fun onCreateViewHolder(parent: ViewGroup, position: Int):VH
    //需要重写 获取item个数
    override  abstract fun getItemCount(): Int
    //绑定子类item的个数需要喜爱能写
    override abstract fun onBindViewHolder(viewHolder: VH, position: Int)
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getItemViewType(position: Int): Int = 0
    //添加自定义事件的监听
    var itemClickListener:RecyclerExtras.OnItemClickListener ? = null
    fun  setOnItemClickListener (listener:RecyclerExtras.OnItemClickListener){
        itemClickListener = listener
    }
    var itemDeleteListener:RecyclerExtras.OnItemDeleteClickListener? = null
    fun setOnItemDeleteListener (listener :RecyclerExtras.OnItemDeleteClickListener){
        this.itemDeleteListener = itemDeleteListener }
    var itemLongClickListener:RecyclerExtras.OnItemLongClickListener? = null
    fun setOnItemLongClickListener (listener :RecyclerExtras.OnItemLongClickListener){
        this.itemLongClickListener = listener
    }
}