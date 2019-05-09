package com.zhenio.baselibrary.recycler;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zhenio.baselibrary.recycler.RecyclerExtra.OnItemLongClickListener;
import com.zhenio.baselibrary.recycler.RecyclerExtra.OnItemClickListener;
import com.zhenio.baselibrary.recycler.RecyclerExtra.OnItemDeleteListenr;

import java.util.ArrayList;

/**
 * 处理recyclerAdapter通用适配器
 * @param  <T,VH>
 */
public abstract class BaseRecyclerAdapter<T,VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> implements
        OnItemClickListener,
        OnItemLongClickListener,
        OnItemDeleteListenr {

    private Context context;
    private ArrayList<T> arrayList;
    protected LayoutInflater layoutInflater;
    /**
     * 必须将当前的数据类型传入
     * @param context
     * @param arrayList
     */
    public BaseRecyclerAdapter(Context context, ArrayList<T> arrayList){
        this.arrayList = arrayList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    /**
     * 调用时必须传入当前activity 的上下
     * @param context
     */
    protected BaseRecyclerAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);
    @Override
    public abstract void onBindViewHolder(@NonNull VH vh, int i);
    @Override
    public abstract int getItemCount();

    /**
     * item的点击事件
     */
    public  OnItemClickListener onItemClickListenr;
    public void setOnItemClickListenr(OnItemClickListener clickListenr ){
        this.onItemClickListenr = clickListenr;
    }
    /**
     * 设置当前item的点击事件
     */
    public OnItemLongClickListener onItemLongClickListener;
    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener){
        this.onItemLongClickListener = longClickListener;
    }
    /**
     * 设置当前item的删除事件
     */
    public OnItemDeleteListenr onItemDeleteListenr;
    public void setOnItemDeleteListenr(OnItemDeleteListenr itemDeleteListenr){
        this.onItemDeleteListenr  = itemDeleteListenr;
    }


    abstract  class BaseViewHolder extends RecyclerView.ViewHolder {
        public  BaseViewHolder(View itemView)  {
            super(itemView);
        }
    }

}
