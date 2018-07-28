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
public class Sights_Fragment extends Fragment {


    public Sights_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Store a Layout in View
        View view = inflater.inflate(R.layout.fragments_layout, container, false);

        // Storing Objects in ArrayList Index
        final ArrayList<mDataSource> dataSource = new ArrayList<>();
        dataSource.add(new mDataSource(R.drawable.the_lmperia_palace,R.string.Sight_One_Name,R.string.Sight_One_Dec,R.string.Sight_One_Location,R.string.Sight_One_Schedule,R.string.Sight_One_Phone));
        dataSource.add(new mDataSource(R.drawable.asakusa_temple,R.string.Sight_Two_Name,R.string.Sight_Two_Dec,R.string.Sight_Two_Location,R.string.Sight_Two_Schedule,R.string.Sight_Two_Phone));
        dataSource.add(new mDataSource(R.drawable.ueno_park_and_zoo,R.string.Sight_Three_Name,R.string.Sight_Three_Dec,R.string.Sight_Three_Location,R.string.Sight_Three_Schedule,R.string.Sight_Three_Phone));
        dataSource.add(new mDataSource(R.drawable.japan_tokyo_national_museum,R.string.Sight_Four_Name,R.string.Sight_Four_Dec,R.string.Sight_Four_Location,R.string.Sight_Four_Schedule,R.string.Sight_Four_Phone));
        dataSource.add(new mDataSource(R.drawable.japan_tokyo_skytree,R.string.Sight_Five_Name,R.string.Sight_Five_Dec,R.string.Sight_Five_Location,R.string.Sight_Five_Schedule,R.string.Sight_Five_Phone));

        // Making an Object of CustomArrayAdapter and sending Context and ArrayList DataSource in its constructor
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getContext(),dataSource);

        // Getting ListView from Layout
        final ListView listView = (ListView) view.findViewById(R.id.fragmentListView);

        // Set Adapter on ListView
        listView.setAdapter(customArrayAdapter);

        return view;
    }

}
