package com.example.senggon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senggon.R;
import com.example.senggon.adapter.RVDiagnosa;
import com.example.senggon.model.ModelDiagnosa;
import com.example.senggon.model.ModelSymtoms;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityDiagnosa extends AppCompatActivity {
    private static final String TAG = "asd";
    @BindView(R.id.rv)
    RecyclerView rv;
    RVDiagnosa adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);
        ButterKnife.bind(this);
        ArrayList<ModelDiagnosa> diagnosas = getDianosa();
        adapter = new RVDiagnosa(diagnosas);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(ActivityDiagnosa.this, LinearLayoutManager.VERTICAL, false));
    }

    private ArrayList<ModelDiagnosa> getDianosa() {
        ArrayList<ModelDiagnosa> diagnosas = new ArrayList<>();
        for (int i = 0; i < SplashScreen.symtoms.size(); i++) {
            diagnosas.add(new ModelDiagnosa(SplashScreen.symtoms.get(i), false));
            Log.d(TAG, "getDianosa: "+diagnosas.get(i).getDescription());
        }
        return diagnosas;
    }

    @OnClick({R.id.btn_back, R.id.btn_diagnosa})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_diagnosa:
                Intent i = new Intent(ActivityDiagnosa.this, ActivityResults.class);
                startActivity(i);
                break;
        }
    }
}
