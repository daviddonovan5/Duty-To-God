package com.example.daviddonovan.dutytogod;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity extends AppCompatActivity implements DeaconforStrengthofYouth, DeaconPriesthoodDuties, DeaconSpiritualStrength {
    public static final String PREFS_NAME = "MyPrefsFile";
    private String actGoals;
    private String shareNotes;
    private boolean isComplete;
    private boolean isSigned;
    private String username="youk";

    public String getActGoals() {
        return actGoals;
    }

    public void setActGoals(String goals) {
        actGoals=goals;
    }

    public String getShareNotes() {
        return shareNotes;
    }

    public void setShareNotes(String notes) {
        shareNotes=notes;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComp) {
        isComplete=isComp;
    }

    public void saveGoals() {
    }

    public void saveNotes() {
    }

    public void displayLearn() {
    }

    public void setSigned(boolean isSign) {
        isSigned=isSign;
    }

    public boolean getSigned() {
        return isSigned;
    }
    
        // Progress Page
    public void getProgress(View theButton) {
        Log.d("MainActivity", "Attempting to create intent to get Progress Activity ");

        Intent progressIntent = new Intent(this, Progress.class);
        startActivity(progressIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String user = settings.getString("username",username);

        username=user;
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username",username);

        editor.commit();
    }
}
