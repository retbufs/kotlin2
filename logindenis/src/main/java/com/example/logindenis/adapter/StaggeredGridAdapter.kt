package com.example.logindenis.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.logindenis.R
import com.example.logindenis.entity.RecyclerInfo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_staggreda_layout.*
import org.jetbrains.anko.toast

class StaggeredGridAdapter(private val context: Context, val infos: MutableList<RecyclerInfo>) :
    RecyclerViewBaseAdapter<StaggeredGridAdapter.itemHolder>() {
    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        val view = layoutInflater.inflate(R.layout.item_staggreda_layout, parent, false)
        return itemHolder(view)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    //    override fun onBindViewHolder(
//        viewHolder: ViewHolder,
//        position: Int
//    ) {
//
//        viewHolder.iv_pic.resources
//    }
    override fun onBindViewHolder(holder: StaggeredGridAdapter.itemHolder, position: Int) {
        holder.bind(infos[position])
        //通过itemViewHolder 可以获取到layout中设置的id
        holder.ll_item.setOnClickListener { v ->
            itemClickListener?.onItemClick(v, position)
        }
        holder.ll_item.setOnLongClickListener { v ->
            itemLongClickListener?.onItemLongClick(v, position)
            true
        }
    }

    //自定义ViewHolder
    inner class ViewHolder(item: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(item) {
        val iv_pic = item.findViewById<ImageView>(R.id.iv_pic)
        val tv_title = item.findViewById<TextView>(R.id.tv_title)
        val ll_item = item.findViewById<LinearLayout>(R.id.ll_item)
    }

    //通过LayoutContainer插件实现
    class itemHolder(override val containerView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: RecyclerInfo) {
            //因为运用了插件LayoutContainer，所以这里可以直接使用控件对象
            iv_pic.setImageResource(item.pic_id)
            tv_title.text = item.title
        }

    }

    override fun onItemClick(view: View, position: Int) {
        context.toast("点击了${position+1}项：${infos[position]}")
    }
    override fun onItemLongClick(view: View, position: Int) {
        context.toast("长按了${position+1}项：${infos[position]}")
    }

    override fun onItemDeleteClick(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}