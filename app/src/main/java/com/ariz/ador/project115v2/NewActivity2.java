package com.ariz.ador.project115v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity2 extends AppCompatActivity {

    public static int quantity = 1 ;
    public static String billReceipt = "Null";
    public static int Price = 0 ;
    public static  String topping = "Order: ";

    CheckBox checkBox, checkBox2, checkBox3;
    EditText editText, editText2, editText3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity2.xml
        setContentView(R.layout.new_activity2);
    }
    public void submitOrder(View view){

        Price = calculatePrice();
        editText = (EditText)findViewById(R.id.et_name);
        editText2 = (EditText)findViewById(R.id.et_add);
        editText3 = (EditText)findViewById(R.id.et_cont);


        checkBox = (CheckBox)findViewById(R.id.strawfrap);
        checkBox2 = (CheckBox)findViewById(R.id.javacfrap);
        checkBox3 = (CheckBox)findViewById(R.id.oreofrap);

        String nameData = editText.getText().toString();
        String addData = editText2.getText().toString();
        String contData = editText3.getText().toString();

        boolean strawfrap = checkBox.isChecked();
        boolean javacfrap  = checkBox2.isChecked();
        boolean oreofrap  = checkBox3.isChecked();



        Log.v("MainActivity","strawfrap: " + strawfrap);
        Log.v("MainActivity","javacfrap: " + javacfrap);
        Log.v("MainActivity","strawfrap: " + oreofrap);


        if((checkBox).isChecked()){
            topping = "Your Order is: " + strawfrap;
            Price = Price + 5*quantity ;
        }
        if((checkBox2).isChecked()){
            topping = "Your Order is:" + javacfrap;
            Price += 10*quantity ;
        }
        if((checkBox3).isChecked()){
            topping = "Your Order is: " + oreofrap;
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

