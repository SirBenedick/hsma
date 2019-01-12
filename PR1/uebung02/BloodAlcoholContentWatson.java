package pr1.uebung02;

import static pr.MakeItSimple.*;

public class BloodAlcoholContentWatson {

	public static void main(String[] args) {
		println("Berechnung der Blutalkoholkonzentration nach Watson:");
		
		double GKWm = 0;
		double GKWw = 0;
		
		
		print("Bitte geben Sie die aufgenommene Menge an Alkohol in g an: ");
		double A = readDouble();
		print("Bitte geb den Gewicht in kg an: ");
		double m = readDouble();
		print("Bitte gebe deine Größe in cm an: ");
		double h = readDouble();
		print("Bitte gebe dein Alter an: ");
		double t = readDouble();
		print("Bitte gebe dein Geschlecht an (m/w): ");
		String sex = readString();
		
		if(sex.equals("m")){
			GKWm = 2.447 - 0.09516 * t + 0.1074 * h + 0.3362 * m;  
			double rm = (1.055 * GKWm) / (0.8 * m);
			println("Falls du männlich bist, beträgt dein Verteilungsfaktor: " + rm + " und dein Promillewert: " + (A / (m * rm)));
		}
		else if (sex.equals("w")){
			GKWw = -2.097 + 0.1069 * h + 0.2466 * m;
			double rw = (1.055 * GKWw) / (0.8 * m);
			println("Falls du weiblich bist, beträgt dein Verteilungsfaktor: " + rw + " und dein Promillewert: " + (A / (m * rw)));
		}
		else{
			print("Dein angegebenes Geschlecht gibt es nicht.");
		}
			
		
		
			
		
	}

}
