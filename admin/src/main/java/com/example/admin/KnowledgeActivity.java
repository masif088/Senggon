package com.example.admin;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.model.ModelDisease;
import com.example.admin.model.ModelLearning;
import com.example.admin.model.ModelSymtoms;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KnowledgeActivity extends AppCompatActivity {

    private static final String TAG = "asd";
    @BindView(R.id.te_title)
    TextInputEditText teTitle;
    @BindView(R.id.spinner)
    Spinner spinner;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    public static String string1 = "asd";
    public static String string2 = "asd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        ButterKnife.bind(this);
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelSymtoms.CHILD);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> areas = new ArrayList<>();
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String areaName = areaSnapshot.child("description").getValue(String.class);
                    assert areaName != null;
                    areas.add(areaName);
                }
                ArrayAdapter<String> areasAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, areas);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(areasAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelDisease.CHILD);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> areas = new ArrayList<>();
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String areaName = areaSnapshot.child("title").getValue(String.class);
                    assert areaName != null;
                    areas.add(areaName);
                }
                ArrayAdapter<String> areasAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, areas);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(areasAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener2());
    }
    @OnClick(R.id.btn)
    public void onViewClicked() {
        databaseReference= FirebaseDatabase.getInstance().getReference(ModelLearning.CHILD);
        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue(new ModelLearning(id,string2,string1,Double.valueOf(teTitle.getText().toString().trim())));
        Toast.makeText(getBaseContext(), "Berhasil input", Toast.LENGTH_SHORT).show();
    }
}


