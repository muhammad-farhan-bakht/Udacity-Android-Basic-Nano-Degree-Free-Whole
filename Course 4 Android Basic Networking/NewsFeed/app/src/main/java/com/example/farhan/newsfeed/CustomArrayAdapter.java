package com.example.farhan.newsfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farhan on 12/12/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    private ArrayList<News> newsArrayList;

    public CustomArrayAdapter(@NonNull Context context, ArrayList<News> newsArrayList) {
        super(context, 0, newsArrayList);
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        News newsObj = newsArrayList.get(position);

        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView author = convertView.findViewById(R.id.txtAuthor);
        TextView date = convertView.findViewById(R.id.txtDate);

        title.setText(newsObj.getTitle());
        author.setText(newsObj.getAuthor());
        date.setText(newsObj.getDate());

        return convertView;
    }
}
