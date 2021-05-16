package com.example.senggon.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senggon.R;
import com.example.senggon.adapter.RVMenu;
import com.example.senggon.model.ModelMenu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    ArrayList<ModelMenu> menus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        menus.add(new ModelMenu("Diagnosa", new Intent(this, ActivityDiagnosa.class)));
        menus.add(new ModelMenu("About", new Intent(this, ActivityAbout.class)));
        RVMenu adapter = new RVMenu(menus);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
//harusnya masuk pop up
//tanaman anda sehat