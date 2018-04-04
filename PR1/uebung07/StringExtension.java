package pr1.uebung07;

import static pr.MakeItSimple.*;

public class StringExtension {

	static String toUpper(String text) {
		char letter;
		String newText = "";
		for (int i = 0; i < text.length(); i++) {
			letter = text.charAt(i);
			if (('a' <= letter && letter <= 'z') || letter == 'ö' || letter == 'ä' || letter == 'ü') {
				letter -= 32;
				newText += letter;
			} else {
				newText += "" + letter;
			}
		}
		return newText;

	}

	static String toUpperRecursive(String text) {
		String newText = helper(text, " ", 0);
		return newText;
	}

	static String helper(String text, String newText, int i) {
		if (i < text.length()) {
			char letter = text.charAt(i);
			if (('a' <= letter && letter <= 'z') || letter == 'ö' || letter == 'ä' || letter == 'ü') {
				letter -= 32;
				newText = "" + letter;
			} else {
				newText = "" + letter;
			}
			i++;
			newText += helper(text, newText, i);
		} else {
			newText = "";
		}

		return newText;
	}
	
	static int scan(String text, String needle) {
		if (needle == "")
			throw new PRException("needle ist ein Leerstring");
		int i;
		for (i = 0; i < text.length(); i++) {
			if (text.charAt(i) == needle.charAt(0) && (i + needle.length()) <= text.length())
				if (needleFound(text, needle, i))
					break;
		}
		if (i == text.length())
			throw new PRException("Needle ist nicht im Text enthalten.");
		return i;
	}

	static boolean needleFound(String text, String needle, int i) {
		boolean found = true;
		int positionAfterNeedle = i + needle.length();
		int positionBeforeNeedle = i - 1;
		for (int j = 0; (j < needle.length()) && found; j++, i++) {
			if (!(text.charAt(i) == needle.charAt(j))) {
				found = false;
			}
		}
//		exaktes Wort finden
//		if(positionAfterNeedle < text.length()){
//			char letterAfter = text.charAt(positionAfterNeedle);
//			if (isLetter(letterAfter)) {
//				found = false;
//			}
//		}
//		if(positionBeforeNeedle >= 0){
//			char letterBefore = text.charAt(positionBeforeNeedle);
//			if (isLetter(letterBefore)) {
//				found = false;
//			}
//		}
		
		return found;
	}
	
	static boolean isLetter(char letter){
		
		if (('a' <= letter && letter <= 'z') || letter == 'ö' || letter == 'ä' || letter == 'ü' ||
			('A' <= letter && letter <= 'Z') || letter == 'Ö' || letter == 'Ä' || letter == 'Ü') {
			return true;
		}
		else
			return false;
	}
	
	static String[] split(String text, char delimiter){
		String newText = text;
//		if(text.charAt(0) == delimiter && text.charAt(text.length() - 1) == delimiter){
//			for(int i = 1; i < (text.length() - 1); i++){
//				newText += "" + text.charAt(i);
//			}
//		}
//		else if(text.charAt(0) == delimiter){
//			for(int i = 1; i < text.length(); i++){
//				newText += "" + text.charAt(i);
//			}
//		}
//		else if(text.charAt(text.length()-1) == delimiter){
//			for(int i = 0; i < (text.length() - 1); i++){
//				newText += "" + text.charAt(i);
//			}
//		}
//		else{
//			newText = text;
//		}

		
		int countWords = 1;
		for(int i = 0; i < newText.length(); i++){
			if(newText.charAt(i) == delimiter){
				countWords++;
			}
		}
		
		String[] elements = new String[countWords];
		String word = "";
		for(int i = 0, j = 0; i < newText.length(); i++){
			if(newText.charAt(i) == delimiter){				
				elements[j] = word;
				j++;
				word = "";
				
			}

			else if(newText.charAt(i) != delimiter){
				word += "" + newText.charAt(i);
			}
		}
		if(newText.length() == 0){
		elements[(countWords - 1)] = word;
		}			
		else if(newText.charAt(newText.length() - 1) != delimiter){
		elements[(countWords - 1)] = word;
		}
		else if (newText.charAt(newText.length() - 1) == delimiter){
			elements[(countWords - 1)] = word;
		}

		return elements;
	}
	
	

	public static void main(String[] args) {
//		println("toUpper: " + toUpper("Hallöle Welt! ü ä ö"));
//		println("toUpperRecursive: " + toUpperRecursive("abcd?980/() jkh"));
//		println("Scan: " + scan("Hello, world! This world  is cool!", "world"));
//		String[] aufruf = split("Banane;Erdbeere;Apfel", ';');
//		for(int i = 0; i < aufruf.length; i++){
//			print(aufruf[i] + " ");
//			}
	
		println("Wählen Sie eine Operation");
		println("1) Eine Zeichenkette wird komplett in Großbuchstaben umgewandelt");
		println("2) Ein Wort wird in einem Satz gesucht und gibt die erste Stelle des Wortes an");
		println("3) Eine Zeichenkette wird anhand eines Trennzeichens aufgeteilt");
		println("Geben sie nun die Operation ein");
		
		
		int operation = readInt();
		switch (operation) {
		case 1:
			println("Gebe etwas ein, bei dem alles in Großbuchstaben umgewandelt werden soll");
			println(toUpperRecursive(readString()));
			break;
		case 2:
			println("Geben sie einen Satz ein: ");
			String satz = readString();
			println("und nun das Wort: ");
			String wort = readString();
			println(scan(satz, wort));			
			break;
		case 3:
			
			String trennString;
			do{
				println("Geben sie ein Trennzeichen der Länge 1 ein");	
				trennString = readString();
			}while(trennString.length() != 1);
			
			char trennChar = trennString.charAt(0);
			println("Nun die Zeichenkette");
			String zeichenkette = readString();
			String[] aufruf = split(zeichenkette,trennChar);
			for(int i = 0; i < aufruf.length; i++){
				print(" " +  i + ". " + aufruf[i]);
				}
			break;
		case 0:

			break;
		}
	}

}