package projet1;

import java.util.Scanner;

public class sdz1
{
	/*
	//String.valueOf(x) transforme x en string

	//Integer.valueOf(String x).IntValue() donne la valeur entiere de la chaine x

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		String str = sc.nextLine();
		//int str = sc.nextInt();
		char c = str.charAt(0);
		System.out.println("Vous avez taper : " + c);
	}
	*/

	public static void tempCalc(int x, float temp)
	{
		float res;

		if (x == 1)
		{
			res = temp * 9 / 5 + 32;
			System.out.println(temp + " C Correspond a " + res + " F");
		}
		else
		{
			res = (temp - 32) * 5 / 9;
			System.out.println(temp + " F Correspond a " + res + " C");
		}
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Scanner sci = new Scanner(System.in);
		int x;
		char c;
		float temp;

		do {
			do {
				System.out.println("Choisissez le mode de Conversion :");
				System.out.println("1- Convertisseur Celsus - Fahrenheit");
				System.out.println("2- Convertisseur Fahrenheit - Celsus");
				x = sc.nextInt();
			} while (x != 1 && x != 2);

			System.out.println("Temperature a convertir :");
			temp = sc.nextFloat();
			tempCalc(x, temp);
			
			do {
				System.out.println("Souhaiter-vous convertir une autre Temperature [O/N] ?");
				String str = sci.nextLine();
				c = str.charAt(0);
			} while (c != 'O' && c != 'N');

		} while (c != 'N');
		System.out.println("Au revoir !");
		sc.close();
		sci.close();
	}
}
