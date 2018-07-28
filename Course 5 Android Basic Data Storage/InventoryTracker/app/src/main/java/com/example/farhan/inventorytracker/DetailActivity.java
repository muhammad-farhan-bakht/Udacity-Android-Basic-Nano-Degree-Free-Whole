package com.example.farhan.inventorytracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farhan.inventorytracker.data.InventoryContract.InventoryEntry;
import com.example.farhan.inventorytracker.data.InventoryDbHelper;
import com.example.farhan.inventorytracker.data.InventoryModel;

public class DetailActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private int PICK_IMAGE = 1000;
    EditText productName;
    EditText productPrice;
    EditText productQuantity;
    EditText supplierName;
    EditText supplierPhone;
    EditText supplierEmail;
    ImageButton btnQuantityDecrease;
    ImageButton btnQuantityIncrease;
    TextView selectImageError;
    Button btnSelectProductImage;
    ImageView productImage;
    Uri selectedImgUri;
    long currentItemId = 0;
    Boolean unSavedStateChanged = false;
    InventoryDbHelper dbHelper;

    // implying that they are modifying the view, and we change the unSavedStateChanged boolean to true.
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            unSavedStateChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        productName = findViewById(R.id.et_Product_Name);
        productPrice = findViewById(R.id.et_Product_Price);
        productQuantity = findViewById(R.id.et_Product_Quantity);
        supplierName = findViewById(R.id.et_Supplier_Name);
        supplierPhone = findViewById(R.id.et_Supplier_Phone);
        supplierEmail = findViewById(R.id.et_Supplier_Email);
        selectImageError = findViewById(R.id.tv_Image_error);
        btnQuantityDecrease = findViewById(R.id.btn_Decrease_Quantity);
        btnQuantityIncrease = findViewById(R.id.btn_Increase_Quantity);
        btnSelectProductImage = findViewById(R.id.btn_Image_Picker);
        productImage = findViewById(R.id.image_view);

        dbHelper = new InventoryDbHelper(this);
        currentItemId = getIntent().getLongExtra("itemId", 0);

        if (currentItemId == 0) {
            setTitle(getString(R.string.add_new_item));
        } else {
            setTitle(getString(R.string.edit_item));
            getSelectedInfo(currentItemId);
        }

        productName.setOnTouchListener(mTouchListener);
        productPrice.setOnTouchListener(mTouchListener);
        productQuantity.setOnTouchListener(mTouchListener);
        supplierName.setOnTouchListener(mTouchListener);
        supplierPhone.setOnTouchListener(mTouchListener);
        supplierEmail.setOnTouchListener(mTouchListener);

        btnQuantityDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSavedStateChanged = true;
                String currentValue = productQuantity.getText().toString();
                int sub;
                if (currentValue.isEmpty()) {
                    return;
                } else if (currentValue.equals("1")) {
                    Toast.makeText(DetailActivity.this, "Cant Less Then 1 Quantity", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sub = Integer.parseInt(currentValue);
                    productQuantity.setText(String.valueOf(sub - 1));
                }
            }
        });

        btnQuantityIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unSavedStateChanged = true;
                String currentValue = productQuantity.getText().toString();
                int add;
                if (currentValue.isEmpty()) {
                    add = 0;
                } else {
                    add = Integer.parseInt(currentValue);
                }
                productQuantity.setText(String.valueOf(add + 1));
            }
        });

        btnSelectProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });
    }


    /**
     * set Validation on email EditText
     **/
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void insertData() {
        if (currentItemId == 0) {
            String itemName = productName.getText().toString().trim();
            int itemQuantity = Integer.parseInt(productQuantity.getText().toString().trim());
            String itemPrice = productPrice.getText().toString().trim();
            String itemSupplierName = supplierName.getText().toString().trim();
            String itemSupplierPhone = supplierPhone.getText().toString().trim();
            String itemSupplierEmail = supplierEmail.getText().toString().trim();
            String itemImage = null;

            if (selectedImgUri != null) {
                itemImage = selectedImgUri.toString();
            } else {
                selectImageError.setVisibility(View.VISIBLE);
            }

            if (!itemName.isEmpty() && !itemPrice.isEmpty() && itemQuantity >= 1 && !itemSupplierName.isEmpty() && !itemSupplierPhone.isEmpty() && isValidEmail(itemSupplierEmail) && !itemImage.isEmpty()) {

                InventoryModel imObj = new InventoryModel(itemName, itemQuantity, itemPrice, itemSupplierName, itemSupplierPhone, itemSupplierEmail, itemImage);

                if (currentItemId == 0) {
                    dbHelper.insertItem(imObj);
                    Toast.makeText(this, "Product Inserted Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }

            } else {
                if (itemName.isEmpty()) {
                    productName.setError("This Field Cant Be Empty");
                }
                if (itemPrice.isEmpty()) {
                    productPrice.setError("This Field Cant Be Empty");
                }
                if (itemSupplierName.isEmpty()) {
                    supplierName.setError("This Field Cant Be Empty");
                }
                if (itemSupplierPhone.isEmpty()) {
                    supplierPhone.setError("This Field Cant Be Empty");
                }
                if (!isValidEmail(itemSupplierEmail)) {
                    supplierEmail.setError("Email Format is not Valid");
                }
                if (itemName.isEmpty()) {
                    productName.setError("This Field Cant Be Empty");
                }
            }
        } else {
            int currentQuantity = Integer.parseInt(productQuantity.getText().toString().trim());
            dbHelper.updateItemById(currentItemId, currentQuantity);
            Toast.makeText(this, "Product Updated Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void getSelectedInfo(long currentItemId) {
        Cursor cursor = dbHelper.selectItemById(currentItemId);
        cursor.moveToFirst();
        productName.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_NAME)));
        productQuantity.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY)));
        productPrice.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE))+ "$");
        supplierName.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_NAME)));
        supplierPhone.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_PHONE)));
        supplierEmail.setText(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_EMAIL)));
        productImage.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(InventoryEntry.COLUMN_IMAGE))));

        productName.setEnabled(false);
        productPrice.setEnabled(false);
        supplierName.setEnabled(false);
        supplierPhone.setEnabled(false);
        supplierEmail.setEnabled(false);
        btnSelectProductImage.setVisibility(View.GONE);
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImage();
                    // permission was granted
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            selectedImgUri = data.getData();
            productImage.setImageURI(selectedImgUri);
            selectImageError.setVisibility(View.GONE);
        }
    }

    //This method is called when the back button is pressed.
    @Override
    public void onBackPressed() {
        // If the pet hasn't changed, continue with handling back button press
        if (!unSavedStateChanged) {
            super.onBackPressed();
            return;
        }

        // Otherwise if there are unsaved changes, setup a dialog to warn the user.
        // Create a click listener to handle the user confirming that changes should be discarded.
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (currentItemId == 0) {
            MenuItem deleteMenuItem = menu.findItem(R.id.action_delete);
            MenuItem orderMenuItem = menu.findItem(R.id.action_order);
            deleteMenuItem.setVisible(false);
            orderMenuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {

            // Respond to a click on the "Insert data" menu option
            case R.id.action_save:
                insertData();
                return true;

            // Respond to a click on the "Show Order Dialog" menu option
            case R.id.action_order:
                showOrderConfirmationDialog();
                return true;

            // Respond to a click on the "Delete Certain Product" menu option
            case R.id.action_delete:
                showDeleteConfirmationDialog();
                return true;

            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // If the pet hasn't changed, continue with navigating up to parent activity
                // which is the {@link CatalogActivity}.
                if (!unSavedStateChanged) {
                    NavUtils.navigateUpFromSameTask(DetailActivity.this);
                    return true;
                }

                // Otherwise if there are unsaved changes, setup a dialog to warn the user.
                // Create a click listener to handle the user confirming that
                // changes should be discarded.
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(DetailActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Show a dialog that warns the user there are unsaved changes that will be lost
    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_message);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dbHelper.deleteItemById(currentItemId);
                Toast.makeText(DetailActivity.this, "Product Deleted Successfully", Toast.LENGTH_SHORT).show();
                finish();
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

    private void showOrderConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.order_message);
        builder.setPositiveButton(R.string.phone, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // intent to phone
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + supplierPhone.getText().toString().trim()));
                startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.email, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // intent to email
                Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:" + supplierEmail.getText().toString().trim()));
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Recurrent new order");
                String bodyMessage = "Please send us as soon as possible more " +
                        productName.getText().toString().trim() +
                        "!!!";
                intent.putExtra(android.content.Intent.EXTRA_TEXT, bodyMessage);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
