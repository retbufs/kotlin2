package com.example.logindenis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.example.logindenis.adapter.Grid2Adapter;
import com.example.logindenis.entity.Planet;

import java.util.ArrayList;
import java.util.List;

public class Grid2Activity extends AppCompatActivity {
    private GridView gridLayout;
    private List<Planet> planets;
    private List<Planet>  def_Plant = new ArrayList<>();
    private Grid2Adapter grid2Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid2);
        gridLayout = findViewById(R.id.gl_grid);
        grid2Adapter = new Grid2Adapter(this,def_Plant);
        gridLayout.setAdapter(grid2Adapter);
        initView();
    }

    private void initView() {
        planets = Planet.Companion.getDefaultList();
        def_Plant.clear();
        def_Plant.addAll(planets);
        grid2Adapter.notifyDataSetChanged();
    }


}
