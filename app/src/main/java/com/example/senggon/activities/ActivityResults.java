package com.example.senggon.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.senggon.R;
import com.example.senggon.feature.Checker;
import com.example.senggon.model.ModelDiagnosa;
import com.example.senggon.model.ModelResult;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.senggon.adapter.RVDiagnosa.diagnosas;

public class ActivityResults extends AppCompatActivity {

    private static final String TAG = "asd";
    @BindView(R.id.results_image)
    RoundedImageView resultsImage;
    @BindView(R.id.results_diagnosa)
    TextView resultsDiagnosa;
    @BindView(R.id.results_desease)
    TextView resultsDesease;
    private String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);
        for (int i = 0; i <diagnosas.size() ; i++) {
            if (diagnosas.get(i).isChecked()){
                result=result+diagnosas.get(i).getDescription()+"_";
            }
        }
        ArrayList<ModelResult> diagnosas = new ArrayList<>();
        diagnosas.addAll(Checker.Diagnosa(result));
        resultsDesease.setText(diagnosas.get(0).getTitle());
        resultsDiagnosa.setText(result);
    }
}
