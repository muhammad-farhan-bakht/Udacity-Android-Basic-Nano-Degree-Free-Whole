package com.example.farhan.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.farhan.habittracker.HabitContract.HabitEntry;

/**
 * Created by Farhan on 1/7/2018.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    // dataBase name
    private static final String DATABASE_NAME = "habitTracker.db";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " STRING NOT NULL, "
                + HabitEntry.COLUMN_HABIT_COMMENT + " STRING, "
                + HabitEntry.COLUMN_HABIT_DATE + " DATE); ";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Method to Insert
    public void insertHabit(String habitName, String comment, int date) {

        // Get Writable database
        SQLiteDatabase db = getWritableDatabase();

        // Creating ContentValue Object
        ContentValues values = new ContentValues();

        // get data from parameters and add then into ContentValue Object
        values.put(HabitEntry.COLUMN_HABIT_NAME, habitName);
        values.put(HabitEntry.COLUMN_HABIT_COMMENT, comment);
        values.put(HabitEntry.COLUMN_HABIT_DATE, date);

        // insert into Table
        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    // Method to Select
    public Cursor readHabits() {

        // get Readable database
        SQLiteDatabase db = getReadableDatabase();

        // Select the values which we want to get from the table
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_COMMENT,
                HabitEntry.COLUMN_HABIT_DATE
        };
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
