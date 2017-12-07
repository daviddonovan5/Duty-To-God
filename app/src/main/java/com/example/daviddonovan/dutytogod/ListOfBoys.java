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

public class ListOfBoys extends AppCompatActivity {


    String email;
    EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_boys);

        emailText = findViewById(R.id.editTextEmail);
    }


    void getDeacon(View theView){

        email = emailText.getText().toString();

        Intent intent = new Intent(this, LeaderDeaconProgress.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
