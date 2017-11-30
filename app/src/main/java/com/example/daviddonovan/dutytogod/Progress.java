package com.example.daviddonovan.dutytogod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Progress extends AppCompatActivity implements View.OnClickListener{


    RadioButton prayButton;
    RadioButton administerButton;
    RadioButton createButton;
    RadioButton doctrineButton;
    RadioButton inviteButton;
    RadioButton projectButton;
    RadioButton serveButton;
    RadioButton worthilyButton;
    Button logout;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference prayRef  = ref.child("users").child("Avery").child("requirements").child("prayRequirement");
    DatabaseReference administerRef  = ref.child("users").child("Avery").child("requirements").child("administerRequirement");
    DatabaseReference createRef  = ref.child("users").child("Avery").child("requirements").child("createRequirement");
    DatabaseReference doctrineRef  = ref.child("users").child("Avery").child("requirements").child("doctrineRequirement");
    DatabaseReference inviteRef  = ref.child("users").child("Avery").child("requirements").child("inviteRequirement");
    DatabaseReference projectRef  = ref.child("users").child("Avery").child("requirements").child("projectRequirement");
    DatabaseReference serveRef  = ref.child("users").child("Avery").child("requirements").child("serveRequirement");
    DatabaseReference worthilyRef  = ref.child("users").child("Avery").child("requirements").child("worthilyRequirement");

    private FirebaseAuth firebaseAuth;
    String user = "Avery";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        prayButton = (RadioButton)findViewById(R.id.prayProgress);
        administerButton= (RadioButton)findViewById(R.id.administerProgress);
        createButton= (RadioButton)findViewById(R.id.createProgress);
        doctrineButton= (RadioButton)findViewById(R.id.doctrineProgress);
        inviteButton= (RadioButton)findViewById(R.id.inviteProgress);
        projectButton= (RadioButton)findViewById(R.id.projectProgress);
        serveButton= (RadioButton)findViewById(R.id.serveProgress);
        worthilyButton= (RadioButton)findViewById(R.id.worthilyProgress);
        logout=(Button) findViewById(R.id.buttonLogout);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login.class));

            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            logout.setOnClickListener(this);
        }

    }

    /** OnStart Function
    Will grab progress from the database and set the progress of each activity
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("progress", "onStart");
        if (false) {
            writeUserInformation();
        }

        prayRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
                    prayButton.setChecked(true); }
                else {
                    prayButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


        administerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
                    administerButton.setChecked(true); }
                else {
                    administerButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


        createRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
                    createButton.setChecked(true); }
                else {
                    createButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        doctrineRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
                    doctrineButton.setChecked(true); }
                else {
                    doctrineButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


        inviteRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
                    inviteButton.setChecked(true); }
                else {
                    inviteButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


        projectRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String progress = dataSnapshot.getValue(String.class);
                if (progress == "true") {
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
                if (progress == "true") {
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
                if (progress == "true") {
                    worthilyButton.setChecked(true); }
                else {
                    worthilyButton.setChecked(false);}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

   }

    /** Start the Pray Requirement */
    public void getPray(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Pray Activity ");

        Intent requirementIntent = new Intent(this, DeaconPrayRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Worthily Requirement */
    public void getWorthily(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Worthily Activity ");

        Intent requirementIntent = new Intent(this, DeaconWorthilyRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Doctrine Requirement */
    public void getDoctrine(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Doctrine Activity ");

        Intent requirementIntent = new Intent(this, DeaconDoctrineRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Administer Requirement */
    public void getAdminister(View theButton) {


        Intent requirementIntent = new Intent(this, DeaconAdministerRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Serve Requirement */
    public void getServe(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Serve Activity ");

        Intent requirementIntent = new Intent(this, DeaconServeRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Invite Requirement */
    public void getInvite(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Invite Activity ");

        Intent requirementIntent = new Intent(this, DeaconInviteRequirement.class);
        startActivity(requirementIntent);
    }

    /** Start the Create Project Requirement */
    public void getCreateProject(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get CreateProject Activity ");

        Intent requirementIntent = new Intent(this, DeaconCreateProjectRequirement.class);
        startActivity(requirementIntent);
    }
    /** Start the Project Requirement */
    public void getProject(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Project Activity ");

        Intent requirementIntent = new Intent(this, DeaconProjectRequirement.class);
        startActivity(requirementIntent);
    }

    private void writeUserInformation()
    {
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

    @Override
    public void onClick(View v) {
        if(v == logout){

            firebaseAuth.signOut();
            finish();



            //starting login activity
            startActivity(new Intent(this, MainActivity.class));}
    }

    public void logout(View view) {
        firebaseAuth.signOut();
        finish();

        startActivity(new Intent(this, Login.class));
    }
}