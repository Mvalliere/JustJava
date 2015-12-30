package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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



        CheckBox whipped = (CheckBox) findViewById(R.id.Whipped);
        Boolean whip = whipped.isChecked();
 //       Log.i("MainActivity",whip.toString());




        displayMessage(createOrderSummary(calculatePrice(),whip));




        quantity = 0;
        displayQuantity(0);



    }


    public void incrementQuantity(View view) {

        displayMessage("$0.00");


        displayPrice(0);
        quantity = quantity + 1;
        displayQuantity(quantity);
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
        int price = quantity * 5;

        return price;
    }


    private String createOrderSummary(int price,Boolean hasWhippedCream){

        String Whipped = "";
        if (hasWhippedCream){
            Whipped = "\nAdded whipped cream";
        }



        return "Name: Mark V."+
                Whipped +
                "\nQuantity: " +
                quantity +
                "\nTotal :"
                + price +
                "\nThank you broh!";
    }
}