package com.ebookfrenzy.navigationproject.ui.main;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";
    private int imageNum;

    public void setImageNum(int n){
        imageNum = n;
        Log.i(TAG, "in setImageNum()");
    }
    public int getImageNum(){
        Log.i(TAG, "in getImageNum()");
        return imageNum;
    }
}
