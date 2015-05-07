package com.example.projectswipe2;

import org.json.JSONObject;

import android.app.ActionBar.TabListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.projecttestsqlite.Subject;
import com.exampled.mergesqlitelistview.R;
import com.exampled.tabsswipe.adapter.TabsPagerAdapter;


public class MainAdapter extends FragmentActivity implements TabListener {

	private ViewPager				viewPager;
    private TabsPagerAdapter		mAdapter;
    private android.app.ActionBar	actionBar;
    private Subject					sub;
    
    // Tab titles
    private String[] tabs = { "Description", "Participants", "Answers" };
 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_main);
 
        // Initilization
        Intent intent = getIntent(); // gets the previously created intent
        String json = intent.getStringExtra("sub");

        try {
        	JSONObject jObj = new JSONObject(json);
        	String pseudo = jObj.getString("pseudo");
        	String title = jObj.getString("title");
        	String content = jObj.getString("content");		    	
        	String tags = jObj.getString("category");
        	
        	sub = new Subject(pseudo, title, content, tags);
        } catch (Exception e) {
        	Toast.makeText(MainAdapter.this, "Json failed", Toast.LENGTH_SHORT).show();
        }
        
        setTitle(sub.getTitle());
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager(), sub);
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs)
        {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
         
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
         
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        
    }

	@Override
	public void onTabSelected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
		
		// on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
	}


	@Override
	public void onTabUnselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabReselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
