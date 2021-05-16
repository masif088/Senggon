package com.example.admin.model;

import android.content.Intent;

public class ModelMenu {
    private String title;
    private Intent intent;

    public ModelMenu(String title, Intent intent) {
        this.title = title;
        this.intent = intent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
