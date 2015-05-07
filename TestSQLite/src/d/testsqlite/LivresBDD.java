package d.testsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LivresBDD {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "eleves.db";
 
	private static final String TABLE_LIVRES = "table_livres";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_ISBN = "ISBN";
	private static final int NUM_COL_ISBN = 1;
	private static final String COL_TITRE = "Titre";
	private static final int NUM_COL_TITRE = 2;
 
	private SQLiteDatabase bdd;
 
	private MaBaseSQLite maBaseSQLite;
 
	public LivresBDD(Context context){
		maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertLivre(Livre livre){
		ContentValues values = new ContentValues();
		values.put(COL_ISBN, livre.getIsbn());
		values.put(COL_TITRE, livre.getTitre());
		return bdd.insert(TABLE_LIVRES, null, values);
	}
 
	public int updateLivre(int id, Livre livre){
		ContentValues values = new ContentValues();
		values.put(COL_ISBN, livre.getIsbn());
		values.put(COL_TITRE, livre.getTitre());
		return bdd.update(TABLE_LIVRES, values, COL_ID + " = " +id, null);
	}
 
	public int removeLivreWithID(int id){
		return bdd.delete(TABLE_LIVRES, COL_ID + " = " +id, null);
	}
 
	public Livre getLivreWithTitre(String titre){
		Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ISBN, COL_TITRE}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
		return cursorToLivre(c);
	}
 
	private Livre cursorToLivre(Cursor c){
		if (c.getCount() == 0)
			return null;
 
		c.moveToFirst();
		Livre livre = new Livre();
		livre.setId(c.getInt(NUM_COL_ID));
		livre.setIsbn(c.getString(NUM_COL_ISBN));
		livre.setTitre(c.getString(NUM_COL_TITRE));
		c.close();
 
		return livre;
	}
}
