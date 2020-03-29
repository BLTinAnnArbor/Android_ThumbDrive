package com.ebookfrenzy.asyncrecycleview;

import java.util.ArrayList;
import java.util.List;

public class Data {

    ArrayList<String> nameList;

    public Data(){ // constructor

         nameList = new ArrayList<>();
    }

    public void addName(String n){
        nameList.add(n);
    }

    public String getName(int i){
        return nameList.get(i);
    }

} //class Data
