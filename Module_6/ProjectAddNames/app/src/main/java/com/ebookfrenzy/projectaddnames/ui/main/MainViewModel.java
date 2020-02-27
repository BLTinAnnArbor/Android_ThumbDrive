package com.ebookfrenzy.projectaddnames.ui.main;

import androidx.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";
    private String name;

    public void setName (String n){

        Log.i(TAG, "in setName()");
        name = n;
    }

    public String getName(){

        Log.i(TAG, "in getName()");
        return name;
    }

}
