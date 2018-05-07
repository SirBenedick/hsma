package hashTable;

import static pr.MakeItSimple.*;

public class SongsTest {

	public static void main(String[] args) {
		HashTable table = new HashTable(new QuadraticProbing());
		table.put(new StringElement("peter"), new Song("peter", "peterson", "die peters"));
		println(table.containsKey(new StringElement("peter")));
		println(table.contains(new Song("peter", "peterson", "die peters")));
//		String[] songs = readStringArray("lib/song.txt");
//		for (int i = 0; i < songs.length; i++) {
//			String[] temp = songs[i].split(";");
//			table.put(new StringElement(temp[0]), new Song(temp[0], temp[1], temp[2]));
//		}


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
