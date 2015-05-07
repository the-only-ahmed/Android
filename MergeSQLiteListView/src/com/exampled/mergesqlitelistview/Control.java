package com.exampled.mergesqlitelistview;

//import java.util.ArrayList;
//
//import com.example.projecttestsqlite.Subject;
//
//import android.widget.ArrayAdapter;
//import android.widget.Toast;
//import android.app.ActionBar;
//import android.app.ActionBar.OnNavigationListener;
//import android.content.Context;

public class Control extends MainActivity {
	
	
	public Control() {
		super();
	}
	
//	public void setActionBar(ActionBar actionBar, Context v, final ArrayList<Subject> subs, final Context Mthis)
//	{
//		ArrayList<String> stock_list = DataBase.getCategory(subs, v);
//		actions = new String[stock_list.size()];
//		actions = stock_list.toArray(actions);
//		
//		if (actions == null)
//			actions[0] = "Empty";
//		
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(v, android.R.layout.simple_spinner_dropdown_item, actions);
//
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//		
//	    ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
//	    	
//	        @Override
//	        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
//
//	        	if (subs != null)
//	        	{
//	        		ArrayList<Subject> setted = DataBase.getSubjectsByCateg(Mthis, actions[itemPosition], subs);
//	        		MyAdapter adapter = new MyAdapter(Mthis, setted);
//	        		setListAdapter(adapter);
//	        	}
//	        	return true;
//	        }
//
//	    };
//	   try {
//		   actionBar.setListNavigationCallbacks(adapter, navigationListener);
//	   } catch (Exception e) {
//		   Toast.makeText(Mthis, "set action bar", Toast.LENGTH_SHORT).show();
//	   }
//	}
}