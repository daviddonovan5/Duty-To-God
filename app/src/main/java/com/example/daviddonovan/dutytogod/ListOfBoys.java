package com.example.daviddonovan.dutytogod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;

public class ListOfBoys extends AppCompatActivity {

    String name;
    Array list[];
    Activity _activity;

    public Array[] getList() {
        return list;
    }

    public void setList(Array[] list) {
        this.list = list;
    }

    public Activity get_activity() {
        return _activity;
    }

    public void set_activity(Activity _activity) {
        this._activity = _activity;
    }

    public void displayListofBoys(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_boys);
    }
}
