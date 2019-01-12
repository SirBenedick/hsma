package myBinaryTree;

public interface BinaryTree {  // only int values stored in tree

	public boolean insert(int value); // inserts value in tree.

	boolean insert(String filename); // inserts int values from file in tree

	boolean contains(int value); // checks if value is in tree

	int size(); // computes number of values in tree

	int height(); // computes height of tree

	int getMax(); // returns biggest value of tree

	int getMin(); // returns smallest value of tree

	boolean remove(int value); // removes value from tree

	boolean isEmpty(); // checks if tree is empty

	void addAll(BinaryTree otherTree); // inserts all values from otherTree in tree

	void printInorder(); // prints tree in inorder

	void printPostorder(); // prints tree in postorder

	void printPreorder(); // prints tree in preorder

	void printLevelorder(); // prints tree in levelorder
	
	void saveToFile (String filename); //saves the values of the tree into a .txt file (levelorder)

	BinaryTree clone(); // creates a deep copy of tree
	
	void clear(); //clears the tree

}