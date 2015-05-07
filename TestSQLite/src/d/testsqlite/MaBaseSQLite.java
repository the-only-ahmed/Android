package d.testsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQLite extends SQLiteOpenHelper {

	private static final String TABLE_LIVRES = "table_livres";
	private static final String COL_ID = "ID";
	private static final String COL_ISBN = "ISBN";
	private static final String COL_TITRE = "Titre";
 
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_LIVRES + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ISBN + " TEXT NOT NULL, "
	+ COL_TITRE + " TEXT NOT NULL);";
 
	public MaBaseSQLite(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version); // apelle le constructeur de la classe mere [SQLiteOpenHelper]
	}
 
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_BDD); // creation de la table a partir de la requete ecrite dans CREATE_BDD
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) // supression et recreation de la base pour que tt repart a 0 quand on change de version 
	{
		db.execSQL("DROP TABLE " + TABLE_LIVRES + ";");
		onCreate(db);
	}
}
