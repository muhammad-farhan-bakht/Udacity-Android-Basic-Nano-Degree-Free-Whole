package com.example.farhan.newsfeed;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan on 12/12/2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {


        // Perform the network request, parse the response, and extract a list of News.
        ArrayList<News> news = QueryUtils.fetchEarthquakeData();
        return news;
    }
}
