package uebung05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Box<? extends Number> bo1;
		Box<? super Number> bo2;
		ArrayList<Box<Number>> list = new ArrayList<Box<Number>>();
		BufferedReader f;
		String line = "";
		try {
			int c;
			f = new BufferedReader(new FileReader("ue5.txt"));
			while ((c = f.read()) != -1) {
				line += (char) c;
			}

			String[] numbers = line.split(" ");
			for (int i = 0; i < numbers.length; i++) {
				Box<Number> box = new Box<Number>();
				if (numbers[i].contains(".")) {
					double d = Double.parseDouble(numbers[i]);
					box.setValue(d);
					list.add(box);
				} else {
					int v = Integer.parseInt(numbers[i]);
					box.setValue(v);
					list.add(box);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Box<? extends Number> boxL : list) {
			bo1 = boxL;
			System.out.print(bo1.getValue().toString() + " ");
		}
		System.out.println("");

		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Box<Number> boxL = (Box<Number>) iterator.next();
			bo1 = boxL;
			bo2 = boxL;
			if (bo1.getValue() instanceof Integer) {
				bo2.setValue((int) bo1.getValue() * 2);
			}
			if (bo1.getValue() instanceof Double) {
				bo2.setValue((double) bo1.getValue() * 3);
			}
		}

		for (Box<? extends Number> boxL : list) {
			System.out.print(boxL.getValue().toString() + " ");
		}
	}
}
