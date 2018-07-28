package com.example.farhan.inventorytracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.farhan.inventorytracker.data.InventoryContract.InventoryEntry;


public class InventoryDbHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "inventory.db";
    private final static int DB_VERSION = 2;
    private final static String LOG_TAG = InventoryDbHelper.class.getCanonicalName();

    public InventoryDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " +
                InventoryEntry.TABLE_NAME + "(" +
                InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                InventoryEntry.COLUMN_NAME + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                InventoryEntry.COLUMN_PRICE + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 2, so there's nothing to do be done here.
    }
    
    public void insertItem(InventoryModel item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_NAME, item.getProductName());
        values.put(InventoryEntry.COLUMN_QUANTITY, item.getProductQuantity());
        values.put(InventoryEntry.COLUMN_PRICE, item.getProductPrice());
        values.put(InventoryEntry.COLUMN_SUPPLIER_NAME, item.getSupplierName());
        values.put(InventoryEntry.COLUMN_SUPPLIER_PHONE, item.getSupplierPhone());
        values.put(InventoryEntry.COLUMN_SUPPLIER_EMAIL, item.getSupplierEmail());
        values.put(InventoryEntry.COLUMN_IMAGE, item.getImage());
        db.insert(InventoryEntry.TABLE_NAME, null, values);
    }

    public Cursor select() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_NAME,
                InventoryEntry.COLUMN_QUANTITY,
                InventoryEntry.COLUMN_PRICE
        };
        Cursor cursor = db.query(
                InventoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor selectItemById(long itemId) {

        Cursor cursor;
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_NAME,
                InventoryEntry.COLUMN_QUANTITY,
                InventoryEntry.COLUMN_PRICE,
                InventoryEntry.COLUMN_SUPPLIER_NAME,
                InventoryEntry.COLUMN_SUPPLIER_PHONE,
                InventoryEntry.COLUMN_SUPPLIER_EMAIL,
                InventoryEntry.COLUMN_IMAGE
        };
        String selection = InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(itemId)};

        cursor = db.query(
                InventoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public void sellOneItem(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity - 1;
        }
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_QUANTITY, newQuantity);

        String selection = InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(itemId)};

        db.update(InventoryEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    public void updateItemById(long currentItemId, int currentQuantity) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_QUANTITY, currentQuantity);

        String selection = InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(currentItemId)};

        db.update(InventoryEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    public void deleteItemById(long itemId) {
        SQLiteDatabase database = getWritableDatabase();

        String selection = InventoryEntry._ID + "=?";
        String[] selectionArgs = { String.valueOf(itemId) };

        database.delete(InventoryEntry.TABLE_NAME, selection, selectionArgs);

    }

    public void deleteAllItem() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(InventoryEntry.TABLE_NAME, null, null);
    }
}
