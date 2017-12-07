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
/** This class displays the progress of the deacon. It will grab the information from the database associated with the user and display it */
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
    String user = "Default";

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();




    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        prayButton = findViewById(R.id.prayProgress);
        administerButton = findViewById(R.id.administerProgress);
        createButton = findViewById(R.id.createProgress);
        doctrineButton = findViewById(R.id.doctrineProgress);
        inviteButton = findViewById(R.id.inviteProgress);
        projectButton = findViewById(R.id.projectProgress);
        serveButton = findViewById(R.id.serveProgress);
        worthilyButton = findViewById(R.id.worthilyProgress);
        logout = findViewById(R.id.buttonLogout);

        //initializing Firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login.class));


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

        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace(".", "");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("users").hasChild(user)){
                    //user is created
                }
                else{
                    // login again
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


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

    /** This creates the user in the database */
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
    /** */
    public void onClick(View v) {
        if(v == logout){

            firebaseAuth.signOut();
            finish();



            //starting login activity
            startActivity(new Intent(this, MainActivity.class));}
    }

    /** */
    public void logout(View view) {
        firebaseAuth.signOut();
        finish();

        startActivity(new Intent(this, Login.class));
    }
}