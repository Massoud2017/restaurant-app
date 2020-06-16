/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.javain;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void sumbitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_view);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.notify_me_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        Log.v("MainActivity", "Has chocolate cream:" + hasChocolate );
        int price = calculatePrice();
        String priceMessage = createOrderSummary(name,price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);



    }
    public String createOrderSummary(String name,int price, boolean addedwhipcream, boolean addedchocolate)  {

        String priceMessage = "Name:" + name + "\n";
        priceMessage += "addedwhipcream: " + addedwhipcream + "\n ";
        priceMessage += "addedwhipcream: " + addedchocolate + "\n ";
        priceMessage += "Total: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    public void increment(View view) {

        quantity = quantity +1;
        displayQuantity(quantity);

    }
    public void decrement(View view) {

        quantity = quantity -1;
        displayQuantity(quantity);

    }
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}