package com.example.daviddonovan.dutytogod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class userChoice extends AppCompatActivity {

    String user = "Default";

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);

        //initializing firebase authentication object
       firebaseAuth = FirebaseAuth.getInstance();
       user = firebaseAuth.getUid();
    }

    void setLeader(View theView) {
        ref.child("users").child(user).child("userType").setValue("Leader");
        Intent requirementIntent = new Intent(this, ListOfBoys.class);
        startActivity(requirementIntent);

    }

    void setDeacon(View theView) {

        writeDeaconInformation();
        startActivity(new Intent(getApplicationContext(), Progress.class));

    }

    private void writeDeaconInformation()
    {
        ref.child("users").child(user).child("userType").setValue("Deacon");
        ref.child("users").child(user).child("requirements").child("prayRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("worthilyRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("doctrineRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("administerRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("serveRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("inviteRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("createRequirement").setValue("false");
        ref.child("users").child(user).child("requirements").child("projectRequirement").setValue("false");
        ref.child("users").child(user).child("notes").child("prayRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("worthilyRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("doctrineRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("administerRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("serveRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("inviteRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("createRequirement").setValue("");
        ref.child("users").child(user).child("notes").child("projectRequirement").setValue("");

    }

}
