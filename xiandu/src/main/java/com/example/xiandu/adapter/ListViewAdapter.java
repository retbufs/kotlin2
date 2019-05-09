package com.example.xiandu.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.xiandu.R;
import com.example.xiandu.data.Data;


import java.util.List;


public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Data.ResultInfo.Category>  categories;

    public ListViewAdapter(Context context, List<Data.ResultInfo.Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.id_text);
            convertView.setTag(viewHolder);
        }else{
         viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(categories.get(position).getTitle());
        return convertView;
    }

    class ViewHolder{
        public TextView textView;
    }
}
