package com.example.desidget.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.desidget.R
import com.example.desidget.data.InfoEntity
import java.text.ParsePosition

class RecyclerScollAdapter(private val context: Context, private var infos: MutableList<InfoEntity>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerScollAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        var view = layoutInflater.inflate(R.layout.item_recycler_year_layut, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        var name = infos[position].name
        vh.tv_title.text = name
    }

    inner class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var tv_seq = itemView.findViewById<TextView>(R.id.tv_seq)
        var tv_title = itemView.findViewById<TextView>(R.id.tv_title)
    }
}