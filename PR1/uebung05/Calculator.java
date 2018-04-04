package pr1.uebung05;
import static pr.MakeItSimple.*;

public class Calculator {
	
	static String[] analyzeFormula(String formulaText){
		int formulaLength = 1;
		for(int i = 0; i< formulaText.length(); i++){
			if(formulaText.charAt(i) == ' '){
				formulaLength++;
			}
		}
		String[] elements = new String[formulaLength];
		
		
		for (int i = 0; i<=elements.length; i++){
			int ArrayI = 0;
			if(formulaText.charAt(i) != ' ' ){
				elements[ArrayI] += formulaText.charAt(i);
			}
			else{
				ArrayI++;
			}
			}
					
		return elements;
	}
	
	static int calculate(String[] elements){
		
		int Ergebnis = Integer.parseInt(elements[0]);
		for(int i = 1; i<= elements.length; i+=2){
			if(elements[i] == "+" ){
			Ergebnis += Integer.parseInt(elements[i+1]);
			}
			else
			Ergebnis -= Integer.parseInt(elements[i+1]);
			
			
		}
		
		return Ergebnis;
	}

	public static void main(String[] args) {
		String formulaText;
		print("geben sie eine Rechenaufgabe ein: ");
		formulaText = readString();
		String[] elements = analyzeFormula(formulaText);
		for(int i = 0; i<= elements.length; i++)
			println(elements[i] + " ");
		
		println(calculate(elements));
		

	}

}
