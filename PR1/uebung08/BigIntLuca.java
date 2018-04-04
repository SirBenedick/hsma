package pr1.uebung08;

import static pr.MakeItSimple.*;

public class BigIntLuca {

	private int[] numberArray;

	BigIntLuca(String number) {
		int laenge = number.length();
		int[] numberToArray = new int[laenge];

		for (int i = 0; i < laenge; i++) {
			if (number.charAt(i) != '0' && number.charAt(i) != '1' && number.charAt(i) != '2' && number.charAt(i) != '3'
					&& number.charAt(i) != '4' && number.charAt(i) != '5' && number.charAt(i) != '6'
					&& number.charAt(i) != '7' && number.charAt(i) != '8' && number.charAt(i) != '9')
				throw new PRException("Ungueltiger Parameter");
		}

		for (int i = 0; i < laenge; i++) {
			char ch = number.charAt(i);
			numberToArray[i] = ch - 48;
		}
		numberArray = numberToArray;

	}

	void add(BigIntLuca number) {
		// number.zahlArray[0] = 5;
		// zahlArray[0] = 6;
		int uebertrag = 0; // Übertrag zum addieren der Zahlen
		int differenz; // differenz zum angleichen der Arrays

		int number1_length = numberArray.length; // länge des ursprünglichen
		// Arrays
		int[] numberArrayChanged; // deklarieren, falls das erste Array
		// verlängert wird

		int numberToAdd_length = number.numberArray.length; // länge des zu
		// addierenden
		// Arrays
		int[] numberToAddChanged; // deklarieren, falls das zweite Array
		// verlängert wird

		if (number1_length < numberToAdd_length) {
			differenz = numberToAdd_length - number1_length;
			numberArrayChanged = new int[numberToAdd_length];
			for (int i = 0; i < differenz; i++) {
				numberArrayChanged[i] = 0;
			}
			int index = 0;
			for (int i = differenz; i < numberArrayChanged.length; i++) {
				numberArrayChanged[i] = numberArray[index];
				index++;
			}
			int[] ergebnisWert = new int[20];
			int neueLaenge = numberArrayChanged.length;
			int filler = ergebnisWert.length;

			while (filler >= 0) {
				if ((numberArrayChanged[neueLaenge] + number.numberArray[neueLaenge] + uebertrag) > 9) {
					ergebnisWert[filler] = numberArrayChanged[neueLaenge] + number.numberArray[neueLaenge]
							+ uebertrag / 10;
					uebertrag = numberArrayChanged[neueLaenge] + number.numberArray[neueLaenge] + uebertrag / 10;
				} else{
					ergebnisWert[filler] = numberArrayChanged[neueLaenge] + number.numberArray[neueLaenge] + uebertrag ;
					uebertrag = 0;
				}

			}

		} else if (numberToAdd_length < number1_length) {
			differenz = number1_length - numberToAdd_length;
			numberToAddChanged = new int[number1_length];
			for (int i = 0; i < differenz; i++) {
				numberToAddChanged[i] = 0;
			}
			int index = 0;
			for (int i = differenz; i < numberToAddChanged.length; i++) {

				numberToAddChanged[i] = number.numberArray[index];
				index++;
			}
			int[] ergebnisWert = new int[20];
			int neueLaenge = numberToAddChanged.length - 1;
			int filler = ergebnisWert.length - 1;

			while (filler >= 0)
				if (numberToAddChanged[neueLaenge] + numberArray[neueLaenge] > 9) {
					ergebnisWert[filler] = numberToAddChanged[neueLaenge] + numberArray[neueLaenge] + uebertrag % 10;
					uebertrag = numberToAddChanged[neueLaenge] + numberArray[neueLaenge] / 10;
					filler--;
				} else {
					uebertrag = 0;
					ergebnisWert[filler] = numberToAddChanged[neueLaenge] + numberArray[neueLaenge] + uebertrag % 10;
					filler--;
				}
		}
	}

	public static void main(String[] args) {
		BigInt zahl1 = new BigInt("555");
		BigInt zahl2 = new BigInt("355");

		zahl1.add(zahl2);
		System.out.println(zahl1);
	}
}