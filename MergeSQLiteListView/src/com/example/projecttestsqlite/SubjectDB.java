package com.example.projecttestsqlite;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.exampled.mergesqlitelistview.JsonUtil;

public class SubjectDB {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "challenge.db";
 
	private static final String TABLE = "subject";
	private static final String COL_ID = "ID";
	private static final String COL_CONTENT = "Content";
 
 
	private SQLiteDatabase db;
 
	private ProjectBase myBase;
	
	public SubjectDB(Context context)
	{
		myBase = new ProjectBase(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open()
	{
		db = myBase.getWritableDatabase();
	}
 
	public void close()
	{
		db.close();
	}
 
	public SQLiteDatabase getDB()
	{
		return db;
	}
	
	public long insertSubject(Subject sub, Context v)
	{
		ContentValues values = new ContentValues();
		values.put(COL_CONTENT, JsonUtil.toJSon(sub));
		return db.insert(TABLE, null, values);
	}
	
	public int removeSubjectWithID(int id)
	{
		return db.delete(TABLE, COL_ID + " = " + id, null);
	}
	
	public int removeAllSubjects()
	{
		return db.delete(TABLE, null, null);
	}
	
	public ArrayList<Subject> getAllSubject(Context v) throws JSONException
	{
		Cursor c = db.query(TABLE, new String[] {COL_CONTENT}, null, null, null, null, null);
		ArrayList<Subject> array = new ArrayList<Subject>();
		
		if (c.getCount() <= 0)
			return null;
		
		if (c.moveToFirst())
		{
		    while (!c.isAfterLast())
		    {
		    	JSONObject jObj = new JSONObject(c.getString(0));
		    	String pseudo = jObj.getString("pseudo");
		    	String title = jObj.getString("title");
		    	String content = jObj.getString("content");		    	
	    		String tags = jObj.getString("category");

	    		array.add(new Subject(pseudo, title, content, tags));
		    	c.moveToNext();
		    }
		}
	    return array;
	}
	
	public ArrayList<Subject> getSubjectByCat(Context v, String cat, ArrayList<Subject> subs) throws JSONException
	{
		if ((subs == null) || (cat == "All"))
			return subs;
		
		ArrayList<Subject> array = new ArrayList<Subject>();
		for (Subject sub : subs)
		{
			try {
				String[] str = sub.getTags().split(" ");
				for (String s : str)
				{
					if (s.equals(cat))
					{
						array.add(sub);
						break;
					}
				}
			} catch (Exception e) {
				Toast.makeText(v, "get failed", Toast.LENGTH_LONG).show();
			}
		}
		return array;
	}
}
