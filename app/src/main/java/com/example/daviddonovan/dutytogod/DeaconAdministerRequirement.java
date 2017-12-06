package com.example.daviddonovan.dutytogod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeaconAdministerRequirement extends AppCompatActivity implements RequirementInterface {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    String user = "default";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_deacon_administer_requirement);

            //initializing firebase authentication object
            firebaseAuth = FirebaseAuth.getInstance();
            String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
            user = rawUserEmail.replace("@", "AT");
            user = rawUserEmail.replace(".", "");
        }

        boolean complete;

        @Override
        public Boolean getIsComplete(){
            return complete;
        }

        @Override
        public void setIsComplete(Boolean complete) {
            this.complete = complete;
        }

        public void updateComplete(View view) {

            ref.child("users").child(user).child("requirements").child("administerRequirement").setValue("true");
        }

          public void updateText(View view) {

              ref.child("users").child(user).child("requirements").child("administerRequirement").setValue("true");
        }
}

