package com.example.farhan.newsfeed;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Farhan on 12/12/2017.
 */

public class QueryUtils {

    private QueryUtils() {
    }

    private static String getJSON() {

        final String httpRequestURL = "https://newsapi.org/v2/top-headlines?sources=ign&apiKey=dd25aa4c31f84607a29ccc20ff04b224";
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(httpRequestURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                jsonResponse += line;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return jsonResponse;
    }

    // get Desired Output from the JSON
    private static ArrayList<News> extractBooks(String json) {

        ArrayList<News> newsArrayList = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(json);

            JSONArray jsonArray = jsonResponse.getJSONArray("articles");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookObject = jsonArray.getJSONObject(i);

                String title = bookObject.getString("title");

                String author = bookObject.getString("author");
                if (author.equals("null")) {
                    author = "Not Available";
                }

                String url = bookObject.getString("url");

                String date = bookObject.getString("publishedAt");
                date = formatDate(date);
                if (date.equals("")) {
                    date = "Not Available";
                }

                News news = new News(title, author, url, date);
                newsArrayList.add(news);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsArrayList;
    }

    private static String formatDate(String rawDate) {
        String jsonDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonFormatter = new SimpleDateFormat(jsonDatePattern, Locale.US);
        try {
            Date parsedJsonDate = jsonFormatter.parse(rawDate);
            String finalDatePattern = "MMM d, yyy";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDatePattern, Locale.US);
            return finalDateFormatter.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }

    // This Method will Trigger all other method and will give us a list of News
    public static ArrayList<News> fetchEarthquakeData() {

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;

        jsonResponse = getJSON();

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        ArrayList<News> news = extractBooks(jsonResponse);

        // Return the list of {@link Earthquake}s
        return news;
    }

}
