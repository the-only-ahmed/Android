package com.exampled.projecttestswipe;

import com.exampled.projecttestswipe.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements SimpleGestureListener{
    
	private SimpleGestureFilter detector;
    private RelativeLayout layout = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        
        layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
        setContentView(layout);
        
        // Detect touched area 
        detector = new SimpleGestureFilter(this,this);
	}
  
	@Override
	public boolean dispatchTouchEvent(MotionEvent me)
	{
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
	
	private RelativeLayout changeLayout(String direction, RelativeLayout layout)
	{
		switch (direction)
		{
			case "left":
			{
				if (layout.getId() == R.id.main)
					layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_left, null);
				else if (layout.getId() == R.id.right)
					layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
				break;
			}
			case "right":
			{
				if (layout.getId() == R.id.main)
					layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_right, null);
				else if (layout.getId() == R.id.left)
					layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
				break;
			}
		}
		return layout;
	}
	
	@Override
	public void onSwipe(int direction)
	{
		switch (direction)
		{
			case SimpleGestureFilter.SWIPE_RIGHT : layout = changeLayout("right", layout);
	              break;
			case SimpleGestureFilter.SWIPE_LEFT :  layout = changeLayout("left", layout);
	              break;
		}
		setContentView(layout);
	}
	
	@Override
	public void onDoubleTap()
	{
		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	}
}
