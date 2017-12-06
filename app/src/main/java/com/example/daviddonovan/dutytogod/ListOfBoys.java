package com.example.daviddonovan.dutytogod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;

public class ListOfBoys extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_boys);


    }


    void getDeacon(View theView){

        startActivity(new Intent(ListOfBoys.this, LeaderDeaconProgress.class));
    }
}
