package com.exampled.tabsswipe.adapter;

import com.example.projecttestsqlite.Subject;
import com.exampled.mergesqlitelistview.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class RightFragment extends Fragment {

	protected Subject sub;
	
	public RightFragment(Subject sub) {this.sub = sub;}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.right_fragment, container, false);
         
        return rootView;
    }
}
