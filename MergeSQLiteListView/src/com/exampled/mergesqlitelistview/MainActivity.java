package com.exampled.mergesqlitelistview;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.ActionBar.OnNavigationListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectswipe2.MainAdapter;
import com.example.projecttestsqlite.AddSubject;
import com.example.projecttestsqlite.Subject;
import com.example.projecttestsqlite.SubjectDB;

public class MainActivity extends ListActivity {
		
	private	SubjectDB			sdb;
	private String[]			actions;
	private ArrayList<Subject>	subs;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		sdb = DataBase.onCreate(MainActivity.this);
		
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
				
		subs = DataBase.getSubjects(MainActivity.this, this);	   
		setActionBar(actionBar, this, subs, MainActivity.this);
		    	
	}
	
	public void setActionBar(ActionBar actionBar, Context v, final ArrayList<Subject> subs, final Context Mthis)
	{
		ArrayList<String> stock_list = DataBase.getCategory(subs, v);
		actions = new String[stock_list.size()];
		actions = stock_list.toArray(actions);
		
		if (actions == null)
			actions[0] = "Empty";
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(v, android.R.layout.simple_spinner_dropdown_item, actions);

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
	    ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
	    	
	        @Override
	        public boolean onNavigationItemSelected(int itemPosition, long itemId) {

	        	if (subs != null)
	        	{
	        		ArrayList<Subject> setted = DataBase.getSubjectsByCateg(Mthis, actions[itemPosition], subs);
	        		MyAdapter adapter = new MyAdapter(Mthis, setted);
	        		setListAdapter(adapter);
	        	}
	        	return true;
	        }

	    };
	   actionBar.setListNavigationCallbacks(adapter, navigationListener);
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		sdb.close();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Subject item = (Subject) getListAdapter().getItem(position);
		Intent intent = new Intent(MainActivity.this, MainAdapter.class);
		intent.putExtra("sub",JsonUtil.toJSon(item));
    	try {
    		startActivity(intent);
    	} catch (Exception e) {
    		Toast.makeText(MainActivity.this, "intent failed", Toast.LENGTH_SHORT).show();
    	}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
	        case R.id.action_add:
	        	Intent intent = new Intent(MainActivity.this, AddSubject.class);
	        	try {
	        		startActivity(intent);
	        	} catch (Exception e) {
	        		Toast.makeText(MainActivity.this, "intent failed", Toast.LENGTH_SHORT).show();
	        	}
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
}