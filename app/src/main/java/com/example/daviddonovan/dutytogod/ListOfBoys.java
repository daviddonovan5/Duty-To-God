package com.example.daviddonovan.dutytogod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
/** This class will prompt the user for an email address and will redirect them to the leader progress screen*/
public class ListOfBoys extends AppCompatActivity {


    String email;
    EditText emailText;
    String TAG= "PROGRESS_OF_EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_boys);

        emailText = findViewById(R.id.editTextEmail);
    }


    /** This method will get the email and set the email to be able get the progress from the database*/
    void getDeacon(View theView){

        email = emailText.getText().toString();
        Log.d(TAG, "Attempting to get progress with email: " + email );

        Intent intent = new Intent(this, LeaderDeaconProgress.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
