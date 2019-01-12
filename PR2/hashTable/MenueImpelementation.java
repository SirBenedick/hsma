package hashTable;

import static pr.MakeItSimple.*;

public class MenueImpelementation {

	public static void main(String[] args) {
		println("Choose your desired HashTable: ");
		println("1. Basic HashTable (no special constructor)");
		println("2. Linear probed HashTable");
		println("3. Quadritic probed HashTable");
		println("4. HashTable with a set initial size");
		print("Input the corresponding number:");
		int tableChoice = readInt();
		HashTable hashTable = null;
		switch (tableChoice) {
		case 1:
			hashTable = new HashTable();
			break;
		case 2:
			hashTable = new HashTable(new LinearProbing());
			break;
		case 3:
			hashTable = new HashTable(new QuadraticProbing());
			break;
		case 4:
			println("Input your desired size for the HashTable:");
			hashTable = new HashTable(readInt());
			break;
		}

		int userChoice;
		println("What do you want to do?");
		println("1. put");
		println("2. put from file");
		println("3. get a key");
		println("4. contains a key");
		println("5. cointains a value");
		println("6. is Empty");
		println("7. size");
		println("8. clear");
		println("9. remove");
		println("10. print table");
		println("11. EXIT");
		do {
			print("Choose option: ");
			userChoice = readInt();

			switch (userChoice) {
			case 1:
				print("Input song name: ");
				String songName = readString();
				print("Input album name: ");
				String albumName = readString();
				print("Input artists: ");
				String artists = readString();
				hashTable.put(new StringElement(songName), new Song(songName, albumName, artists));
				break;
			case 2:
				print("Input file-name: ");
				String filename = readString();
				String[] songs = readStringArray("lib/"+filename);
				for (int i = 0; i < songs.length; i++) {
					String[] temp = songs[i].split(";");
					hashTable.put(new StringElement(temp[0]), new Song(temp[0], temp[1], temp[2]));
				}
				break;
			case 3:
				print("which key to get: ");
				StringElement key = new StringElement(readString());
				println(hashTable.get(key).toString());
				break;
			case 4:
				print("which key to check: ");
				key = new StringElement(readString());
				if (hashTable.containsKey(key))
					println("Key is in the table");
				else
					println("Key is not in the table");
				break;
			case 5:
				print("Input song name: ");
				songName = readString();
				print("Input album name: ");
				albumName = readString();
				print("Input artists: ");
				artists = readString();
				if (hashTable.contains(new Song(songName, albumName, artists)))
					println("Value is in the Table");
				else
					println("Value is not in the Table");
				break;
			case 6:
				if (hashTable.isEmpty())
					println("The table is empty");
				else
					println("The table is not empty");
				break;
			case 7:
				println("The table contains " + hashTable.size() + " entries");
				break;
			case 8:
				hashTable.clear();
				println("Cleared!");
				break;
			case 9:
				println("Which key do you want to remove: ");
				hashTable.remove(new StringElement(readString()));
				break;
			case 10:
				hashTable.print();
				break;
			}

		} while (userChoice != 11);
	}
}
