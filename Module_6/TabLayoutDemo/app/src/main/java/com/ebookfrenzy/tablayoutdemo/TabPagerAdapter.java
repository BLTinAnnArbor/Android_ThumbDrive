package com.ebookfrenzy.tablayoutdemo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.tabCount = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch(position){
        case 0:
            return new FirstFragment();
        case 1:
            return new SecondFragment();
        case 2:
            return new ThirdFragment();
        case 3:
            return new FourthFragment();
        default:
            return null;
        }
    }
    @Override
    public int getCount(){
        return tabCount;
    }
}
