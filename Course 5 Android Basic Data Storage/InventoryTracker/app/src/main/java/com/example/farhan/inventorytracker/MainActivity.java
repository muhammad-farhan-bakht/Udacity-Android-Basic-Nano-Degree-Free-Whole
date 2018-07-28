package com.example.farhan.inventorytracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farhan.inventorytracker.data.InventoryDbHelper;
import com.example.farhan.inventorytracker.data.InventoryItemListener;
import com.example.farhan.inventorytracker.data.InventoryModel;

public class MainActivity extends AppCompatActivity {
    InventoryDbHelper dbHelper;
    CustomCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new InventoryDbHelper(this);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        final ListView listView = findViewById(R.id.mListView);
        TextView emptyView = findViewById(R.id.emptyView);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.select();

        // Passing Values in Custom Cursor Adapter
        adapter = new CustomCursorAdapter(this, cursor, new InventoryItemListener() {
            @Override
            public void onClickSellImg(long id, int quantity) {
                dbHelper.sellOneItem(id, quantity);
                adapter.swapCursor(dbHelper.select());
            }
        });

        listView.setAdapter(adapter);

        // ListView OnClickItem Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("itemId", id);
                startActivity(intent);
            }
        });
    }

    // Refresh adapter when came back from other activity or when start's
    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.select());
    }

    // Create menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handel's menu Items on click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                // add dummy data for testing
                insertDummyData();
                adapter.swapCursor(dbHelper.select());
                return true;

            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                if (!adapter.isEmpty()) {
                    showDeleteConfirmationDialog();
                    adapter.swapCursor(dbHelper.select());
                } else {
                    Toast.makeText(this, "There are no products to delete", Toast.LENGTH_SHORT).show();
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Helper method to delete all pets in the database.
    private void insertDummyData() {
        InventoryModel inventoryModelObj = new InventoryModel(
                "Coca-Cola",
                45,
                "10 ",
                "The Coca-Cola Company",
                "+92 000 000 0000",
                "coca@cola.com",
                "android.resource://com.example.farhan.inventorytracker/drawable/cocacola");
        dbHelper.insertItem(inventoryModelObj);
    }
   //Show Dialog message on delete
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_message_all);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dbHelper.deleteAllItem();
                adapter.swapCursor(dbHelper.select());
                Toast.makeText(MainActivity.this, "Deleted All Products", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
