package com.example.farhan.tokyoguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Farhan on 10/3/2017.
 */

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;
    private String tabTitles[] = new String[]{"SIGHTS", "FOOD", "SHOPS"};

    public CustomViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {

        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
