package com.example.daviddonovan.dutytogod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/** */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private TextView goLogin;
    private ProgressDialog progressDialog;
    String TAG = "MAIN";

    // database reference
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    String user;

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    /** */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "The app started");

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

       if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity

            String rawUserEmail = firebaseAuth.getCurrentUser().getEmail();
            user = rawUserEmail.replace(".", "");

            DatabaseReference userTypeRef  = ref.child("users").child(user).child("userType");

            userTypeRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String progress = dataSnapshot.getValue(String.class);
                    if (progress.matches("Leader")) {
                        Intent requirementIntent = new Intent(getApplicationContext(), ListOfBoys.class);
                        startActivity(requirementIntent);
                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), Progress.class));
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "Problem accessing database");
                }
            });


        }

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        goLogin = (TextView) findViewById(R.id.textViewSignIn);

        buttonSignup = (Button) findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        goLogin.setOnClickListener(this);
    }

    /** */
    private void registerUser(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(MainActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();

                                finish();
                                startActivity(new Intent(getApplicationContext(), userChoice.class));

                        }else{

                            Toast.makeText(MainActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    /** */
    public void onClick(View view) {
        if(view == buttonSignup){
            registerUser();
        }

        if(view ==goLogin ){
            finish();
            startActivity(new Intent(this, Login.class));
        }
    }
}