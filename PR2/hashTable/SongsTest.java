package hashTable;

import static pr.MakeItSimple.*;

public class SongsTest {

	public static void main(String[] args) {
		HashTable table = new HashTable(new QuadraticProbing());
//		String[] songs = readStringArray("lib/song.txt");
//		for (int i = 0; i < songs.length; i++) {
//			String[] temp = songs[i].split(";");
//			table.put(new StringElement(temp[0]), new Song(temp[0], temp[1], temp[2]));
//		}
//		println(table.numberOfCollisions);
//		println(table.size());
		String s1 = "abc";
		String s2 = "abcd";
		println("Is empty: "+table.isEmpty());
		table.put("ab", s1);
		table.put("ab", s1+s2);
		println(table.contains(s1+s2));
		table.printHt();
		// String[] songs = readStringArray("lib/song.txt");
		// println(songs.length);
		// String[][] songs2 = new String[songs.length][6];
		// Element[] elements = new Element[songs.length];
		// for (int i = 0; i < songs.length; i++) {
		// String[] seperated = songs[i].split(";");
		// for (int j = 0; j < seperated.length; j++) {
		// songs2[i][j] = seperated[j];
		// }
		//
		// }
		// for (int i = 0; i < elements.length; i++) {
		// elements[i] = new Element(new Song(songs2[i][0], songs2[i][1],
		// songs2[i][2]), songs2[i][0]);
		// }
		// println(elements[1].key);
	}

}
