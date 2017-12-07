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
/** Displays the Learn Act and Share for the invite requirement Page & lets the young man take notes,
 * Implements the Requirement Interface*/
public class DeaconInviteRequirement extends AppCompatActivity implements RequirementInterface{

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    String user = "";
    FirebaseAuth firebaseAuth;
    EditText notesText;
    String notes = "";
    String TAG = "INVITE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_invite_requirement);


        //initializing fireBase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace(".", "");

        notesText = findViewById(R.id.actText);
    }

    @Override
    public void updateComplete(View view) {
        ref.child("users").child(user).child("requirements").child("inviteRequirement").setValue("true");
        Log.d(TAG, "marked invite complete" );
    }

    @Override
    public void updateNotes(View view) {
        notes = notesText.getText().toString();
        ref.child("users").child(user).child("notes").child("inviteRequirement").setValue(notes);
        Log.d(TAG, "saved notes:" + notes );
    }

    @Override
    public void getNotes(View view) {
        DatabaseReference notesRef = ref.child("users").child(user).child("notes").child("inviteRequirement");

        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notes = dataSnapshot.getValue(String.class);
                notesText.setText(notes);
                Log.d(TAG, "received notes: " + notes );
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "problem accessing database ");
            }
        });
    }
}
