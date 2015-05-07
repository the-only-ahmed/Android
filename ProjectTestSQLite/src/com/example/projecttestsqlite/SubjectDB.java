package com.example.projecttestsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SubjectDB {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "challenge.db";
 
	private static final String TABLE = "subject";
	private static final String COL_ID = "ID";
	private static final String COL_PSD = "Pseudo";
	private static final String COL_TITLE = "Title";
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
		values.put(COL_PSD, sub.getPseudo());
		values.put(COL_TITLE, sub.getTitle());
		values.put(COL_CONTENT, sub.getContent());
		return db.insert(TABLE, null, values);
	}
	
	public int removeSubjectWithID(int id)
	{
		return db.delete(TABLE, COL_ID + " = " + id, null);
	}
	
	public int removeSubjectWithPseudo(String pseudo)
	{
		return db.delete(TABLE, COL_PSD + " = " + pseudo, null);
	}
	
	public int removeSubjectWithTitle(String title)
	{
		return db.delete(TABLE, COL_TITLE + " = " + title, null);
	}
	
	public boolean getAllSubject(Context v)
	{
		Cursor c = db.query(TABLE, new String[] {COL_TITLE}, null, null, null, null, null);
		
		if (c.getCount() <= 0)
			return false;

		if (c.moveToFirst())
		{
			int i = 0;
		    while (!c.isAfterLast())
		    {
		        Toast.makeText(v, "TITLE["+i+"]=> "+c.getString(0), Toast.LENGTH_SHORT).show();
		        c.moveToNext();
		        i++;
		    }
		}
	    return true;
	}
}
