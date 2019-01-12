package pr1.uebung03;

import static pr.MakeItSimple.*;

public class Dividers {

	public static void main(String[] args) {
		
		print("Bitte geben Sie eine ganze Zahl ein: ");
		int num = readInt();
		if(num>0){
			int i = num - 1;
			print(num + " ist durch folgende Zahlen teilbar: ");
			while(i<=num){
				if((num % i) == 0){
					print(i + " ");
					break;
				}
				i = i - 1;
			}
		}
		else
			print("Ungültige Eingabe!");
		
	}

}
