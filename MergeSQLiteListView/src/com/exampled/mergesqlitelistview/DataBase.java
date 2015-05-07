package com.exampled.mergesqlitelistview;

import java.util.ArrayList;

import org.json.JSONException;

import android.content.Context;
import android.database.SQLException;
import android.widget.Toast;

import com.example.projecttestsqlite.Subject;
import com.example.projecttestsqlite.SubjectDB;

public class DataBase {

	private static	SubjectDB	sdb;
	
	public static SubjectDB	getDb() {return sdb;}	
	
	public static SubjectDB onCreate(Context v)
	{
		sdb = new SubjectDB(v);
		openSDB();
//		sdb.removeAllSubjects(); // drop all once you leave the app
		return sdb;
	}
	
	public static void	openSDB()
	{
		try {
	 		sdb.open();
		}catch(SQLException sqle){
	 		throw sqle;
		}
	}
	
	public static ArrayList<Subject> getSubjects(Context v, Context that)
	{
		ArrayList<Subject> array = null;

		try {
			array = sdb.getAllSubject(v);
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(that, "JSON exception", Toast.LENGTH_SHORT).show();
		}
		
		if (array == null)
			return null;
		
		return array;
	}
	
	public static ArrayList<String> getCategory(ArrayList<Subject> subs, Context that)
	{
		ArrayList<String> tags = new ArrayList<String>();

		tags.add("All");
		for (Subject sub : subs)
		{
			try {
				String[] str = sub.getTags().split(" ");
				for (String s : str)
					tags.add(s);
			} catch (Exception e) {
				Toast.makeText(that, "get failed", Toast.LENGTH_LONG).show();
			}
		}
		
		if (tags.size() == 0)
			return null;
		
		ArrayList<String> tag = new ArrayList<String>();
		
		for (String str : tags)
		{
			if (!tag.contains(str))
				tag.add(str);
		}
		
		return tag;
	}

	public static ArrayList<Subject> getSubjectsByCateg(Context that, String cat, ArrayList<Subject> sub)
	{
		ArrayList<Subject> array = null;
		
		if (cat == "All")
			return sub;

		try {
			array = sdb.getSubjectByCat(that, cat, sub);
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(that, "JSON exception", Toast.LENGTH_SHORT).show();
		}
		
		if (array == null)
			return null;
		
		return array;
	}
	
}
