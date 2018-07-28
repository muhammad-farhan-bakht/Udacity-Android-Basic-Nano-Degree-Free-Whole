package com.example.farhan.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Farhan on 1/7/2018.
 */

public class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {
    }

    public class HabitEntry implements BaseColumns {

        /** Name of database table for pets */
        public final static String TABLE_NAME = "habit_tracking";


        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Habit Name.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="habit";

        /**
         * Habit Comment.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_COMMENT = "comment";

        /**
         * Habit Date.
         *
         * Type: int
         */
        public final static String COLUMN_HABIT_DATE = "date";

    }
}
