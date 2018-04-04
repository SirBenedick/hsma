package pr1.uebung02;

import static pr.MakeItSimple.*;

public class BloodAlcoholContentJohannes {

	public static void main(String[] args) {
		
		/* Version: Johannes */
		
		double r = 0;
		println("Berechnung der Blutalkoholkonzentration:");
		print("Bitte geben Sie die aufegneommene Menge an Alkohol in g an: ");
		double A = readDouble();
		print("Bitte geb den Gewicht in kg an: ");
		double m = readDouble();
		print("Bitte gebe dein Geschlecht an (m/w): ");
		String sex = readString();
		
		if (sex.equals("m") || sex.equals("M")){
			r = 0.7;
			println("Du bist männlich, daher ist dein Verteilungsfaktor: " + r + " und dein Promillewert beträgt: " + (A / (m * r)));
		}
		else if (sex.equals("w") || sex.equals("W")){
			r = 0.6;
			println("Du bist weiblich, daher ist dein Verteilungsfaktor: " + r + " und dein Promillewert beträgt: " + (A / (m * r)));
		}
		else
			print("Dein Eingabe des Geschlechts war ungültig.");

	}

}
