package com.example.logindenis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.logindenis.R
import com.example.logindenis.entity.Planet
import org.jetbrains.anko.find

class PlaceAdapterListView(
    private val context: Context,
    private var planetList: MutableList<Planet>,
    private val background: Int
) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_image_view, null)
            holder = ViewHolder()
            holder.iv_icon = view.findViewById(R.id.iv_image)
            holder.tv_desc = view.findViewById(R.id.tv_desc)
            holder.tv_name = view.findViewById(R.id.tv_title)
            holder.rl_item = view.findViewById(R.id.rl_item)
            view.tag = holder
        } else {
            //不能为空
            holder = view!!.tag as ViewHolder
        }
        val planet = planetList[position]
        holder.iv_icon.setImageResource(planet.image)
        holder.tv_name.text = planet.name
        holder.tv_desc.text = planet.desc
        holder.rl_item.setOnClickListener {

        }
        //返回的view必须是不能为空的
        return view!!;
    }
    override fun getItem(position: Int): Any {
        return planetList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return planetList.size
    }

    internal inner class ViewHolder {
        lateinit var rl_item: RelativeLayout
        lateinit var iv_icon: ImageView
        lateinit var tv_name: TextView
        lateinit var tv_desc: TextView
    }

}