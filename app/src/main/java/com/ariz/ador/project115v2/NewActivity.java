package com.ariz.ador.project115v2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class NewActivity extends Activity {
    ImageButton drink1, drink2, drink3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.new_activity);

        // Locate the button in activity_main.xml
        drink1 = (ImageButton) findViewById(R.id.frap_button);
        drink2 = (ImageButton) findViewById(R.id.iced_button);
        drink3 = (ImageButton) findViewById(R.id.hot_button);

        // Capture button clicks
        drink1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(NewActivity.this,
                        NewActivity2.class);
                startActivity(myIntent);
            }
        });

        drink2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(NewActivity.this,
                        NewActivity4.class);
                startActivity(myIntent);
            }
        });
        drink3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(NewActivity.this,
                        NewActivity3.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_activity, menu);
        return true;
    }
}




