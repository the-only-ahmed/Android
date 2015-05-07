package com.examplet.projecttestlist;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.ActionBar.OnNavigationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity{
		
	String[] actions = new String[] {
	        "Bookmark",
	        "Subscribe",
	        "Share"
	    };
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2" };

		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.label, values);
		setListAdapter(adapter);
		
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, actions);

    	getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
    	
	    ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
	
	        @Override
	        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
	        	return false;
	        }
	    };
	    getActionBar().setListNavigationCallbacks(adapter2, navigationListener);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
	        case R.id.action_add:
//	            composeChallenge();
	        	Toast.makeText(this, "add bar", Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
} 