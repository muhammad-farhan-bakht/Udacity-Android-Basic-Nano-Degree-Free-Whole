package com.example.farhan.inventorytracker;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farhan.inventorytracker.data.InventoryContract.InventoryEntry;
import com.example.farhan.inventorytracker.data.InventoryItemListener;


public class CustomCursorAdapter extends CursorAdapter {

    private InventoryItemListener sellListener;

    public CustomCursorAdapter(Context context, Cursor c, InventoryItemListener sellListener) {
        super(context, c);
        this.sellListener = sellListener;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_view, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tvName = view.findViewById(R.id.item_Name);
        TextView tvQuantity = view.findViewById(R.id.item_Quantity);
        TextView tvPrice = view.findViewById(R.id.item_Price);
        ImageView sellImgView = view.findViewById(R.id.item_Sell);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE);

        // Read the Inventory attributes from the Cursor for the current Item
        String productName = cursor.getString(nameColumnIndex);
        final int productQuantity = cursor.getInt(quantityColumnIndex);
        String productPrice = cursor.getString(priceColumnIndex);

        // Update the TextViews with the attributes for the current Item
        tvName.setText(productName);
        tvQuantity.setText(String.valueOf(productQuantity));
        tvPrice.setText(productPrice + "$");

        final long id = cursor.getLong(cursor.getColumnIndex(InventoryEntry._ID));

        sellImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellListener.onClickSellImg(id , productQuantity);
            }
        });
    }
}
