package pr1.uebung09;

import java.lang.*;
import static pr.MakeItSimple.*;

public class BigIntJohannes {
	private int[] numberArray;

	BigIntJohannes(String Zahl) {
		// Prüfen ob der String nur aus 0-9 besteht
		createArray(Zahl);
	}

	private void createArray(String Zahl) {
		boolean isNatural = true;

		for (int i = 0; i < Zahl.length(); i++) {
			if (('0' > Zahl.charAt(i)) || (Zahl.charAt(i) > '9'))
				isNatural = false;

		}

		// Array der Stringlänge erzeugen und befüllen und führende Nullen
		// entfernen
		if (isNatural) {
			boolean isEmptyDirty = false;
			boolean isEmptyClean = false;
			if (Zahl.length() == 0)
				isEmptyDirty = true;
			Zahl = Zahl.replaceAll("^0*", "");
			if (Zahl.length() == 0)
				isEmptyClean = true;
			if (!isEmptyDirty && isEmptyClean)
				Zahl = "0";

			numberArray = new int[Zahl.length()];
			for (int i = 0; i < Zahl.length(); i++) {
				numberArray[i] = Character.getNumericValue(Zahl.charAt(i));
				// println("i: " + i+ "charAt(i): " + Zahl.charAt(i));
			}
		} else
			throw new PRException("Es wurde keine natürliche Zahl eingegeben.");
	}

	void add(BigIntJohannes number) {
		// println("BigIntJohannes: "+ number.numberArray[0]);
		int[] helperArray;
		int carry = 0;
		// Prüfen welches Arary länger ist
		if (number.numberArray.length >= numberArray.length) {
			helperArray = new int[number.numberArray.length];
			for (int i = (number.numberArray.length - 1), j = (numberArray.length - 1); i >= 0; i--) {
				// solange das kürze Array von Bedeutung ist
				if (j >= 0) {
					int x = number.numberArray[i];
					int y = numberArray[j];
					if ((x + y + carry) / 10 == 0) {
						helperArray[i] = x + y + carry;
						carry = 0;
					} else {
						helperArray[i] = (x + y + carry - 10);
						carry = 1;
						// Anpassung der Arrays um die länge 1 für einen
						// Übertrag an der ersten Stelle
						if (j <= 0 && i <= 0)
							helperArray = ajustHelperArray(helperArray);
					}
					j--;
				} else {
					helperArray[i] = number.numberArray[i] + carry;
					if ((number.numberArray[i] + carry) / 10 == 0) {
						helperArray[i] = number.numberArray[i] + carry;
						carry = 0;
					} else {
						helperArray[i] = (number.numberArray[i] + carry - 10);
						carry = 1;
						if (j <= 0 && i <= 0)
							helperArray = ajustHelperArray(helperArray);
					}
				}
			}
		}
		// Selbes Prinzip wie vorher nur anderes Array länger
		else {
			helperArray = new int[numberArray.length];
			for (int i = (number.numberArray.length - 1), j = (numberArray.length - 1); j >= 0; j--) {
				if (i >= 0) {
					int x = number.numberArray[i];
					int y = numberArray[j];
					if ((x + y + carry) / 10 == 0) {
						helperArray[j] = x + y + carry;
						carry = 0;
					} else {
						helperArray[j] = (x + y + carry - 10);
						carry = 1;
						if (j <= 0 && i <= 0)
							helperArray = ajustHelperArray(helperArray);
					}
					i--;
				} else {
					helperArray[j] = numberArray[j] + carry;
					if ((numberArray[j] + carry) / 10 == 0) {
						helperArray[j] = numberArray[j] + carry;
						carry = 0;
					} else {
						helperArray[j] = (numberArray[j] + carry - 10);
						carry = 1;
						if (j <= 0 && i <= 0)
							helperArray = ajustHelperArray(helperArray);

					}
				}
			}
		}
		numberArray = helperArray;
	}

	void times(BigIntJohannes number) {
		BigIntJohannes timedFinal = new BigIntJohannes("0");

		// Soll jede Stelle im Array durchgehen
		for (int j = 0; j < numberArray.length; j++) {
			if (numberArray[j] != 0) {
				BigIntJohannes timed = new BigIntJohannes(number.toString());

				// multipliziert number mit der jeweiligen Stelle im Array
				for (int i = 1; i < numberArray[j]; i++) {
					timed.add(number);
				}

				// modifiziert Ergebnis je nach Stelle im Array
				int[] helperHelper = new int[timed.length() + numberArray.length - j - 1];
				int[] stepHelper = timed.getDigits();

				// schreibt alle Stellen in neues Array, hinteren Stellen bleiben Nullen
				for (int i = 0; i < stepHelper.length; i++) {
					helperHelper[i] = stepHelper[i];
				}

				// wieder zurück in Object, um es dem Ergebnis zu addiere
				String stringNumber = "";
				for (int i : helperHelper) {
					stringNumber += i;
				}
				BigIntJohannes helperObject = new BigIntJohannes(stringNumber);
				// addiert jeweilige Stellen mit vorherigem Ergebnis
				timedFinal.add(helperObject);
			}
		}
		numberArray = timedFinal.getDigits();
	}

	boolean greater(BigIntJohannes number) {
		boolean isGreater = false;
		boolean isEqual = true;

		if (numberArray.length > number.length()) {
			isGreater = true;
			return isGreater;
		} else if (numberArray.length < number.length())
			return isGreater;

		else {
			for (int i = 0; i < number.length(); i++) {
				if (numberArray[i] < number.numberArray[i]) {
					return isGreater;
				}
				if (numberArray[i] != number.numberArray[i])
					isEqual = false;
			}
		}
		if (isEqual)
			return isGreater;

		isGreater = true;
		return isGreater;

	}

	// Anpassung des Arrays um 1
	int[] ajustHelperArray(int[] helperArray) {
		int[] newHelperArray = new int[helperArray.length + 1];
		for (int i = (helperArray.length - 1); i >= 0; i--)
			newHelperArray[1 + i] = helperArray[i];
		newHelperArray[0] = 1;

		return newHelperArray;
	}

	// Ausgabe Methode des numberArrays zur Überprüfung
	void ausgabe() {
		print("numberArray: ");
		for (int i : numberArray) {
			print(i + " ");
		}
		println();
	}

	public String toString() {
		String stringNumber = "";
		for (int i : numberArray)
			stringNumber += i;
		return stringNumber;
	}

	int[] getDigits() {
		return numberArray;
	}

	int length() {
		return numberArray.length;
	}

	boolean equals(BigIntJohannes number) {
		if (number.numberArray.length == numberArray.length) {
			for (int i = 0; i < number.numberArray.length; i++) {
				if (number.numberArray[i] != numberArray[i])
					return false;
			}
		} else
			return false;
		return true;
	}

	public static void main(String[] args) {
		BigIntJohannes zahl1 = new BigIntJohannes("30");
		BigIntJohannes zahl2 = new BigIntJohannes("999");
		zahl1.ausgabe();
		zahl2.ausgabe();

		// zahl1.add(zahl2); //übertrag beachten
		// zahl1.ausgabe();
		// println("toString: ");
		// println(zahl2.toString());
		// println("getDigits: ");
		// println(zahl2.getDigits()[0]);
		// println("length: ");
		// println(zahl2.length());
		// println("equals: ");
		// println(zahl2.equals(zahl1));
		 println("greater: ");
		 println(zahl1.greater(zahl2));
		zahl1.times(zahl2);
		println(zahl1.toString());
	}

}
