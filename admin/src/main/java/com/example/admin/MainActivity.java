package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_symtoms, R.id.btn_disease, R.id.btn_learning})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_symtoms:
                i= new Intent(this,SymtomsActivity.class);
                break;
            case R.id.btn_disease:
                i= new Intent(this,DiseaseActivity.class);
                break;
            case R.id.btn_learning:
                i= new Intent(this,KnowledgeActivity.class);
                break;
        }
        startActivity(i);
    }
}
