package com.example.senggon.feature;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.senggon.activities.SplashScreen;
import com.example.senggon.model.ModelDiagnosa;
import com.example.senggon.model.ModelDisease;
import com.example.senggon.model.ModelLearning;
import com.example.senggon.model.ModelResult;

import java.util.ArrayList;

public class Checker {

    public static ArrayList<ModelResult> results = new ArrayList<>();

    public static ArrayList<ModelResult> Diagnosa(String symtoms) {
        getResult();
        String[] strings = symtoms.split("_");
        for (int i = 0; i < strings.length; i++) {
            Log.d("ccc", "Diagnosa: "+strings[i]);
//            Log.d("ccc", "Diagnosa: aaaaaaaaaaaaaa");
            for (int j = 0; j < SplashScreen.learnings.size(); j++) {
                Log.d("ccc", "Diagnosaaaa: "+strings[i]+" "+ SplashScreen.learnings.get(j).getId_symtoms());
                if (SplashScreen.learnings.get(j).getId_symtoms().equals(strings[i])) {
                    Log.d("ccc", "Diagnoscccca: aaaaaaaaaa");
                    for (int k = 0; k < SplashScreen.diseases.size(); k++) {
                        Log.d("ccc", "Diagnosaaassacacaca: "+SplashScreen.learnings.get(j).getId_disease()+" "+ SplashScreen.diseases.get(k).getTitle());
                        if (SplashScreen.learnings.get(j).getId_disease().equals(SplashScreen.diseases.get(k).getTitle())) {
                            results.get(j).setRating(results.get(j).getRating() + SplashScreen.learnings.get(i).getRate());
                            Log.d("ccc", "Diagnosa:aaaaaaaaaaaaaaaaaa ");
                            break;
                        }
                    }
                }
            }
        }
        return results;
    }
    private static void getResult() {
        for (int i = 0; i < SplashScreen.diseases.size(); i++) {
            results.add(new ModelResult(SplashScreen.diseases.get(i)));
        }
    }
}
