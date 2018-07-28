package com.example.farhan.booklisting;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Books>> {

    /**
     * Constant value for the Books loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOKS_LOADER_ID = 1;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;

    View loadingIndicator;

    ArrayList<Books> booksArrayList;
    EditText etSearch;
    CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        // Hide loading indicator because the data has been loaded
        loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        booksArrayList = new ArrayList<>();

        etSearch = (EditText) findViewById(R.id.etSearch);

        ListView listView = (ListView) findViewById(R.id.mListView);
        customArrayAdapter = new CustomArrayAdapter(this, booksArrayList);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Books bookObj = customArrayAdapter.getItem(position);
                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri bookUri = Uri.parse(bookObj.getUrl());

                // Create a new intent to view the Books URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        Button searchBtn = (Button) findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadingIndicator.setVisibility(View.VISIBLE);

                // Get a reference to the ConnectivityManager to check state of network connectivity
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                // Get details on the currently active default data network
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                // If there is a network connection, fetch data
                if (networkInfo != null && networkInfo.isConnected()) {

                    // Get a reference to the LoaderManager, in order to interact with loaders.
                    LoaderManager loaderManager = getLoaderManager();

                    // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                    // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                    // because this activity implements the LoaderCallbacks interface).
                    if (loaderManager != null) {
                        loaderManager.restartLoader(BOOKS_LOADER_ID, null, MainActivity.this);
                    }
                } else {
                    // Update empty state with no connection error message
                    mEmptyStateTextView.setText(R.string.no_internet_connection);
                }
            }
        });
    }

    // Method to Search Books
    private String SearchedURL() {
        final String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=search+";
        String formatUserInput = etSearch.getText().toString().trim().replaceAll("\\s+", "+");
        String url = baseUrl + formatUserInput;
        return url;
    }

    @Override
    public Loader<List<Books>> onCreateLoader(int i, Bundle bundle) {

        String url = SearchedURL();

        return new BookLoader(this, url);

    }

    @Override
    public void onLoadFinished(Loader<List<Books>> loader, List<Books> books) {

        loadingIndicator.setVisibility(View.GONE);

        // Clear the adapter of previous Books data
        customArrayAdapter.clear();

        // If there is a valid list of {@link Books}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (books != null && !books.isEmpty()) {
            customArrayAdapter.addAll(books);
            customArrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Books>> loader) {
        // Loader reset, so we can clear out our existing data.
        customArrayAdapter.clear();
    }

}




