package com.example.farhan.tokyoguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ArrayList of Fragment to Store Fragments and use in ViewPager
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.mViewPager);

        //Assigning Fragments Objects in ArrayList
        fragments = new ArrayList<>();
        fragments.add(new Sights_Fragment());
        fragments.add(new Food_Fragment());
        fragments.add(new Shops_Fragment());

        //making an object of @MainPageCustomArrayAdapter and passing data to Adapter.
        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager(), fragments);

        //setAdapter on listView
        viewPager.setAdapter(customViewPagerAdapter);

    }
}
