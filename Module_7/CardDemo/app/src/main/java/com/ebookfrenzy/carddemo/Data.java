package com.ebookfrenzy.carddemo;

public class Data {

    private String[] titles = {"Chapter One",
            "Chapter Two",
            "Chapter Three",
            "Chapter Four",
            "Chapter Five",
            "Chapter Six",
            "Chapter Seven",
            "Chapter Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item five details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = { R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8 };

    private String detailsStr, titleStr;
    private int image_id;

    public Data(int titleNum, int detailsNum, int imageNum){

        titleStr = titles[titleNum];
        detailsStr = details[detailsNum];
        image_id = images[imageNum];

    }
}
