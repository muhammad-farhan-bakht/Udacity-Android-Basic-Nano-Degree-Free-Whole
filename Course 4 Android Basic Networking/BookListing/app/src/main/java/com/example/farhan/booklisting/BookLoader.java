package com.example.farhan.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan on 12/7/2017.
 */

public class BookLoader extends AsyncTaskLoader<List<Books>> {

    /** Query URL */
    private String mUrl;


    public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Books> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of Books.
        ArrayList<Books> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }

}
