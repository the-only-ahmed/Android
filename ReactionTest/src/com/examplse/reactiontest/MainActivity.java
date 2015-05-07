package com.examplse.reactiontest;

import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnTouchListener {
	private Button hello = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		hello = (Button) findViewById(R.id.bouton);
		hello.setOnTouchListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		float	x = event.getX();
		float	y = event.getY();
		Button	hello = (Button) v;
		float	size = (Math.abs(x - hello.getWidth() / 2) + Math.abs(y - hello.getHeight() / 2));
		
		hello.setTextSize(size);
		return true;
	}
}
