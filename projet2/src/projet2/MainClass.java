package projet2;

public class MainClass {

	//for(Ville v : tableau) => foreach (tableau as v)
	
	public static void main(String[] args)
	{

		Ville[] tableau = new Ville[6];

		String[] tab = {"Marseille", "lille", "caen", "lyon", "paris", "nantes"};
		int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};
		         

		for(int i = 0; i < 6; i++)
		{
			if (i < 3)
			{
				Ville V = new Ville(tab[i], "france", tab2[i]);
				tableau[i] = V;
			}     
			else
			{
				Capitale C = new Capitale(tab[i], "france", tab2[i], "la tour Eiffel");
				tableau[i] = C;
			}
		}
		                 
		for(Object obj : tableau) // => foreach (tableau as v)
		  System.out.println(obj+"\n");
	}
}
