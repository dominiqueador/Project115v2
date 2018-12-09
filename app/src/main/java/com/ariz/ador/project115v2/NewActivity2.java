package com.ariz.ador.project115v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;

public class NewActivity2 extends AppCompatActivity {

    public static int quantity = 0 ;
    public static String billReceipt = "Null";
    public static int Price = 0 ;
    public static String topping = "";
    public static String loc = "";


    CheckBox checkBox, checkBox2, checkBox3;
    EditText editText, editText3;
    RadioButton r1, r2, r3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity2.xml
        setContentView(R.layout.new_activity2);

    }
    public void submitOrder(View view){

        Price = calculatePrice();
        editText = (EditText)findViewById(R.id.et_name);
        editText3 = (EditText)findViewById(R.id.et_cont);

        String nameData = editText.getText().toString();
        String contData = editText3.getText().toString();


        checkBox = (CheckBox)findViewById(R.id.strawfrap);
        checkBox2 = (CheckBox)findViewById(R.id.javacfrap);
        checkBox3 = (CheckBox)findViewById(R.id.oreofrap);

        r1 = (RadioButton) findViewById(R.id.dapitan);
        r2 = (RadioButton) findViewById(R.id.noval);
        r3 = (RadioButton) findViewById(R.id.espana);



        boolean strawfrap = checkBox.isChecked();
        boolean javacfrap  = checkBox2.isChecked();
        boolean oreofrap  = checkBox3.isChecked();
        boolean dapitan = r1.isChecked();
        boolean noval  = r2.isChecked();
        boolean espana  = r3.isChecked();


        Log.v("MainActivity","strawfrap: " + strawfrap);
        Log.v("MainActivity","javacfrap: " + javacfrap);
        Log.v("MainActivity","strawfrap: " + oreofrap);

        Log.v("MainActivity","dapitan: " + dapitan);
        Log.v("MainActivity","noval: " + noval);
        Log.v("MainActivity","espana: " + espana);


        if((checkBox).isChecked()){
            topping += checkBox.getText();
            Price = Price + 5*quantity ;

        }
        if((checkBox2).isChecked()){
            topping += checkBox2.getText();
            Price += 10*quantity ;
        }
        if((checkBox3).isChecked()){
           topping += checkBox3.getText();
           Price += 15*quantity ;
        }

        if (r1.isChecked()) {
            loc += r1.getText().toString();
        }
        if (r2.isChecked()) {
            loc += r2.getText().toString();
        }
        if (r3.isChecked()) {
            loc += r3.getText().toString();
        }

        displayQuantity(quantity);

       billReceipt =    "Name :" + nameData +
                        "\nContact Number:" + contData +
                        "\nQuantity : " + quantity;
       billReceipt +=   "\nYour order is : " + topping;
       billReceipt +=   "\nPick Up Location : " + loc;
       billReceipt +=   "\nTo Pay :"  + Price;
       billReceipt +=   "\n\n\n\nIf you are sure of your orders. Please click Submit Order. Thank you.";

       displayMessage(billReceipt);



    }
    /**..calculate price of order
     *
     *@return total price
     * */

    private int calculatePrice(){
        int Price = quantity*20;
        return Price;
    }

    /*...Display the price of set quantity..*/

    public void displayQuantity(int number ){
        TextView quantityText = (TextView) findViewById(R.id.txt_quantity);
        quantityText.setText("" + number);
    }

    /*..Display the current price ..*/

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.txt_price);
        priceTextView.setText(message);
    }

    /*..increase quantity by 1..*/

    public void  increment(View view ){
        quantity = quantity +1;
        displayQuantity(quantity);

    }
    /*..decrease quantity by 1..*/

    public void  decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    public void finalOrder(View view){
        String nameData = editText.getText().toString();
        String contData = editText3.getText().toString();

        String orderMessage = "Hey, " + nameData + "!" + "\n\nWe have received your order. Kindly present this receipt to receive your order. \n\n" +
                "Here is your Order details: " +
                "\nCustomer Name : " + nameData +
                "\nContact Number : " + contData +
                "\nItem : " + topping +
                "\nQuantity : " + quantity +
                "\nPick Up Location : " + loc +
                "\nAmount Due : " + Price ;

        Intent order = new Intent(this, NewActivity5.class);
        order.putExtra("orderMessage", orderMessage);

        startActivity(order);

    }

}

