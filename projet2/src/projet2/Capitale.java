package projet2;

public class Capitale extends Ville{

	private String	monument;
	
	public String	getMonument() {return this.monument;}
	
	public void		setMonument(String monument) {this.monument = monument;}
	
	public	Capitale()
	{
		super();
		this.monument = "aucun";
	}
	
	public	Capitale(String city, String country, int people, String monument)
	{
		super(city, country, people);
		this.monument = monument;
	}
	
	public String toString()
	{
		String str =  super.toString() + "\n \t ==>>" + this.monument+ " en est un monument";

	    System.out.println("Invocation de super.toString()");
	    
	    return str;
	}
}
