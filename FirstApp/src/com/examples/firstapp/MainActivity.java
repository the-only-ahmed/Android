package com.examples.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	RelativeLayout	layout = null;
	TextView		text = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
       
       text = (TextView)layout.findViewById(R.id.text);
       text.setText("Putain !");
       text.setTextSize(20);
       
       EditText edit = new EditText(this);
       edit.setLines(5);
       
       setContentView(layout);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}