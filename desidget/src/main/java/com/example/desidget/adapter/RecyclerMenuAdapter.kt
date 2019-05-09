package com.example.desidget.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.desidget.R
import com.example.desidget.data.InfoEntity
import com.zhenio.baselibrary.recycler.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.activity_play_toolbar.view.*
import org.jetbrains.anko.toast

class RecyclerMenuAdapter
    (private val context: Context, val infos: MutableList<InfoEntity>) :
    BaseRecyclerAdapter<InfoEntity, RecyclerMenuAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_menu_recyler_layout, viewGroup, false);
        return ViewHolder(view)
    }
    override fun onBindViewHolder(vh: ViewHolder, i: Int) {
        val infoEntity = infos[i]
        //
        vh.name.text = infoEntity.name
        vh.icon.setImageResource(infoEntity.image)
        //
        vh.relativelayout.setOnClickListener { v ->
            onItemClickListenr!!.onClick(v,i)
        }
        vh.relativelayout.setOnLongClickListener { v ->
            onItemLongClickListener!!.onLongClick(v, i)
            true
        }
    }

    override fun getItemCount(): Int {
        return infos.size   //
    }

    override fun onClick(view: View?, position: Int) {
        context.toast("${view!!.id}点击事件${position},菜单详情${infos[position]}")
    }

    override fun onDelete(v: View?, position: Int) {


    }

    override fun onLongClick(view: View?, position: Int) {
        context.toast("${view!!.id_pay_life}长按事件${position},菜单详情${infos[position]}")
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.menu_name)
        val icon = itemView.findViewById<ImageView>(R.id.menu_icon)
        val relativelayout = itemView.findViewById<RelativeLayout>(R.id.rl_menu_item)

    }
}