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
public class Shops_Fragment extends Fragment {


    public Shops_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Store a Layout in View
        View view = inflater.inflate(R.layout.fragments_layout, container, false);

        // Storing Objects in ArrayList Index
        final ArrayList<mDataSource> dataSource = new ArrayList<>();
        dataSource.add(new mDataSource(R.drawable.one_piece_store,R.string.Shop_One_Name,R.string.Shop_One_Dec,R.string.Shop_One_Location,R.string.Shop_One_Schedule,R.string.Shop_One_Phone));
        dataSource.add(new mDataSource(R.drawable.mandarake,R.string.Shop_Two_Name,R.string.Shop_Two_Dec,R.string.Shop_Two_Location,R.string.Shop_Two_Schedule,R.string.Shop_Two_Phone));
        dataSource.add(new mDataSource(R.drawable.k_books,R.string.Shop_Three_Name,R.string.Shop_Three_Dec,R.string.Shop_Three_Location,R.string.Shop_Three_Schedule,R.string.Shop_Three_Phone));
        dataSource.add(new mDataSource(R.drawable.aki_games,R.string.Shop_Four_Name,R.string.Shop_Four_Dec,R.string.Shop_Four_Location,R.string.Shop_Four_Schedule,R.string.Shop_Four_Phone));
        dataSource.add(new mDataSource(R.drawable.tokyo_anime_center,R.string.Shop_Five_Name,R.string.Shop_Five_Dec,R.string.Shop_Five_Location,R.string.Shop_Five_Schedule,R.string.Shop_Five_Phone));

        // Making an Object of CustomArrayAdapter and sending Context and ArrayList DataSource in its constructor
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getContext(),dataSource);

        // Getting ListView from Layout
        final ListView listView = (ListView) view.findViewById(R.id.fragmentListView);

        // Set Adapter on ListView
        listView.setAdapter(customArrayAdapter);

        return view;
    }

}
