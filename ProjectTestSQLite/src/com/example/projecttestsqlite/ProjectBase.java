package com.example.projecttestsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ProjectBase extends SQLiteOpenHelper {

	private static final String TABLE = "subject";
	private static final String COL_ID = "ID";
	private	static final String	COL_PSD = "Pseudo";
	private static final String COL_TITLE = "Title";
	private static final String COL_CONTENT = "Content";
	
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PSD + " TEXT NOT NULL, "
	+ COL_TITLE + " TEXT NOT NULL, " + COL_CONTENT + " TEXT NOT NULL);";
 
	public ProjectBase(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS " + TABLE + ";");
		onCreate(db);
	}
}
