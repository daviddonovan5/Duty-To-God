package com.example.daviddonovan.dutytogod;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hayounglee on 11/4/17.
 */

public class Database {
    public String name;
    public int uniqueId;
    private JSONObject youngMenInput=new JSONObject();

    public JSONObject setYoungMenInput(String youngManName) throws JSONException {
        Log.d("DatabaseActivity", "Attempting to get name");

        youngMenInput.put(youngManName, "name");
        return youngMenInput;
    }

    public void sendYoungMenInput(String dName, int uniqID) {
        Log.d("DatabaseActivity", "Attempting to send name");
        name=dName;
        uniqueId=uniqID;
    }

    public void receiveYoungMenInput(String names, int uniqID) {

        Log.d("DatabaseActivity", "Attempting to receive name");
    }
}
