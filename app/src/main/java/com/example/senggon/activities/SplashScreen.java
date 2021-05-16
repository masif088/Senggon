package com.example.senggon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.senggon.R;
import com.example.senggon.model.ModelDisease;
import com.example.senggon.model.ModelLearning;
import com.example.senggon.model.ModelSymtoms;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {
    public static ArrayList<ModelDisease> diseases = new ArrayList<>();
    public static ArrayList<ModelLearning> learnings = new ArrayList<>();
    public static ArrayList<ModelSymtoms> symtoms = new ArrayList<>();
    private static DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelLearning.CHILD);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    ModelLearning areaName = areaSnapshot.getValue(ModelLearning.class);
                    assert areaName != null;
                    learnings.add(areaName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelDisease.CHILD);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    ModelDisease areaName = areaSnapshot.getValue(ModelDisease.class);
                    assert areaName != null;
                    diseases.add(areaName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelSymtoms.CHILD);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ModelSymtoms symtom = snapshot.getValue(ModelSymtoms.class);
                    symtoms.add(symtom);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, ActivityMain.class);
            startActivity(i);
            finish();
        }, 5000);
    }
}
