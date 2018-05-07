package hashTable;

import static pr.MakeItSimple.*;

public class HashTable {
	public int numberOfCollisions = 0;
	private HashElement[] hashTable = new HashElement[100];
	private boolean linearProbing = true;
	private boolean quadraticProbing = false;

	public HashTable() {

	}

	public HashTable(LinearProbing probing) {
		linearProbing = true;
	}

	public HashTable(QuadraticProbing probing) {
		quadraticProbing = true;
		linearProbing = false;
	}

	public HashTable(int size) {
		hashTable = new HashElement[size];
	}

	public Object put(Object key, Object song) {
		int index = probeToNullOrEqualKey(key);
		if (hashTable[index] == null) {
			hashTable[index] = new HashElement(key, song);
			handleExpansion();
			return null;
		} else {
			if (hashTable[index].getKey().toString().equals(key.toString())) {
				Object old = hashTable[index].getValue();
				hashTable[index] = new HashElement(key, song);
				return old;
			}
			return null;
		}

		// int index = key.hashCode() % hashTable.length;
		// if (hashTable[index] == null) {
		// hashTable[index] = new HashElement(key, song);
		// return null;
		// }
		// int calls = 0;
		// while (hashTable[index] != null && !hashTable[index].delete) {
		// if (hashTable[index].getKey().toString().equals(key.toString())) {
		// Object old = hashTable[index].getValue();
		// hashTable[index] = new HashElement(key, song);
		// return old;
		// } else {
		// calls++;
		// if (linearProbing) {
		// index = linearProbing(key, calls);
		// } else if (quadraticProbing) {
		// index = quadraticProbing(key, calls);
		// }
		// }
		// }
		// hashTable[index] = new HashElement(key, song);
		// return null;

		// if (containsKey(key)) {
		// Object old = get(key);
		// hashTable[index] = new HashElement(song, key);
		// return old;
		// }
		// hashTable[index] = new HashElement(song, key);
		// return null;
	}

	public Object get(Object key) {
		int index = probeToNullOrEqualKey(key);
		if (hashTable[index] == null)
			return null;
		return hashTable[index].getValue();
	}

	public void printHt() {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null && !hashTable[i].delete) {
				println(i + " key: " + hashTable[i].getKey().toString() + ", value: "
						+ hashTable[i].getValue().toString());
			}
		}
	}

	public void print() {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null && !hashTable[i].delete)
				println(i + ": " + hashTable[i].getValue().toString());
			else
				println(i + ":");
		}
	}

	public boolean contains(Object value) { // no probing currently
		String[] song = value.toString().split(",");
		StringElement key = new StringElement(song[0]);
		return containsKey(key);
	}

	public boolean containsKey(Object key) {
		int index = probeToNullOrEqualKey(key);
		if (hashTable[index] == null)
			return false;
		return true;
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null)
				size++;
		}
		return size;
	}

	public boolean remove(Object key) {
		int index = probeToNullOrEqualKey(key);
		if (hashTable[index] != null) {
			hashTable[index].delete = true;
			return true;
		}
		return false;
	}

	// int index = key.hashCode() % hashTable.length;
	// int calls = 0;
	// while (hashTable[index] != null &&
	// !hashTable[index].getKey().toString().equals(key.toString())) {
	// calls++;
	// if (linearProbing) {
	// index = linearProbing(key, calls);
	// } else if (quadraticProbing) {
	// index = quadraticProbing(key, calls);
	// }
	// }
	// if (hashTable[index] != null) {
	// hashTable[index].delete = true;
	// return true;
	// } else
	// return false;
	// }

	private int probeToNullOrEqualKey(Object key) {
		int index = key.hashCode() % hashTable.length;
		if (index < 0)
			index *= -1;
		int calls = 0;
		while (hashTable[index] != null && !hashTable[index].getKey().toString().equals(key.toString())
				&& !hashTable[index].delete) {
			calls++;
			if (linearProbing) {
				index = linearProbing(key, calls);
			} else if (quadraticProbing) {
				index = quadraticProbing(key, calls);
			}
			if (index < 0)
				index *= -1;
		}
		return index;
	}

	private int quadraticProbing(Object key, int calls) {
		numberOfCollisions++;
		int index;
		if (calls % 2 == 1)
			index = (key.hashCode() + (((calls + 1) / 2) * ((calls + 1) / 2))) % hashTable.length;
		else
			index = (key.hashCode() - (((calls + 1) / 2) * ((calls + 1) / 2))) % hashTable.length;
		return index;
	}

	private int linearProbing(Object key, int calls) {
		numberOfCollisions++;
		int index;
		if (calls % 2 == 1)
			index = (key.hashCode() + calls) % hashTable.length;
		else
			index = (key.hashCode() - calls) % hashTable.length;
		return index;
	}

	private void handleExpansion() {
		if ((float) size() / (float) hashTable.length >= 0.75) {
			HashElement[] temp = hashTable;
			hashTable = new HashElement[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] != null) {
					put(temp[i].getKey(), temp[i].getValue());
				}
			}
		}
	}
	
	public void clear(){
		hashTable = new HashElement[100];
	}
	
	public boolean isEmpty(){
		if(size() == 0)
			return true;
		return false;
	}
}
