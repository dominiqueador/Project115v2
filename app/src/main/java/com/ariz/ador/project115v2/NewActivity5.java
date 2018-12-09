package com.ariz.ador.project115v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewActivity5 extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity5);

        text = (TextView) findViewById(R.id.text);

        Intent intent = getIntent();
        String orderMessage = intent.getStringExtra("orderMessage");
        text.setText(orderMessage);
    }
}

