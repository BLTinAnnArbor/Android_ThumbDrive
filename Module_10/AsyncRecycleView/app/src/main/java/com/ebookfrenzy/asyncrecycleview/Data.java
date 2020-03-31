package com.ebookfrenzy.asyncrecycleview;

import android.util.Log;

import java.util.ArrayList;

public class Data {

    public static final String TAG ="Data";

    public static ArrayList<String> nameList = new ArrayList<>();
    public static ArrayList<Integer> timeList = new ArrayList<>();

    public static void addName(String n){

        Log.i(TAG, "in addName()");
        
        nameList.add(n);
    }

    public static void addTime(int t){
        timeList.add(t);
    }

    public static String getName(int i){
        Log.i(TAG, "in getName()");
        return nameList.get(i);
    }

} //class Data
