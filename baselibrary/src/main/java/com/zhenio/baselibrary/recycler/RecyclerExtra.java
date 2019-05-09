package com.zhenio.baselibrary.recycler;

import android.view.View;

/**
 * 对recyclerView添加额外的事件
 */
public class RecyclerExtra {
    /**
     * item长按事件
     */
    public interface OnItemLongClickListener {
        void onLongClick(View view, int position);
    }
    /**
     * item点击事件
     */
    public interface OnItemClickListener {
        void onClick(View view, int position);
    }
    /**
     * item的珊瑚删除   事件
     */
    public interface OnItemDeleteListenr {
        void onDelete(View view, int position);
    }

}
