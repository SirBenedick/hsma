package myBinaryTree;

import static pr.MakeItSimple.*;

public class MyBinaryTree implements BinaryTree {

	private TreeNode root = null;

	@Override
	public boolean insert(int value) {
		TreeNode parent = null;
		TreeNode child = root;

		while (child != null) {
			parent = child;
			if (value == child.getValue())
				return false;
			else if (value < child.getValue())
				child = child.getLeft();
			else
				child = child.getRight();
		}

		if (parent == null)
			root = new TreeNode(value);
		else if (value < parent.getValue()) {
			parent.setLeft(new TreeNode(value));
			return true;
		} else {
			parent.setRight(new TreeNode(value));
		}

		return true;
	}

	@Override
	public boolean insert(String filename) {
		int[] intsFromFile = readIntegerArray(filename);
		for (int i = 0; i < intsFromFile.length; i++) {
			insert(intsFromFile[i]);
		}
		return false;
	}

	@Override
	public boolean contains(int value) {
		if (root == null)
			return false;
		TreeNode node = findNode(value);
		if(node != null)
			return true;
		return false;
	}

	@Override
	public int size() {
		TreeNode node = root;
		if (node == null)
			return 0;
		return nextNodeSize(node);
	}

	private int nextNodeSize(TreeNode node) {
		int size = 1;
		if (checkLeft(node))
			size += nextNodeSize(node.getLeft());
		if (checkRight(node))
			size += nextNodeSize(node.getRight());
		return size;
	}

	@Override
	public int height() {
		/// return -1 if tree is empty
		if (root == null)
			return 0;
		TreeNode node = root;
		return branchHeight(node);
	}

	private int branchHeight(TreeNode node) {
		if (checkLeft(node) && checkRight(node)) {
			if (branchHeight(node.getLeft()) < branchHeight(node.getRight())) {
				return 1 + branchHeight(node.getRight());
			} else {
				return 1 + branchHeight(node.getLeft());
			}
		}
		if (checkLeft(node) && !checkRight(node)) {
			return 1 + branchHeight(node.getLeft());
		}
		if (!checkLeft(node) && checkRight(node)) {
			return 1 + branchHeight(node.getRight());
		}
		return 1;

	}

	@Override
	public int getMax() {
		return getMax(root);
	}

	private int getMax(TreeNode node) {
		// return -1 if tree is empty
		if (node == null)
			return -1;
		while (checkRight(node)) {
			node = node.getRight();
		}
		return node.getValue();
	}

	@Override
	public int getMin() {
		return getMin(root);
	}

	private int getMin(TreeNode node) {
		// return -1 if tree is empty
		if (node == null)
			return -1;
		while (checkLeft(node)) {
			node = node.getLeft();
		}
		return node.getValue();
	}
	
	private TreeNode getMinNode(TreeNode node){
		if (node == null)
			return null;
		while (checkLeft(node)) {
			node = node.getLeft();
		}
		return node;
	}

	@Override
	public boolean remove(int value) {
		if (root == null)
			return false;
		TreeNode parent = getParent(value);
		TreeNode node = findNode(value);
		if(node == null)
			return false;
		// Treat nodes depending on amount of edges
		// node is leaf
		if (!checkLeft(node) && !checkRight(node)) {
			if (checkLeft(parent) && parent.getLeft().getValue() == value)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return true;

		}

		// One edge
		if (!checkLeft(node) && checkRight(node)) {
			if (parent.getLeft().getValue() == value) {
				parent.setLeft(node.getRight());
			} else {
				parent.setRight(node.getRight());
			}
			return true;
		}
		if (checkLeft(node) && !checkRight(node)) {
			if (parent.getRight().getValue() == value) {
				parent.setRight(node.getLeft());
			} else {
				parent.setLeft(node.getLeft());
			}
			return true;
		}

		//two edges
		 if(checkLeft(node) && checkRight(node)){
			 removeTwoEdges(node);
			 return true;
		 }
		return false;
	}
	
	private void removeTwoEdges(TreeNode node){
		TreeNode parent = getParent(node.getValue());
		TreeNode min = getMinNode(node.getRight());
		
		remove(min.getValue());
		min.setLeft(node.getLeft());
		if(node.getRight() != min)
			min.setRight(node.getRight());
		
		if(root == node)
			root = min;
		else{
			if(parent.getRight() == node)
				parent.setRight(min);
			else
				parent.setLeft(min);
		}
	}
	
	private TreeNode findNode(int value){
		return getNode(value, 0);
	}
	
	private TreeNode getParent(int value){
		return getNode(value, 1);
	}

	private TreeNode getNode(int value, int select){
		//select = 0 return node, 1 return parent
		TreeNode parent = null;
		TreeNode node = root;
		while (node.getValue() != value) {
			if (value < node.getValue()) {
				if (checkLeft(node)) {
					parent = node;
					node = node.getLeft();
				} else
					return null;
			}
			if (value > node.getValue()) {
				if (checkRight(node)) {
					parent = node;
					node = node.getRight();
				} else
					return null;
			}
		}
		if(select == 0)
			return node;
		if(select == 1)
			return parent;
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	public void addAll(BinaryTree otherTree) {
		otherTree.saveToFile("./addAlltempSave.txt");
		insert("./addAlltempSave.txt");
	}

	@Override
	public void printInorder() {
		printInorderRecursively(root);
	}

	private void printInorderRecursively(TreeNode node) {
		if (node != null) {
			printInorderRecursively(node.getLeft());
			print(node.getValue() + " ");
			printInorderRecursively(node.getRight());
		}
	}

	@Override
	public void printPostorder() {
		printPostorderRecursively(root);
	}

	private void printPostorderRecursively(TreeNode node) {
		if (node != null) {
			printPostorderRecursively(node.getLeft());
			printPostorderRecursively(node.getRight());
			print(node.getValue() + " ");
		}

	}

	@Override
	public void printPreorder() {
		printPreorderRecursively(root);
	}

	private void printPreorderRecursively(TreeNode node) {
		if (node != null) {
			print(node.getValue() + " ");
			printPreorderRecursively(node.getLeft());
			printPreorderRecursively(node.getRight());
		}
	}

	@Override
	public void printLevelorder() {
		int[] values = levelorderToInt();
		for (int i = 0; i < values.length; i++) {
			print(values[i] + " ");
		}
	}

	public int[] levelorderToInt() {
		int[] values;
		// return Array of size 1 with -1 as value if tree is empty
		if (root == null) {
			values = new int[1];
			values[0] = -1;
			return values;
		}
		values = new int[size()];
		LinkedList list = new LinkedList();
		TreeNode node = root;
		list.addLast(node);
		int i = 0;
		while (!list.isEmpty()) {
			if (checkLeft(node))
				list.addLast(node.getLeft());
			if (checkRight(node))
				list.addLast(node.getRight());
			values[i] = list.getFirst().getValue().getValue();
			list.removeFirst();
			if (!list.isEmpty())
				node = list.getFirst().getValue();
			i++;
		}
		return values;
	}

	@Override
	public BinaryTree clone() {
		BinaryTree tree = new MyBinaryTree();
		int[] values = levelorderToInt();
		for (int i = 0; i < values.length; i++) {
			tree.insert(values[i]);
		}
		return tree;
	}

	private boolean checkLeft(TreeNode node) {
		if (node.getLeft() == null)
			return false;
		return true;
	}

	private boolean checkRight(TreeNode node) {
		if (node.getRight() == null)
			return false;
		return true;
	}

	@Override
	public void saveToFile(String filename) {
		saveIntegerArray(levelorderToInt(), filename);
	}

	@Override
	public void clear() {
		root = null;
	}
}
