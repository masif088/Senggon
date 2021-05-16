package com.example.admin;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;


public class CustomOnItemSelectedListener implements OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        KnowledgeActivity.string1= parent.getItemAtPosition(pos).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
