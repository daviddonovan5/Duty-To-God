package com.example.daviddonovan.dutytogod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeaconServeRequirement extends AppCompatActivity implements RequirementInterface{

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    String user = "";

    EditText notesText;
    String notes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_serve_requirement);


        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
        user = rawUserEmail.replace("@", "AT");
        user = rawUserEmail.replace(".", "");
        notesText = findViewById(R.id.actText);
    }


    public void updateComplete(View view) {

        ref.child("users").child(user).child("requirements").child("serveRequirement").setValue("true");
    }

    public void updateNotes(View view) {


        notes = notesText.getText().toString();
        ref.child("users").child(user).child("notes").child("serveRequirement").setValue(notes);
    }

    public void getNotes(View view) {
        DatabaseReference notesRef = ref.child("users").child(user).child("notes").child("serveRequirement");

        notesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                notes = dataSnapshot.getValue(String.class);
                notesText.setText(notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}
