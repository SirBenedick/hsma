package pr1.uebung05;

import static pr.MakeItSimple.*;

public class SieveOfEratosthenes {

	static boolean[] calculatePrimes(int n) {
		boolean[] primeArray = new boolean[n + 1];
		
		/* Alle Werte auf true setzten, dann alle Nicht-Primzahlen false
		   Beginnen bei 2, damit 0 und 1 false bleibt */
		int position = 2;
		while (position <= n) {
			primeArray[position] = true;
			if (primeArray[position] == true)
				position++;
		}
		
		int prime = 2;
		while (prime <= n) {
			// nur alle wichtigen Multiplikationen

			if (primeArray[prime]) {
				for (int i = 2; i * prime <= n; i++) {
					primeArray[prime * i] = false;
				}
			}
			prime++;
		}
		return primeArray;
	}

	public static void main(String[] args) {
		print("Bitte geben Sie eine Zahl ein, bis zu der alle Primzahlen gesucht werden sollen: ");
		int n = readInt();
		boolean[] primeArray;
		if (n < 2)
			throw new PRException("Dein Zahl darf nicht kleiner 2 sein");
		else {

			primeArray = calculatePrimes(n);
		}

//		 Testausgabe für das ganze Array			
//		 for(int j = 0; j<n; j++ ){
//		 if(primeArray[j] == true)
//		 print("t" + j);
//		 else
//		 print("f" + j);
//		 print(" ");
//		 }
		 
		 //Ausgabe der Primzahlen
		 println("Bis zu " + n + " gibt es folgende Primzahlen: ");
		for (int j = 0; j <= n; j++) {
			if (primeArray[j] == true)
				print(j + " ");
		}
		
	}

}
	