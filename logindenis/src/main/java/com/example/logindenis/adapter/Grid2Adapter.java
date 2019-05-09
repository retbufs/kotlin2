package com.example.logindenis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.logindenis.R;
import com.example.logindenis.entity.Planet;

import java.util.List;

public class Grid2Adapter extends BaseAdapter {
    private Context context;
    private List<Planet> planets;

    public Grid2Adapter(Context context, List<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }
    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if(convertView ==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_grid_image_view,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Planet planet = planets.get(position);
        viewHolder.iv_icon.setImageResource(planet.getImage());
        viewHolder.tv_title.setText(planet.getName());
        viewHolder.tv_desc.setText(planet.getDesc());
        // 处理数据
        return view;
    }
    class ViewHolder{
        private TextView tv_title;
        private TextView tv_desc;
        private ImageView iv_icon;
        public ViewHolder(View view) {
            tv_title = view.findViewById(R.id.tv_title);
            tv_desc = view.findViewById(R.id.tv_desc);
            iv_icon = view.findViewById(R.id.iv_image);
        }
    }



}
