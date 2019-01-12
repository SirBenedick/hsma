package pr1.uebung08;

import static pr.MakeItSimple.*;

public class BigIntJohannes {
	private int[] numberArray;

	BigIntJohannes(String Zahl) {
		boolean isNumeric = true;
		for (int i = 0; i < Zahl.length(); i++) {
			if (Zahl.charAt(i) < '0' || Zahl.charAt(i) > '9')
				isNumeric = false;
		}
		if (isNumeric) {
			numberArray = new int[Zahl.length()];
			for (int i = 0; i < numberArray.length; i++) {
				numberArray[i] = Zahl.charAt(i) - '0';
			}
		} else
			throw new PRException("String besteht nicht aus einer natürlichen Zahl");

	}

	void add(BigIntJohannes number) {
		
		int[] helperArray;
		if (numberArray.length >= number.numberArray.length) {
			helperArray = new int[numberArray.length];
			for (int i = number.numberArray.length, j = number.numberArray.length -1; i > 0; i--, j--){
				helperArray[i] = number.numberArray[j];
				}

			for (int i = number.numberArray.length - 1; i < 1; i--) {
				numberArray[i] += number.numberArray[i];
			}
		} else {
			helperArray = new int[number.numberArray.length];
			for (int i = numberArray.length, j = numberArray.length -1; i > 0; i--, j--){
				helperArray[i] = numberArray[j];
				}

			for (int i = numberArray.length - 1; i < 1; i--) {
				numberArray[i] += number.numberArray[i];
			}
		}
	}

	public String toString() {
		String StringNumber = "";
		for (int i : numberArray) {
			StringNumber += i;
		}
		return StringNumber;

	}

	public static void main(String[] args) {
		BigIntJohannes zahl1 = new BigIntJohannes("3123");
		BigIntJohannes zahl2 = new BigIntJohannes("12345");
		println(zahl1.toString());
		println(zahl2.toString());
		zahl2.add(zahl1);
		println(zahl2.toString());

	}

}
