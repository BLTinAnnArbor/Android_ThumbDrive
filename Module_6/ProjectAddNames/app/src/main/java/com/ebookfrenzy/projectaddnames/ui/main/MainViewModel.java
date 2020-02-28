package com.ebookfrenzy.projectaddnames.ui.main;

import androidx.lifecycle.ViewModel;
import android.util.Log;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    private String name;

    public ArrayList<String> nameList = new ArrayList<String>();

    public void addListItem(){
        Log.i(TAG, "in mvm addListItem()");
        nameList.add(name);
    }

    public void setName (String n){

        Log.i(TAG, "in setName()");
        name = n;
    }

    public String getName(){

        Log.i(TAG, "in getName()");
        return name;
    }

} // MainViewModel class
