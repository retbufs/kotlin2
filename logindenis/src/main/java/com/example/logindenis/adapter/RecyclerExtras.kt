package com.example.logindenis.adapter

import android.view.View

//可以为item设置额外的自定义事件
class RecyclerExtras {
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    interface OnItemDeleteClickListener {
        fun onItemDeleteClick(view: View, position: Int)
    }
}