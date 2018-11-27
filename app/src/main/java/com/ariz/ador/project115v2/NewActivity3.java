package com.ariz.ador.project115v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity3 extends AppCompatActivity {

    public static int quantity = 1 ;
    public static String billReceipt = "Null";
    public static int Price = 0 ;
    public static  String topping = "Order: ";

    CheckBox checkBox4, checkBox5, checkBox6;
    EditText editText, editText2, editText3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_activity3);
    }
    public void submitOrder(View view){

        Price = calculatePrice();
        editText = (EditText)findViewById(R.id.et_name);
        editText2 = (EditText)findViewById(R.id.et_add);
        editText3 = (EditText)findViewById(R.id.et_cont);


        checkBox4 = (CheckBox)findViewById(R.id.espresso);
        checkBox5 = (CheckBox)findViewById(R.id.mochiatto);
        checkBox6 = (CheckBox)findViewById(R.id.latte);

        String nameData = editText.getText().toString();
        String addData = editText2.getText().toString();
        String contData = editText3.getText().toString();

        boolean espresso = checkBox4.isChecked();
        boolean mochiatto  = checkBox5.isChecked();
        boolean latte  = checkBox6.isChecked();



        Log.v("MainActivity","espresso: " + espresso);
        Log.v("MainActivity","mochiatto: " + mochiatto);
        Log.v("MainActivity","latte: " + latte);


        if((checkBox4).isChecked()){
            topping = "Your Order is: " + espresso;
            Price = Price + 5*quantity ;
        }
        if((checkBox5).isChecked()){
            topping = "Your Order is:" + mochiatto;
            Price += 10*quantity ;
        }
        if((checkBox6).isChecked()){
            topping = "Your Order is: " + latte;
            Price += 15*quantity ;
        }



        displayQuantity(quantity);

        billReceipt =
                "Name :" + nameData  +
                        "\nAddress :" + addData +
                        "\nContact Number:" + contData +
                        "\nQuantity : "+ quantity;
        billReceipt += "\n"+ topping ;
        billReceipt += "\n"+ topping;
        billReceipt += "\nTo Pay :"  + Price;
        billReceipt += "\nThanks for Visiting ";

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
        TextView quantityText =(TextView)findViewById(R.id.txt_quantity);
        quantityText.setText("" + number);
    }

    /*..Display the current price ..*/

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.txt_price);
        priceTextView.setText(message);
    }

    /*..increase quantity by 1..*/

    public void  increment(View view ){
        quantity =quantity +1;
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

}

