package com.example.farhan.booklisting;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Farhan on 12/7/2017.
 */

public final class QueryUtils {

    private QueryUtils() {
    }

    // This Method will call an HTTP request on the server and gets their JSON File
    private static String getJSON(String mUrl) {

        String jsonResponse = "";
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(mUrl);
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
    private static ArrayList<Books> extractBooks(String json) {

        String authorsList = null;

        ArrayList<Books> books = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(json);

            JSONArray jsonArray = jsonResponse.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookObject = jsonArray.getJSONObject(i);

                JSONObject bookInfo = bookObject.getJSONObject("volumeInfo");
                String title = bookInfo.getString("title");

                JSONArray authorsArray = bookInfo.getJSONArray("authors");

                for (int z = 0; z < authorsArray.length(); z++) {
                    if (z == 0) {
                        authorsList = authorsArray.getString(0);
                    } else {
                        authorsList += ", " + authorsArray.getString(z);
                    }
                }

                String bookPreviewLink = bookInfo.getString("previewLink");

                Books book = new Books(title, authorsList, bookPreviewLink);
                books.add(book);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }

    // This Method will Trigger all other method and will give us a list of Books
    public static ArrayList<Books> fetchEarthquakeData(String requestUrl) {

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;

        jsonResponse = getJSON(requestUrl);

        // Extract relevant fields from the JSON response and create a list of {@link Books}s
        ArrayList<Books> Books = extractBooks(jsonResponse);

        // Return the list of {@link Books}s
        return Books;
    }

}
