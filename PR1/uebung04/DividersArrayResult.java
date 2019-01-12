package pr1.uebung04;

import static pr.MakeItSimple.*;

public class DividersArrayResult {

	static int[] calculateDividers(int num) {
		int[] dividers = new int[500];

		if (num > 0) {
			int i = 1;
			int index = 0;

			while (i <= num) {
				if ((num % i) == 0) {
					dividers[index] = i;
					index++;
				}
				i++;
			}
		}
		return dividers;
	}
	
	static boolean isPrime(int[] dividers, int num){
		
		if(dividers[0] == 1 && dividers[1] == num)
			return true;
		return false;
	}
	
	

	public static void main(String[] args) {

		print("Bitte geben Sie eine ganze Zahl ein: ");
		int num = readInt();
		if (num > 0) {

			int[] dividersMain = calculateDividers(num);

			print(num + " ist durch folgende Zahlen teilbar: ");
			int index = 0;
			while (index < 500 && dividersMain[index] != 0) {
				print(dividersMain[index] + " ");
				index++;
			}
			println();
			if(isPrime(dividersMain, num)){
				println("Die Zahl ist eine Primezahl!");
			}
			else{
				println("Die Zahl ist keine Primezahl.");
			}

		} 
		else
			println("Ungültige Eingabe");
	}
}