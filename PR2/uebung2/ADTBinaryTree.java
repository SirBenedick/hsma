package uebung2;

public interface ADTBinaryTree {  // only int values stored in tree

	public boolean insert(Element val); // inserts val in tree.

    boolean insert(String filename); // inserts  objects from file in tree

    boolean saveToFile (String filename); // stores objects from tree in file

	boolean contains(Element val); // checks if val is in tree

	int size(); // computes number of values in tree

	int height(); // computes height of tree

	Element getMax(); // returns biggest value of tree

	Element getMin(); // returns smallest value of tree

	boolean remove(Element val); // removes val from tree

    boolean isEmpty(); // checks if tree is empty
    
    void clear(); // removes all elements from tree

	ADTBinaryTree addAll(ADTBinaryTree otherTree); // inserts all values from otherTree in tree

	void printInorder(); // prints tree in inorder

	void printPostorder(); // prints tree in postorder

	void printPreorder(); // prints tree in preorder

	void printLevelorder(); // prints tree in levelorder

	Object clone(); // creates a deep copy of tree
	
	ADTBinaryTree empty();

}