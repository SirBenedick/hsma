package pr1.uebung03;

import static pr.MakeItSimple.*;

public class DividerArray {

	public static void main(String[] args) {
		
		print("Bitte geben Sie eine ganze Zahl ein: ");
		int num = readInt();
		
		int[] dividers = new int[35];
		
		if(num>0){
			int i = 1;
			int index = 0;
			
			while(i<=num){
				if((num % i) == 0){
					dividers[index] = i;
					index++;
				}
				i++;
			}
			print(num + " ist durch folgende Zahlen teilbar: ");
			index = 0;
			while(index<35){
				print(dividers[index] + " ");
				index++;
			}
			
		}
		else
			print("Ungültige Eingabe!");
		
	}

}
