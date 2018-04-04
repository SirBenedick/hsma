package pr1.uebung02;

import static pr.MakeItSimple.*;

public class BmiCalculator {

	public static void main(String[] args) {
		double g = 0;
		double h = 0;
		double BMI;
		
		print("Bitte geben Sie Ihr Gewicht in kg an (30-300kg):");
		g = readDouble();
		while (g < 30 || g > 300) {
			print("Dein Angabe ist ungültig wdh. bitte: ");
			g = readDouble();
		}
		
		
		
		print("Bitte geben Sie Ihre Größe in m an (1.20-2.50m):");
		h = readDouble();
		
		while (h < 1.20 || h > 2.50) {
			print("Dein Angabe ist ungültig wdh. bitte: ");
			h = readDouble();
		}
		
		BMI = g / (h * h);
		//println("Dein BMI beträgt: " + BMI);
		
		print("Bitte geben Sie ihr Geschlecht an (m/w)");
		String sex = readString();
		
		while(!(sex.equals("m")) && !(sex.equals("w"))){
			print("Bitte wiederhole deine Eingabe (m/w): ");
			sex = readString();
		}
		
		if (sex.equals("m")) {
			if (BMI <= 20)
				println("Dein BMI ist zu gering, er beträgt: " + BMI);
			else if (BMI >= 25)
				println("Dein BMI ist zu hoch, er beträgt: " + BMI);
			else
				println("Dein BMI ist normal, er beträgt: " + BMI);
		} 
		
		else if (sex.equals("w")) {
			if (BMI <= 19)
				println("Dein BMI ist zu gering, er beträgt: " + BMI);
			else if (BMI >= 24)
				println("Dein BMI ist zu hoch, er beträgt: " + BMI);
			else
				println("Dein BMI ist normal, er beträgt: " + BMI);
		}
		
		

	}

}
