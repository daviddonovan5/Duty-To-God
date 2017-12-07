package com.example.daviddonovan.dutytogod;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LeaderDeaconProgress extends AppCompatActivity {


    RadioButton prayButton;
    RadioButton administerButton;
    RadioButton createButton;
    RadioButton doctrineButton;
    RadioButton inviteButton;
    RadioButton projectButton;
    RadioButton serveButton;
    RadioButton worthilyButton;
    Button logout;
    String rawUserEmail = "default";
    String user = "Default";

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_deacon_progress);
        prayButton = findViewById(R.id.prayProgress);
        administerButton= findViewById(R.id.administerProgress);
        createButton= findViewById(R.id.createProgress);
        doctrineButton= findViewById(R.id.doctrineProgress);
        inviteButton= findViewById(R.id.inviteProgress);
        projectButton= findViewById(R.id.projectProgress);
        serveButton= findViewById(R.id.serveProgress);
        worthilyButton= findViewById(R.id.worthilyProgress);
        logout= findViewById(R.id.buttonLogout);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();




        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){

            //closing this activity
            finish();

            //starting login activity
            startActivity(new Intent(this, Login.class));

        }

    }

    /** OnStart Function
     Will grab progress from the database and set the progress of each activity
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("progress", "onStart");

        // GET EMAIL FROM PREVIOUS PAGE
        Intent intent = getIntent();
        rawUserEmail = intent.getStringExtra("email");
        TextView title = findViewById(R.id.title);
        title.setText(rawUserEmail + " Progress");

        //take out symbols from the email
        user = rawUserEmail.replace("@", "AT");
        user = rawUserEmail.replace(".", "");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("users").hasChild(user)){
                    Toast.makeText(LeaderDeaconProgress.this, "The user exsists", Toast.LENGTH_SHORT).show();
                    // continue


                    DatabaseReference prayRef  = ref.child("users").child(user).child("requirements").child("prayRequirement");

                    prayRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                prayButton.setChecked(true);}
                            else {
                                prayButton.setChecked(false);
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });

                    DatabaseReference administerRef  = ref.child("users").child(user).child("requirements").child("administerRequirement");
                    administerRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                administerButton.setChecked(true); }
                            else {
                                administerButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });

                    DatabaseReference createRef  = ref.child("users").child(user).child("requirements").child("createRequirement");
                    createRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                createButton.setChecked(true); }
                            else {
                                createButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });


                    DatabaseReference doctrineRef  = ref.child("users").child(user).child("requirements").child("doctrineRequirement");

                    doctrineRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                doctrineButton.setChecked(true); }
                            else {
                                doctrineButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });


                    DatabaseReference inviteRef  = ref.child("users").child(user).child("requirements").child("inviteRequirement");
                    inviteRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                inviteButton.setChecked(true); }
                            else {
                                inviteButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });


                    DatabaseReference projectRef  = ref.child("users").child(user).child("requirements").child("projectRequirement");
                    DatabaseReference serveRef  = ref.child("users").child(user).child("requirements").child("serveRequirement");
                    DatabaseReference worthilyRef  = ref.child("users").child(user).child("requirements").child("worthilyRequirement");

                    projectRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                projectButton.setChecked(true); }
                            else {
                                projectButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });


                    serveRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                serveButton.setChecked(true); }
                            else {
                                serveButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });


                    worthilyRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String progress = dataSnapshot.getValue(String.class);
                            if (progress.matches("true")) {
                                worthilyButton.setChecked(true); }
                            else {
                                worthilyButton.setChecked(false);}
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });
                }
                else{
                    Toast.makeText(LeaderDeaconProgress.this, "USER DOES NOT HAVE AN ACCOUNT", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void logout(View view) {


        firebaseAuth.signOut();
        finish();

        startActivity(new Intent(this, Login.class));

    }
}

