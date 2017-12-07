package com.example.daviddonovan.dutytogod;

import android.view.View;

/**
 * Requirement Interface has the needed functions for each requirement page (updateComplete, updateNotes, getNotes)
 */

public interface RequirementInterface {

    /** updates the database to show the requirement is complete */
    void updateComplete(View view);

    /** updates the database to show the inputted notes  */
    void updateNotes(View view);

    /** get the notes already save to the database if available */
    void getNotes(View view);
}
