package com.example.farhan.booklisting;

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
 * Created by Farhan on 11/4/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<Books> {

    private ArrayList<Books> arrayListBooks;

    public CustomArrayAdapter(@NonNull Context context, ArrayList<Books> arrayListBooks) {
        super(context, 0,arrayListBooks);
        this.arrayListBooks = arrayListBooks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview,parent,false);
        }

        Books bObj = arrayListBooks.get(position);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);

        txtTitle.setText(bObj.getTitle());
        txtAuthor.setText(bObj.getAuthor());

        return convertView;
    }
}
