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
/** Create Project Requirement */
public class DeaconCreateProjectRequirement extends AppCompatActivity implements RequirementInterface{

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    String user = "";
    FirebaseAuth firebaseAuth;
    String TAG = "CREATE_PROJECT";
    EditText notesText;
    String notes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_physical_health);

        //initializing fireBase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        // get current user
        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace(".", "");

        notesText = findViewById(R.id.actText);
    }

    @Override
    public void updateComplete(View view) {
        ref.child("users").child(user).child("requirements").child("createRequirement").setValue("true");
        Log.d(TAG, "create complete" );
    }

    @Override
    public void updateNotes(View view) {
        notes = notesText.getText().toString();
        ref.child("users").child(user).child("notes").child("createRequirement").setValue(notes);
        Log.d(TAG, "Following notes added to create:" + notes);
    }

    @Override
    public void getNotes(View view) {
        DatabaseReference notesRef = ref.child("users").child(user).child("notes").child("createRequirement");
        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notes = dataSnapshot.getValue(String.class);
                notesText.setText(notes);
                Log.d(TAG, "RECEIVED:" + notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled(), problem accessing the database" );
            }
        });
    }

}
