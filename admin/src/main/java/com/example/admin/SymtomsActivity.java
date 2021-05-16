package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.model.ModelSymtoms;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SymtomsActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.te_description)
    TextInputEditText teDescription;
    @BindView(R.id.btn)
    Button btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symtoms);
        ButterKnife.bind(this);
        databaseReference = FirebaseDatabase.getInstance().getReference(ModelSymtoms.CHILD);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        String id = databaseReference.push().getKey();
        ModelSymtoms symtoms = new ModelSymtoms(id,teDescription.getText().toString().trim());
        databaseReference.child(id).setValue(symtoms);
        Toast.makeText(getBaseContext(), "Berhasil input", Toast.LENGTH_SHORT).show();
    }
}
