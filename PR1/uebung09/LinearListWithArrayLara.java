package pr1.uebung09;

import static pr.MakeItSimple.*;

public class LinearListWithArrayLara {
	private int[] list;
	private int size = 0;
	private int[] helperList;

	public LinearListWithArrayLara() {
		println("Leeres Array erzeugt");
		this.list = new int[0];
	}

	public void addFirst(int element) {
		helperList = new int[list.length + 1];
		helperList[0] = element;
		for (int i = 0; i < list.length; i++) {
			helperList[1 + i] = list[i];
		}
		list = helperList;

		ausgabe("addFirst");
		resetHelperList();
	}

	private void resetHelperList() {
		helperList = new int[list.length];
	}

	public void addLast(int element) {
		helperList = new int[list.length + 1];
		helperList[helperList.length - 1] = element;

		for (int i = 0; i <= (list.length - 1); i++) {
			helperList[i] = list[i];
		}
		list = helperList;

		ausgabe("addLast");
		resetHelperList();
	}

	public int getFirst() {
		if (!isEmpty())
			return list[0];
		else
			throw new PRException("Liste ist leer");
	}

	public int getLast() {
		if (!isEmpty())
			return list[list.length - 1];
		else
			throw new PRException("Liste ist leer");
	}

	public int getAt(int position) {
		if (isEmpty())
			throw new PRException("Liste ist leer");
		if (list.length > position)
			return list[position];
		else
			throw new PRException("Liste ist zu kurz");
	}

	public boolean isEmpty() {
		if (list.length == 0)
			return true;
		return false;
	}

	public void removeFirst() {
		if (isEmpty())
			throw new PRException("Liste ist zu kurz");
		helperList = new int[list.length - 1];
		for (int i = 1; i < list.length; i++) {
			helperList[i - 1] = list[i];
		}
		list = helperList;
		resetHelperList();
		ausgabe("removeFirst");
	}

	public boolean contains(int search) {
		for (int i = 0; i < list.length; i++) {
			if (search == list[i])
				return true;
		}
		return false;
	}

	public void delete(int searchDelete) {
		int position = -1;
		boolean numberFound = false;

		for (int i = 0; i < list.length; i++) {
			if (searchDelete == list[i]) {
				position = i;
				numberFound = true;
			}
		}
		if (numberFound) {
			helperList = new int[list.length - 1];
			int j = 0;
			for (int i = 0; i < list.length; i++) {
				if (i != position)
					helperList[j] = list[i];
				else if (position!= list.length-1){

					i++;
					helperList[j] = list[i];
				}

				j++;
			}
			list = helperList;
		} else
			println("Nummer wurde nicht gefunden");
		ausgabe("delete");
		resetHelperList();
	}

	public void clear() {
		list = new int[0];
	}

	public int size() {
		return list.length;
	}

	public LinearListWithArrayLara clone() {
		LinearListWithArrayLara zahlKopie = new LinearListWithArrayLara();
		helperList = new int[list.length];

		for (int i = 0; i < list.length; i++)
			helperList[i] = list[i];
		zahlKopie.list = helperList;
		return zahlKopie;
	}

	public LinearListWithArrayLara empty() {
		return new LinearListWithArrayLara();
	}

	public void ausgabe(String text) {
		print(text + ": ");
		for (int j : list) {
			print(j + " ");
		}
		println();
	}

	public static void main(String[] args) {
		LinearListWithArrayLara zahl1 = new LinearListWithArrayLara();
		LinearListWithArrayLara zahl2 = new LinearListWithArrayLara();
		zahl1.addFirst(23);
		zahl1.addFirst(24);
		zahl1.addFirst(25);
		zahl1.addLast(45);
		println("First: " + zahl1.getFirst());
		println("Last: " + zahl1.getLast());
		println("At: " + zahl1.getAt(3));
		zahl1.removeFirst();
		println("contains: " + zahl1.contains(23));
		zahl1.delete(24);
		LinearListWithArrayLara clone = zahl1.clone();
		clone.ausgabe("Ausgabe nach Clone");

	}

}
