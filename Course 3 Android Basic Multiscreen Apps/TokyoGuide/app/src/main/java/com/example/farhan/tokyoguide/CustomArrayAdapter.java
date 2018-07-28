package com.example.farhan.tokyoguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farhan on 10/3/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    // Get an ArrayList When Constructor is call
    ArrayList<mDataSource> dataSource;

    public CustomArrayAdapter(@NonNull Context context, ArrayList<mDataSource> dataSource) {
        super(context,0,dataSource);
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;

        if (convertView == null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.listview_fragments, parent, false);

        } else {
            view = convertView;
        }

        // Get an Object from Arraylist
        mDataSource mDataSource = dataSource.get(position);

        // Find Views
        ImageView imageView = (ImageView) view.findViewById(R.id.photoImageView);
        TextView textViewName = (TextView) view.findViewById(R.id.nameTextView);
        TextView textViewDec = (TextView) view.findViewById(R.id.descriptionTextView);
        TextView textViewAddress = (TextView) view.findViewById(R.id.addressTextView);
        TextView textViewSchedule = (TextView) view.findViewById(R.id.scheduleTextView);
        TextView textViewPhone = (TextView) view.findViewById(R.id.phoneTextView);

        // Set Data on Views
        imageView.setImageResource(mDataSource.getmImage());
        textViewName.setText(mDataSource.getmName());
        textViewDec.setText(mDataSource.getmDec());
        textViewAddress.setText(mDataSource.getmLocation());
        textViewSchedule.setText(mDataSource.getmSchedule());
        textViewPhone.setText(mDataSource.getmPhone());

        return view;
    }
}
