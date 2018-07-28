/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.farhan.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            //Show an error message
            Toast.makeText(this, "You cannot have more then 100 coffee", Toast.LENGTH_SHORT).show();
            //Exiting this method early because there is nothing left to do
            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            //Show an error message
            Toast.makeText(this, "You cannot have less then 1 coffee", Toast.LENGTH_SHORT).show();
            //Exiting this method early because there is nothing left to do
            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Figure out if the user want whipped cream topping or not
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user want chocolate topping or not
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        //Calculate the price
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummery(name, price, hasWhippedCream, hasChocolate);

        // Figure out if the user want Subject on java app or via email
        CheckBox intentCheckBox = (CheckBox) findViewById(R.id.check_intents);
        boolean hasIntent = intentCheckBox.isChecked();

        // If user Want to Order via Emial
        if (hasIntent) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name));
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            // If user Want to Order With in the app
        } else {
            displayMessage(priceMessage);
        }

    }

    /**
     * @param addChocolate    to check if user want or not
     * @param addWhippedCream to check the user want or not
     *                        Calculates the price of the order.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        // Price of 1 cup of Coffee
        int basePrice = 5;

        // add 1$ if user want Whipped Cream
        if (addWhippedCream) {
            basePrice += 1;
        }

        // add 2$ if user want Chocolate
        if (addChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;

    }

    /**
     * Create Summery of Order
     *
     * @param price           of the Order
     * @param addWhippedCream is to check the user want or not
     * @param addChocolate    is to check the user want or not
     * @param name            to show the name of user who input in EditText
     */
    private String createOrderSummery(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\n" + getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n" + getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n" + getString(R.string.thank_you);

        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
        orderSummeryTextView.setText(message);
    }


}