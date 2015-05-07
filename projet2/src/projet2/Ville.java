package projet2;

import java.util.Objects;

public class Ville {

	protected	String		nomVille;
	protected	String		nomPays;
	protected	int			nbHabitants;
	protected	char		categorie;
	protected	static int	nbVillep = 0;
	public		static int	nbVille = 0;
	
	public String		getVille() {return nomVille;}
	public String		getPays() {return nomPays;}
	public int			getHabitants() {return nbHabitants;}
	public char			getCategorie() {return categorie;}
	public static int	getNbVille() {return nbVillep;}
	
	public void setVille(String city) {nomVille = city;}
	public void setPays(String country) {nomPays = country;}
	public void setHabitants(int people)
	{
		nbHabitants = people;
		this.setCategorie();
	}
	
	public Ville()
	{
		nomVille = "Unknown";
		nomPays = "Unknown";
		nbHabitants = 0;
		nbVille++;
		nbVillep++;
		this.setCategorie();
		System.out.println("Creation d'une ville !!!");
	}
	
	public Ville(String city, String country, int people)
	{
		nomVille = city;
		nomPays = country;
		nbHabitants = people;
		nbVille++;
		nbVillep++;
		this.setCategorie();
		System.out.println("Creation de "+ nomVille +" !!!");
	}
	
	private void setCategorie()
	{
		int	bornSup[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 1000000};
		char cat[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	
		int	i = 0;
		while (i < bornSup.length && nbHabitants > bornSup[i])
			i++;
		categorie = cat[i];
	}
	
	public String toString()
	{
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbHabitants+" habitant(s) => elle est donc de categorie : "+this.categorie;
	}
	
	public String comparer(Ville v1)
	{
	    String str = new String();

	    if (v1.getHabitants() > this.nbHabitants)
	      str = v1.getVille()+" est une ville plus peuplee que "+this.nomVille;
	     
	    else
	      str = this.nomVille+" est une ville plus peuplee que "+v1.getVille();
	     
	    return str;
	  }
	
	public int hashCode()
	{
		return Objects.hash(categorie, nbHabitants, nomVille, nomPays);
	}


	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;

		if (getClass() != obj.getClass())
			return false;
			
		Ville other = (Ville) obj;

		return Objects.equals(other.getCategorie(), this.getCategorie()) &&
				Objects.equals(other.getPays(), this.getPays()) &&
				Objects.equals(other.getHabitants(), this.getHabitants()) &&
				Objects.equals(other.getPays(), this.getPays());
	}
}
