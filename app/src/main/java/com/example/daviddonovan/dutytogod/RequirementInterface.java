package com.example.daviddonovan.dutytogod;

import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by avery on 11/2/2017.
 */

public interface RequirementInterface {


    void updateComplete(View view);

    void updateNotes(View view);

    void getNotes(View view);
}
