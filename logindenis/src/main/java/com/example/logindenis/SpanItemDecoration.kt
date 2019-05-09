package com.example.logindenis

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class SpanItemDecoration(val span:Int): androidx.recyclerview.widget.RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = span
        outRect.top =span
        outRect.bottom = span
        outRect.right
    }
}