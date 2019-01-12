package pr1.uebung04;

import static pr.MakeItSimple.*;

public class SearchInRandomNumbers {

	static int[] generate(int numberCount) {
		if (numberCount < 0) {
			throw new PRException("Die eingegebene Länge des Arrays ist kleiner als 0");
		}

		else {

			int[] randomArray = new int[numberCount];
			int i = 0;
			while (i < numberCount) {
				randomArray[i] = (int) (Math.random() * 1000) + 1;
				// print(randomArray[i] + " ");
				i++;
			}

			return randomArray;
		}
	}

	static int[] searchAll(int[] randomArray, int numberToSearch) {
		int i = 0;
		int arrayLength = 0;
		while (i < randomArray.length) {

			if (randomArray[i] == numberToSearch)
				arrayLength++;
			i++;
		}

		int[] positionInRandomArray = new int[arrayLength];
		int position = 0;
		int arrayIndex = 0;
		while (position < randomArray.length) {

			if (randomArray[position] == numberToSearch) {
				positionInRandomArray[arrayIndex] = position;
				arrayIndex++;
			}
			position++;
		}

		return positionInRandomArray;
	}

	static int searchLast(int[] randomArray, int numberToSearch) {
		int i = 0;
		int positionLast = 0;
		while (i < randomArray.length) {
			if (randomArray[i] == numberToSearch)
				positionLast = i;
			i++;
		}
		if (positionLast == 0 && randomArray[0]!= numberToSearch) {
			throw new PRException("Die gesuchte Zahl wurde nicht gefunden");
		} else {
			return positionLast;
		}
	}

	public static void main(String[] args) {
		print("Gebe die Größe des Arrays ein: ");
		int numberCount = readInt();
		print("Geb die zu suchende Zahl ein: ");
		int numberToSearch = readInt();

//		int[] randomArray = generate(numberCount);
		int[] randomArray = new int[]  {42};
		int[] positionInRandomArray = searchAll(randomArray, numberToSearch);
		
			println();
			if(positionInRandomArray.length != 0){
				println("Positionen im zufälligen Array: ");
				int position = 0;
				while (position < positionInRandomArray.length) {
					print(positionInRandomArray[position] + " ");
					position++;
				}
			}
			println();
			println("Letzte Position: " + searchLast(randomArray, numberToSearch));
		
		
	}

}
