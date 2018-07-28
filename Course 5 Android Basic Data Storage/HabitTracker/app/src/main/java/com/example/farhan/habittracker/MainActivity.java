package com.example.farhan.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.farhan.habittracker.HabitContract.HabitEntry;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    HabitDbHelper habitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Object of DbHelper Class
        habitDbHelper = new HabitDbHelper(this);

        /*// Get current Date from the system
        long date = System.currentTimeMillis();
        //Choose the format of date
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd");
        String dateString = sdf.format(date);
        int dateInt = Integer.parseInt(dateString);*/

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

        habitDbHelper.insertHabit("Coding", "Making an 9th Udacity Android Project", dateInt);

        habitDbHelper.insertHabit("Android" , "Making an Android Project", dateInt);
        displayDatabaseInfo();

    }

    private void displayDatabaseInfo() {
        Cursor cursor = habitDbHelper.readHabits();
        try {

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int commentColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_COMMENT);
            int dateColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DATE);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentBreed = cursor.getString(commentColumnIndex);
                int currentGender = cursor.getInt(dateColumnIndex);

                // Display the values from each column of the current row in the cursor in the Log
                Log.v(TAG, "habit: " + currentID + " " + currentName + " " + currentBreed + " " + currentGender + "\n");

            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

}
