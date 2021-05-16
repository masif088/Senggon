package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.model.ModelDisease;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiseaseActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.te_title)
    TextInputEditText teTitle;
    @BindView(R.id.te_description)
    TextInputEditText teDescription;
    @BindView(R.id.submit)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        ButterKnife.bind(this);
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelDisease.CHILD);

    }

    @OnClick(R.id.submit)
    public void onViewClicked() {
        String id = databaseReference.push().getKey();
        assert id != null;
        databaseReference.child(id).setValue(new ModelDisease(id, teTitle.getText().toString(), teDescription.getText().toString()));
        Toast.makeText(getBaseContext(), "Berhasil input", Toast.LENGTH_SHORT).show();
    }
}
