package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

    int quantity = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whipped = (CheckBox) findViewById(R.id.Whipped_textbox);
        CheckBox choco = (CheckBox) findViewById(R.id.Chocolate_checkbox);

        Boolean whip = whipped.isChecked();
        Boolean choc = choco.isChecked();

        EditText Ordername = (EditText) findViewById(R.id.name);
        String name = Ordername.getText().toString();




        displayMessage(createOrderSummary(calculatePrice(),whip,choc,name));




        quantity = 0;
        displayQuantity(0);



    }


    public void incrementQuantity(View view) {

        displayMessage("$0.00");
        displayPrice(0);

        if (quantity < 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }



    public void decrementQuantity(View view) {
        displayPrice(0);
        quantity = quantity - 1;

        if (quantity >= 0) {
            displayQuantity(quantity);
        }
        else{
            displayQuantity(0);
            quantity = 0;
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice() {

        CheckBox whipped = (CheckBox) findViewById(R.id.Whipped_textbox);
        CheckBox choco = (CheckBox) findViewById(R.id.Chocolate_checkbox);

        int totalPrice = 5;
        if (whipped.isChecked()){
            totalPrice += 1;
        }
        if (choco.isChecked()){
            totalPrice += 2;
        }
        totalPrice *= quantity;

        return totalPrice;
    }



    /**
     * Create summary of the order.
     *
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants whipped chocolate topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price,Boolean hasWhippedCream, Boolean hasChocolate, String name) {


        String priceMessage = "";

        priceMessage += "Name:" + name;

        if (hasWhippedCream) {
            priceMessage += "\nAdded whipped cream";
        }

        if (hasChocolate) {
            priceMessage += "\nAdded chocolate";
        }

        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal : " + price;
        priceMessage += "\nThank you Broh!!";


        return priceMessage;
    }
}