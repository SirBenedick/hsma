package pr1.uebung03;
import static pr.MakeItSimple.*;

public class PalindromeNumber {

	public static void main(String[] args) {
		print("Beliebige Zahl zwischen 0-2Mrd. eingeben: ");
		int num = readInt();
		
		while (num<0) {
			print("Dein Zahl ist ungültig (0-2Mrd.): ");
			num = readInt();
		}
		
		int numLength = num;
		int numReverse = num;
		int numReversed = 0;
		int length = 0;
		//Länge bestimmen
		while(numLength>0){
			length++;
			numLength = numLength / 10;
			//println("numLength " + numLength);
		}
		//Zahl umkehren
		int i=0;
		while(i<length){

			numReversed = (numReversed * 10 + numReverse % (10)) ;
			numReverse = numReverse /10;
			
			i++;
			//println("numReverse " + numReverse);
			//println("numReversed " + numReversed);
			//blablatest
			
		}

		println(numReversed + " " + num);
		
		if(numReversed == num){
			println("Palindrom wurde erkannt!");
		}
		else{
			println("Es wurde kein Palindrom erkannt!");
		}
		
	}

}
