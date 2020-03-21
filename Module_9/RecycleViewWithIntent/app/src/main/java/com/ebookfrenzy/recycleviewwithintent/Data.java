package com.ebookfrenzy.recycleviewwithintent;

import java.util.ArrayList;
import java.util.List;

public class Data {

    List<String> titleList = new ArrayList<>();
    List<String> detailList = new ArrayList<>();
    List<Integer> imageList = new ArrayList<Integer>();

    public Data(){     // Constructor
        makeTitleList();
        makeDetailList();
        makeImageList();
    }

    public void makeTitleList(){
        titleList.add("Chapter One");
        titleList.add("Chapter Two");
        titleList.add("Chapter Three");
        titleList.add("Chapter Four");
        titleList.add("Chapter Five");
        titleList.add("Chapter Six");
        titleList.add("Chapter Seven");
        titleList.add("Chapter Eight");
    }

    public void makeDetailList(){
        detailList.add("Item one details");
        detailList.add("Item two details");
        detailList.add("Item three details");
        detailList.add("Item four details");
        detailList.add("Item five details");
        detailList.add("Item six details");
        detailList.add("Item seven details");
        detailList.add("Item eight details");
    }

    public void makeImageList(){
        imageList.add(R.drawable.android_image_1);
        imageList.add(R.drawable.android_image_2);
        imageList.add(R.drawable.android_image_3);
        imageList.add(R.drawable.android_image_4);
        imageList.add(R.drawable.android_image_5);
        imageList.add(R.drawable.android_image_6);
        imageList.add(R.drawable.android_image_7);
        imageList.add(R.drawable.android_image_8);
    }

} // class Data