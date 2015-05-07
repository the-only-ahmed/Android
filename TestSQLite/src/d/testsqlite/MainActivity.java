package d.testsqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
        LivresBDD livreBdd = new LivresBDD(this);
 
        Livre livre = new Livre("123456789", "Programmez pour Android");
 
        livreBdd.open();
        livreBdd.insertLivre(livre);
 
        Livre livreFromBdd = livreBdd.getLivreWithTitre(livre.getTitre());
        if(livreFromBdd != null){
        	Toast.makeText(this, livreFromBdd.toString(), Toast.LENGTH_LONG).show();
        	livreFromBdd.setTitre("J'ai modifie le titre du livre");
            livreBdd.updateLivre(livreFromBdd.getId(), livreFromBdd);
        }
 
        livreFromBdd = livreBdd.getLivreWithTitre("J'ai modifie le titre du livre");
        if(livreFromBdd != null){
	        Toast.makeText(this, livreFromBdd.toString(), Toast.LENGTH_LONG).show();
	    	livreBdd.removeLivreWithID(livreFromBdd.getId());
        }
 
        livreFromBdd = livreBdd.getLivreWithTitre("J'ai modifie le titre du livre");
        if(livreFromBdd == null){
        	Toast.makeText(this, "Ce livre n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }
        else{
        	Toast.makeText(this, "Ce livre existe dans la BDD", Toast.LENGTH_LONG).show();
        }
 
        livreBdd.close();
    }
}
