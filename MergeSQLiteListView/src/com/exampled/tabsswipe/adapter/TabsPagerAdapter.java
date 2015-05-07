package com.exampled.tabsswipe.adapter;

//import info.androidhive.tabsswipe.GamesFragment;
//import info.androidhive.tabsswipe.MoviesFragment;
//import info.androidhive.tabsswipe.TopRatedFragment;
import com.example.projecttestsqlite.Subject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
	private Subject sub;
	
    public TabsPagerAdapter(FragmentManager fm, Subject sub) {
        super(fm);
        this.sub = sub;
    }
 
    @Override
    public Fragment getItem(int index) {
 
    	
    	
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new LeftFragment(sub);
        case 1:
            // Games fragment activity
            return new CenterFragment(sub);
        case 2:
            // Movies fragment activity
            return new RightFragment(sub);
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}