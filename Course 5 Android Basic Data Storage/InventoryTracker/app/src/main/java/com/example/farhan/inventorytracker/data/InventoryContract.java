package com.example.farhan.inventorytracker.data;

import android.provider.BaseColumns;

/**
 * Created by Farhan on 1/11/2018.
 */

public class InventoryContract {

    private InventoryContract() {
    }

    public static final class InventoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "Inventory";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";
        public static final String COLUMN_IMAGE = "image";
    }
}
