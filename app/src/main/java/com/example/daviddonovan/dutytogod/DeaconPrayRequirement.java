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
/** */
public class DeaconPrayRequirement extends AppCompatActivity implements RequirementInterface {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    String user = "";
    FirebaseAuth firebaseAuth;
    EditText notesText;
    String notes = "";
    String TAG = "PRAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_pray_requirement);

        //initializing fireBase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace(".", "");
        notesText = findViewById(R.id.actText);
    }

    @Override
    public void updateComplete(View view) {
        ref.child("users").child(user).child("requirements").child("prayRequirement").setValue("true");
        Log.d(TAG, "marked pray as complete" );
    }

    @Override
    public void updateNotes(View view) {
        notes = notesText.getText().toString();
        ref.child("users").child(user).child("notes").child("prayRequirement").setValue(notes);
        Log.d(TAG, "saved notes: " + notes );
    }

    @Override
    public void getNotes(View view) {
        DatabaseReference notesRef = ref.child("users").child(user).child("notes").child("prayRequirement");

        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notes = dataSnapshot.getValue(String.class);
                notesText.setText(notes);
                Log.d(TAG, "received notes: " + notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "Problem accessing database" );
            }
        });
    }
}

