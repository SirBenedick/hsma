package pr1.uebung05;
import static pr.MakeItSimple.*;

public class Caeser {

	static String encrypt(String originalText, int shift){
		String encryptedText = "";
		originalText = originalText.toLowerCase();
		
		char letter;
		for(int i = 0; i<originalText.length(); i++){
			if('a' <= originalText.charAt(i) && originalText.charAt(i)<='z'){
				if(shift + (originalText.charAt(i)) > 122){
					letter = (char) (originalText.charAt(i) + shift - 26);
					encryptedText = encryptedText + letter;
				}
				else{
					letter = (char) (originalText.charAt(i) + shift) ;
					encryptedText = encryptedText + letter;
				}
			}
			else{
				encryptedText = encryptedText + (char) (originalText.charAt(i)) ;
			}
		}
		
		return encryptedText;
	}
	

	
	public static void main(String[] args) {
		print("Bitte geben Sie den zu verschlüsselenden Text ein: ");
		String originalText = readString();
		print("Geben Sie bitte die Verschiebung ein(1-26): ");
		int shift = readInt();
		String encryptedText= encrypt(originalText, shift);
		println(encryptedText);
	
		//decrypt(encryptedText, shift);
	}

}


/**
 * MAIN
 * String + Zahl(1-26) eingeben
 * 
 * 2.
 * static String encrypt(String originalText, int shift)
 * in main ausgevben
 * 
 * a=97
 * z=122
*/
