package com.example.farhan.tokyoguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Food_Fragment extends Fragment {


    public Food_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Store a Layout in View
        View view = inflater.inflate(R.layout.fragments_layout, container, false);

        // Storing Objects in ArrayList Index
        final ArrayList<mDataSource> dataSource = new ArrayList<>();
        dataSource.add(new mDataSource(R.drawable.tofuya_ukai,R.string.Food_One_Name,R.string.Food_One_Dec,R.string.Food_One_Location,R.string.Food_One_Schedule,R.string.Food_One_Phone));
        dataSource.add(new mDataSource(R.drawable.otafuku,R.string.Food_Two_Name,R.string.Food_Two_Dec,R.string.Food_Two_Location,R.string.Food_Two_Schedule,R.string.Food_Two_Phone));
        dataSource.add(new mDataSource(R.drawable.quintessence,R.string.Food_Three_Name,R.string.Food_Three_Dec,R.string.Food_Three_Location,R.string.Food_Three_Schedule,R.string.Food_Three_Phone));
        dataSource.add(new mDataSource(R.drawable.florilege,R.string.Food_Four_Name,R.string.Food_Four_Dec,R.string.Food_Four_Location,R.string.Food_Four_Schedule,R.string.Food_Four_Phone));
        dataSource.add(new mDataSource(R.drawable.sushi_tokami,R.string.Food_Five_Name,R.string.Food_Five_Dec,R.string.Food_Five_Location,R.string.Food_Five_Schedule,R.string.Food_Five_Phone));


        // Making an Object of CustomArrayAdapter and sending Context and ArrayList DataSource in its constructor
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getContext(),dataSource);

        // Getting ListView from Layout
        final ListView listView = (ListView) view.findViewById(R.id.fragmentListView);

        // Set Adapter on ListView
        listView.setAdapter(customArrayAdapter);

        return view;
    }

}
