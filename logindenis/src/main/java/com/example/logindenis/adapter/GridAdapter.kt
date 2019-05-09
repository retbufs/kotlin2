package com.example.logindenis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import  org.jetbrains.anko.toast
import com.example.logindenis.R
import com.example.logindenis.entity.Planet

class GridAdapter(private val context: Context, private val planets: List<Planet>) : BaseAdapter() ,AdapterView.OnItemClickListener{
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
     Toast.makeText(context,"当前前点击的是：${planets[position]}",Toast.LENGTH_LONG).show()
    }
    override fun getCount(): Int {
        return planets.size
    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_grid_image_view, null)
            viewHolder = ViewHolder(view!!)
            view.tag = viewHolder

        } else {
            viewHolder = view!!.tag as ViewHolder
        }
        val (image, name, desc) = planets[position]
        viewHolder.iv_icon.setImageResource(image)
        viewHolder.tv_title.text = name
        viewHolder.tv_desc.text = desc
        // 处理数据
        return view
    }

    internal inner class ViewHolder(view: View) {
         val tv_title: TextView
         val tv_desc: TextView
        val iv_icon: ImageView

        init {
            tv_title = view.findViewById(R.id.tv_title)
            tv_desc = view.findViewById(R.id.tv_desc)
            iv_icon = view.findViewById(R.id.iv_image)
        }
    }


}
