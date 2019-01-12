package pr1.uebung02;

import static pr.MakeItSimple.*;

public class BloodAlcoholContent {

	public static void main(String[] args) {
		println("Berechnung der Blutalkoholkonzentration:");
		print("Bitte geben Sie die aufegneommene Menge an Alkohol in g an: ");
		double A = readDouble(); //Eingabe der aufgenommenen Alkoholmenge in g
		print("Bitte geb den Gewicht in kg an: ");
		double m = readDouble(); //Gewicht wird in kg eingelesen
		double r1 = 0.7;//Reduktionsfaktor für den Mann
		double r2 = 0.6;//Reduktionsfaktor für die Frau
		print("Bitte gebe dein Geschlecht an (m/w): ");
		String sex = readString();
		//Es folgt eine Abfrage des Geschlechts mit entsprechnedem Reduktionsfaktors
		if(sex.equals("m") || sex.equals("M") ){
			println("Mit einem Verteilungsfaktor von: " + r1 + " beträgt der Promillewert: " + (A / (m * r1)));
		}
		else if (sex.equals("w") || sex.equals("W") ){
			println("Mit einem Verteilungsfaktor von: " + r2 + " beträgt der Promillewert: " + (A / (m * r2)));
		}
		else{
			print("Dein angegebenes Geschlecht gibt es nicht.");
		}
		
	}

}
//Benedict Kruse