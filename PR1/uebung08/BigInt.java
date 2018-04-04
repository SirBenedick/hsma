package pr1.uebung08;
import static pr.MakeItSimple.*;

public class BigInt {
	private int[] numberArray;
	
	BigInt(String Zahl){
//		Prüfen ob der String nur aus 0-9 besteht
		boolean isNatural = true;
		boolean isZero = false;
		for (int i=0;i<Zahl.length();i++ ){
			if(('0'>Zahl.charAt(i)) || (Zahl.charAt(i) > '9'))
				isNatural = false;
			if(Zahl.charAt(i) == '0')
				isZero = true;
		}
		
		
//		Array der Stringlänge erzeugen und befüllen und führende Nullen entfernen
		if(isNatural){
			if(Zahl.length()>1)
				Zahl=Zahl.replaceAll("^0*","");
			numberArray = new int[Zahl.length()];
			for (int i=0;i <Zahl.length();i++ ){
				numberArray[i] = Character.getNumericValue(Zahl.charAt(i));
				//println("i: " + i+ "charAt(i): " + Zahl.charAt(i));
			}
		}
		else
			throw new PRException("Es wurde keine natürliche Zahl eingegeben.");	
	}
	
	void add(BigInt number){
//		println("BigInt: "+ number.numberArray[0]);
		int[] helperArray;
		int carry = 0;
		//Prüfen welches Arary länger ist
		if(number.numberArray.length >= numberArray.length){
			helperArray = new int[number.numberArray.length];
			for(int i = (number.numberArray.length-1), j = (numberArray.length-1); i>=0 ; i--){
				//solange das kürze Array von Bedeutung ist
				if(j>=0){
					int x = number.numberArray[i];
					int y = numberArray[j];
					if( (x+y+carry) / 10 == 0 ){
						helperArray[i] = x+y+carry;
						carry = 0;
					}
					else{
						helperArray[i] = (x+y+carry-10);
						carry = 1;
						//Anpassung der Arrays um die länge 1 für einen Übertrag an der ersten Stelle
						if(j<=0 && i<=0)
							helperArray = ajustHelperArray(helperArray);
					}
					j--;
				}
				else{
					helperArray[i] = number.numberArray[i] + carry;
					if( (number.numberArray[i] + carry) / 10 == 0 ){
						helperArray[i] = number.numberArray[i] + carry;
						carry = 0;
					}
					else{
						helperArray[i] = (number.numberArray[i] + carry - 10);
						carry = 1;
						if(j<=0 && i<=0)
							helperArray = ajustHelperArray(helperArray);
					}
				}
			}
		}
		//Selbes Prinzip wie vorher nur anderes Array länger
		else{
			helperArray = new int[numberArray.length];
			for(int i = (number.numberArray.length-1), j = (numberArray.length-1); j>=0 ; j--){
				if(i>=0){
					int x = number.numberArray[i];
					int y = numberArray[j];
					if( (x+y+carry) / 10 == 0 ){
						helperArray[j] = x+y+carry;
						carry = 0;
					}
					else{
						helperArray[j] = (x+y+carry-10);
						carry = 1;
						if(j<=0 && i<=0)
							helperArray = ajustHelperArray(helperArray);
					}
					i--;
				}
				else{
					helperArray[j] = numberArray[j] + carry;
					if( (numberArray[j] + carry) / 10 == 0 ){
						helperArray[j] = numberArray[j] + carry;
						carry = 0;
					}
					else{
						helperArray[j] = (numberArray[j] + carry - 10);
						carry = 1;
						if(j<=0 && i<=0)
							helperArray = ajustHelperArray(helperArray);
							
					}
				}
			}
		}
		numberArray = helperArray;
	}
	
	//Anpassung des Arrays um 1
	int[] ajustHelperArray(int[] helperArray){
		int[] newHelperArray = new int[helperArray.length+1];
		for(int i = (helperArray.length-1); i >=0; i--)
			newHelperArray[1+i] = helperArray[i];
		newHelperArray[0] = 1;
		
		return newHelperArray;
	}
	
	//Ausgabe Methode des numberArrays zur Überprüfung
	void ausgabe(){
		print("numberArray: ");
		for(int i:numberArray){
			print(i+" ");
		}
		println();
	}
	
	public String toString(){
		String stringNumber = "";
		for(int i : numberArray)
			stringNumber += i;
		return stringNumber;
	}
	
	int[] getDigits(){
		return numberArray;
	}
	int length(){
		return numberArray.length;
	}
	
	boolean equals(BigInt number){
		if(number.numberArray.length == numberArray.length){
			for(int i = 0; i<number.numberArray.length; i++){
				if(number.numberArray[i] != numberArray[i])
					return false;
			}
		}
		else
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BigInt zahl1 = new BigInt("000000000007"); 
		BigInt zahl2 = new BigInt("0");
		zahl1.ausgabe();
		zahl2.ausgabe();
		
		
		println("equals: ");
		println(zahl2.equals(new BigInt("0")));
		
		
		
		
		
		
		
//		zahl1.add(zahl2); //übertrag beachten
//		zahl1.ausgabe();
//		println("toString: ");
//		println(zahl2.toString());
//		println("getDigits: ");
//		//println(zahl2.getDigits()[0]);
//		println("length: ");
//		println(zahl2.length());

	}

}
