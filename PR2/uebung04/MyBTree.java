package uebung04;

import static pr.MakeItSimple.*;
import java.util.LinkedList;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyBTree implements BTree, Cloneable {

	private int order;
	private TreeNode root = null;

	public MyBTree(int order) {
		this.order = order;
	}

	public MyBTree(Object node) {
		root = (TreeNode) node;
	}

	/**
	 * insert the given value into the tree
	 * 
	 * @param o
	 *            - value to be inserted
	 */
	@Override
	public boolean insert(Comparable o) {
		if (o == null)
			return false;
		if (root == null) {
			TreeNode node = new TreeNode(order);
			node.insert(o);
			root = node;
			return true;
		}
		if (contains(o))
			return false;
		TreeNode node = findNode(o, root);
		TreeNode tempRoot = node.insert(o);
		if (tempRoot != null)
			root = tempRoot;
		return true;
	}

	/**
	 * inserts all elements from a .txt file
	 * 
	 * @return true if all elements were inserted successfully, if one or more
	 *         fail return false
	 */
	@Override
	public boolean insert(String filename) {
		if (filename == null)
			return false;
		int[] stringsFromFile = readIntegerArray(filename);
		boolean inserted = true;
		for (int i = 0; i < stringsFromFile.length; i++) {
			if (!insert(stringsFromFile[i]))
				inserted = false;
		}
		return inserted;
	}

	/**
	 * @return a copy of the trees reference structure, the data structure isn't
	 *         cloned
	 */
	public BTree clone() {
		TreeNode node = (TreeNode) root.clone();
		BTree tree = new MyBTree(node);
		cloneRecursive(node);
		return tree;
	}

	/**
	 * clones a TreeNodes elements and children references from the given node
	 * and below, the contained elements themselves aren't copied
	 * 
	 * @param node
	 */
	private void cloneRecursive(TreeNode node) {
		Comparable[] newElements = node.getElements().clone();
		node.setElements(newElements);
		TreeNode[] newChildren = node.getChildren().clone();
		for (int i = 0; i < newChildren.length; i++) {
			if (node.getChildren()[i] != null)
				newChildren[i] = (TreeNode) node.getChildren()[i].clone();
		}
		node.setChildren(newChildren);
		for (int i = 0; i < newChildren.length; i++) {
			if (newChildren[i] != null)
				cloneRecursive(newChildren[i]);
		}

	}

	/**
	 * finds the Node which the Comparable o should be/is placed by recursively
	 * comparing the value to the values present in the node
	 * 
	 * @param o
	 * @param node
	 * @return TreeNode containing/closest to the Comparable
	 */
	private TreeNode findNode(Comparable o, TreeNode node) {
		Comparable[] elements = node.getElements();
		TreeNode[] children = node.getChildren();
		int pos = 0;
		while (elements[pos] != null && o.compareTo(elements[pos]) > 0) {
			pos++;
		}
		if(elements[pos] != null && elements[pos].compareTo(o) == 0)
			return node;
		if (children[pos] != null)
			return findNode(o, children[pos]);
		return node;

	}

	/**
	 * checks if a value is in the tree or not
	 * 
	 * @return true if comparable is in tree, false if not
	 */
	@Override
	public boolean contains(Comparable o) {
		if(o == null)
			return false;
		if (root == null)
			return false;
		TreeNode node = findNode(o, root);
		Comparable[] elements = node.getElements();
		int pos = 0;
		while (elements[pos] != null && o.compareTo(elements[pos]) > 0) {
			pos++;
		}
		if (elements[pos] != null && o.compareTo(elements[pos]) == 0)
			return true;
		return false;
	}

	/**
	 * deletes a value from the tree, (currently only working for leaves)
	 */
	@Override
	public void delete(Comparable obj) {
		if(obj == null)
			return;
		if (!contains(obj))
			return;
		TreeNode node = findNode(obj, root);
		root = node.delete(obj);

	}

	/**
	 * returns an int value representing the amount of elements in the tree
	 * 
	 * @return
	 */
	@Override
	public int size() {
		if (root == null)
			return 0;
		return nextNodeSize(root);
	}

	/**
	 * returns an int value representing the amount of elements in the given
	 * node as well as all the elements in the nodes below it
	 * 
	 * @param node
	 * @return amount of elements in the node and the nodes below it
	 */
	private int nextNodeSize(TreeNode node) {
		int size = 1;
		TreeNode[] children = node.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null)
				size += nextNodeSize(children[i]);
		}
		Comparable[] elements = node.getElements();
		int index = 0;
		while (elements[index] != null) {
			size++;
			index++;
		}
		return size - 1;
	}

	@Override
	public int height() {
		if (root == null)
			return 0;
		return branchHeight(root);
	}

	/**
	 * returns an int value representing the height of the longest branch below
	 * the node
	 * 
	 * @param node
	 * @return height from the branch below the given node
	 */
	private int branchHeight(TreeNode node) {
		TreeNode[] children = node.getChildren();
		int max = 0;
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				if (branchHeight(children[i]) > max)
					max = branchHeight(children[i]);
			}
		}
		return 1 + max;
	}

	/**
	 * Returns the maximum value in the tree
	 * 
	 * @return maximal value, null if tree is empty
	 */
	@Override
	public Comparable getMax() {
		if (root == null)
			return null;
		TreeNode node = root;
		TreeNode[] children = node.getChildren();
		int i = 0;
		while (node.getChildren()[0] != null) {
			while (children[i] != null) {
				i++;
			}
			node = children[i - 1];
			children = node.getChildren();
		}
		Comparable[] elements = node.getElements();
		int index = 0;
		while (elements[index] != null)
			index++;
		return elements[index - 1];
	}

	/**
	 * Returns the minimal value in the tree
	 * 
	 * @return minimal value, null if tree is empty
	 */
	@Override
	public Comparable getMin() {
		if (root == null)
			return null;
		TreeNode node = root;
		TreeNode[] children = node.getChildren();
		while (children[0] != null) {
			node = children[0];
			children = node.getChildren();
		}
		return node.getElements()[0];
	}

	/**
	 * checks if tree is empty by checking if a root is present
	 * 
	 * @return boolean whether the tree is empty
	 */
	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	@Override
	public void addAll(MyBTree otherTree) {
		String[] values = new String[otherTree.size()];
		otherTree.insertToFile(otherTree.root, values);
		saveStringArray(values, "insertValues.txt");
		insert("insertValues.txt");
	}

	@Override
	public void printInorder() {
		printInorderRecursively(root);
	}

	private void printInorderRecursively(TreeNode node) { // nicht
		if (node != null) {
			TreeNode[] children = node.getChildren();
			Comparable[] elements = node.getElements();
			for (int i = 0; i < children.length; i++) {
				printInorderRecursively(children[i]);
				if (i < (elements.length)) {
					if (elements[i] != null)
						print(elements[i].toString());
				}
			}
		}
	}

	@Override
	public void printPostorder() {
		printPostorderRecursively(root);
	}

	private void printPostorderRecursively(TreeNode node) {
		if (node != null) {
			TreeNode[] children = node.getChildren();
			Comparable[] elements = node.getElements();

			printPostorderRecursively(children[0]);
			for (int i = 0; i < children.length - 1; i++) {
				if (children[i + 1] != null)
					printPostorderRecursively(children[i + 1]);
				if (elements[i] != null)
					print(elements[i].toString());
			}
		}
	}

	public void printPreorder() {
		printPreorderRecursively(root);
	}

	private void printPreorderRecursively(TreeNode node) {
		if (node != null) {
			TreeNode[] children = node.getChildren();
			Comparable[] elements = node.getElements();
			for (int i = 0; i < children.length - 1; i++) {
				if (elements[i] != null)
					print(elements[i].toString());
				if (i == 0) {
					printPreorderRecursively(children[0]);
					printPreorderRecursively(children[1]);
				}
				if (children[i] != null && i > 1)
					printPreorderRecursively(children[i]);
			}
		}
	}

	@Override
	public void printLevelorder() { // levelangabe funktioniert noch nicht
		if (root != null) {
			TreeNode node = root;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.addLast(node);
			TreeNode[] children = node.getChildren();
			while (!queue.isEmpty()) {
				for (int i = 0; i < children.length; i++) {
					if (children[i] != null)
						queue.addLast(children[i]);
				}
				print(queue.poll().toString());
				if (!queue.isEmpty()) {
					node = queue.getFirst();
				}
				children = node.getChildren();
			}
		}
	}

	/**
	 * writes the elements in a tree into an array (postorder)
	 * 
	 * @param node
	 * @param values
	 */
	public void insertToFile(TreeNode node, Comparable[] values) {
		if (node != null) {
			TreeNode[] children = node.getChildren();
			Comparable[] elements = node.getElements();

			insertToFile(children[0], values);
			for (int i = 0; i < children.length - 1; i++) {
				if (children[i + 1] != null)
					insertToFile(children[i + 1], values);
				if (elements[i] != null) {
					int j = 0;
					while (j < values.length - 1 && values[j] != null) {
						j++;
					}
					values[j] = elements[i].toString();
				}
			}
		}
	}
	
	public void clear(){
		root = null;
	}

	public static void main(String[] args) {
		MyBTree tree = new MyBTree(2);
		tree.insert("insertValues.txt");
		BTree tree2 = tree.clone();
		tree2.insert(11);
		tree.printLevelorder();
		println("");
		tree.delete(5);
		tree.printLevelorder();
		

	}
}
