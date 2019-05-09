package com.example.logindenis.adapter

import android.content.Context
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.logindenis.R
import com.example.logindenis.entity.RecyclerInfo


class RecyclerGridAdapter(private val context: Context, val infos: MutableList<RecyclerInfo>) :
    RecyclerViewBaseAdapter<RecyclerGridAdapter.ViewHolder>() {
    override fun onBindViewHolder(viewHolder: RecyclerGridAdapter.ViewHolder, position: Int) {
        val recyInfo = infos[position]
        viewHolder.iv_icon.setImageResource(recyInfo.pic_id)
        viewHolder.tv_title.text = recyInfo.title
        //添加item事件
        viewHolder.item.setOnClickListener { v ->
            itemClickListener?.onItemClick(v, position)
        }
        viewHolder.item.setOnLongClickListener { v ->
            itemLongClickListener?.onItemLongClick(v, position)
            true
        }
    }

    private var layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerGridAdapter.ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_recy_grid_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return infos.size
    }


    //这里重写按钮点击的事件
    override fun onItemClick(view: View, position: Int) {
    }

    override fun onItemLongClick(view: View, position: Int) {

    }

    override fun onItemDeleteClick(view: View, position: Int) {

    }


    inner class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var iv_icon = itemView.findViewById<ImageView>(R.id.iv_image)
        var tv_title = itemView.findViewById<TextView>(R.id.tv_name)
        var item = itemView.findViewById<LinearLayout>(R.id.ll_item)
    }
}