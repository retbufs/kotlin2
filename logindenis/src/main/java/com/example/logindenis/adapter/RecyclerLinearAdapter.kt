package com.example.logindenis.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.logindenis.R
import org.jetbrains.anko.find
import com.example.logindenis.entity.Planet
import org.jetbrains.anko.toast


/**
 *
 */
class RecyclerLinearAdapter(private val context: Context, val infos: MutableList<Planet>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerLinearAdapter.ViewHolder>(),
    RecyclerExtras.OnItemLongClickListener,
    RecyclerExtras.OnItemDeleteClickListener,
    RecyclerExtras.OnItemClickListener {
    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var itemClickListener: RecyclerExtras.OnItemClickListener? = null
    fun setOnItemClickListener(listener: RecyclerExtras.OnItemClickListener) {
        this.itemClickListener = listener
    }

    private var itemLongClickListener: RecyclerExtras.OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener: RecyclerExtras.OnItemLongClickListener) {
        this.itemLongClickListener = listener
    }

    override fun onItemClick(view: View, position: Int) {
        context.toast("点击了${infos[position]}")
    }

    override fun onItemLongClick(view: View, position: Int) {
        context.toast("长按了${infos[position]}")
    }

    override fun onItemDeleteClick(view: View, position: Int) {
    }

    //返回创建的view
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list_image_view, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = infos.size

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        //绑定view
        val (iamge, name, desc) = infos[p1]
        holder.iv_icon.setImageResource(iamge)
        holder.tv_desc.text = desc
        holder.tv_name.text = name

        //自定义事件的监听,点击事件需要单独设置
        holder.rl_item.setOnClickListener { v ->
            itemClickListener?.onItemClick(v, p1)
        }
        holder.rl_item.setOnLongClickListener { v ->
            itemLongClickListener?.onItemLongClick(v, p1)
            true
        }
    }

    inner class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var rl_item: RelativeLayout = itemView.findViewById(R.id.rl_item)
        var iv_icon: ImageView = itemView.findViewById(R.id.iv_image)
        var tv_name: TextView = itemView.findViewById(R.id.tv_title)
        var tv_desc: TextView = itemView.findViewById(R.id.tv_desc)

    }
}





