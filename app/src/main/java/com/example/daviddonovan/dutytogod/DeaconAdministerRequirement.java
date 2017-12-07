package com.example.daviddonovan.dutytogod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/** Displays the Administer Requirement Page, Implements the Requirement Interface */
public class DeaconAdministerRequirement extends AppCompatActivity implements RequirementInterface {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth firebaseAuth;
    String user = "";
    EditText notesText;
    String notes = "";
    String TAG = "ADMIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_administer_requirement);

        //initializing fireBase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        // get current user
        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace(".", "");

        // get the notes from the display
        notesText = findViewById(R.id.actText);
    }

    @Override
    public void updateComplete(View view) {
        ref.child("users").child(user).child("requirements").child("administerRequirement").setValue("true");
        Log.d(TAG, "updateComplete()");
    }

    @Override
    public void updateNotes(View view) {
        notes = notesText.getText().toString();
        ref.child("users").child(user).child("notes").child("administerRequirement").setValue(notes);
        Log.d(TAG, "updateNotes() " + notes);
    }

    @Override
    public void getNotes(View view) {
        // get database reference
        DatabaseReference notesRef = ref.child("users").child(user).child("notes").child("administerRequirement");

        // get value from database
        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                notes = dataSnapshot.getValue(String.class);
                notesText.setText(notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled() could not connect to database");
            }
        });

        Log.d(TAG, "getNotes() " + notes);
    }

}

