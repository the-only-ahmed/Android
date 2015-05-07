package com.exampled.tabsswipe.adapter;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.projecttestsqlite.Subject;
import com.exampled.mergesqlitelistview.R;

@SuppressLint("ValidFragment")
public class CenterFragment extends Fragment {
	
	protected Subject sub;
	
	public CenterFragment(Subject sub) {this.sub = sub;}
		
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.center_fragment, container, false);
         
        return rootView;
    }
	
}
