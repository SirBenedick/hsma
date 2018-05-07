package uebung2;

import static pr.MakeItSimple.*;


public class ADTMyBinaryTree implements ADTBinaryTree {

	private ADTTreeNode root = null;

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean insert(Element e) {
		ADTTreeNode parent = null;
		ADTTreeNode child = root;

		while (child != null) {
			parent = child;
			if (e.compareTo(child.element) == 0)
				return false;
			else if (e.compareTo(child.element) < 0)
				child = child.getLeft();
			else
				child = child.getRight();
		}

		if (parent == null)
			root = new ADTTreeNode(e);
		else if (e.compareTo(parent.element) < 0) {
			parent.setLeft(new ADTTreeNode(e));
			return true;
		} else {
			parent.setRight(new ADTTreeNode(e));
		}

		return true;
	}
	
	@Override
	public boolean insert(String filename) {
		String[] StringFromFile = readStringArray(filename);
		if(StringFromFile[0].charAt(0) < '9' && StringFromFile[0].charAt(0) > '0'){
			int[] intsFromFile = readIntegerArray(filename);
			for (int i = 0; i < intsFromFile.length; i++) {
				insert(new IntElement(intsFromFile[i]));
			}
		}
		else{
			for (int i = 0; i < StringFromFile.length; i++) {
				insert(new StringElement(StringFromFile[i]));
			}
		}
		return true;
	}

	public int size() {
		ADTTreeNode node = root;
		if (node == null)
			return 0;
		return nextNodeSize(node);
	}

	private int nextNodeSize(ADTTreeNode node) {
		int size = 1;
		if (checkLeft(node))
			size += nextNodeSize(node.getLeft());
		if (checkRight(node))
			size += nextNodeSize(node.getRight());
		return size;
	}

	@Override
	public boolean saveToFile(String filename) {
		if(root.element instanceof IntElement){
			saveIntegerArray(levelorderToInt(), filename);
			return true;
		}
		else if(root.element instanceof StringElement){
			/*
			 *  makeitsimple zu dumm
			saveStringArray(levelOrderToString(), filename);
			return true;
			*/
			return false;
		}
	return false;
	}

	@Override
	public boolean contains(Element e) {
		if (root == null)
			return false;
		ADTTreeNode node = findNode(e);
		if(node != null)
			return true;
		return false;
	}

	@Override
	public int height() {
		/// return -1 if tree is empty
		if (root == null)
			return 0;
		ADTTreeNode node = root;
		return branchHeight(node);
	}

	private int branchHeight(ADTTreeNode node) {
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
	public Element getMax() {
		return getMax(root);
	}

	private Element getMax(ADTTreeNode node) {
		// return -1 if tree is empty
		if (node == null)
			return null;
		while (checkRight(node)) {
			node = node.getRight();
		}
		return node.getValue();
	}

	@Override
	public Element getMin() {
		return getMin(root);
	}

	private Element getMin(ADTTreeNode node) {
		// return -1 if tree is empty
		if (node == null)
			return null;
		while (checkLeft(node)) {
			node = node.getLeft();
		}
		return node.getValue();
	}
	
	private ADTTreeNode getMinNode(ADTTreeNode node){
		if (node == null)
			return null;
		while (checkLeft(node)) {
			node = node.getLeft();
		}
		return node;
	}

	@Override
	public boolean remove(Element e) {
		if (root == null)
			return false;
		ADTTreeNode parent = getParent(e);
		ADTTreeNode node = findNode(e);
		if(node == null)
			return false;
		// Treat nodes depending on amount of edges
		// node is leaf
		if (!checkLeft(node) && !checkRight(node)) {
			if(root == node)
				root = null;
			else{ 
				if(checkLeft(parent) && parent.getLeft().getValue().compareTo(e) == 0)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
			return true;

		}

		// One edge
		if (!checkLeft(node) && checkRight(node)) {
			if (parent.getLeft().getValue().compareTo(e) == 0) {
				parent.setLeft(node.getRight());
			} else {
				parent.setRight(node.getRight());
			}
			return true;
		}
		if (checkLeft(node) && !checkRight(node)) {
			if (parent.getRight().getValue().compareTo(e) == 0) {
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
	
	private void removeTwoEdges(ADTTreeNode node){
		ADTTreeNode parent = getParent(node.getValue());
		ADTTreeNode min = getMinNode(node.getRight());
		
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

	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	@Override
	public ADTBinaryTree addAll(ADTBinaryTree otherTree) {
		otherTree.saveToFile("./addAlltempSave.txt");
		insert("./addAlltempSave.txt");
		
		return this;
	}

	@Override
	public void printInorder() {
		printInorderRecursively(root);
	}

	private void printInorderRecursively(ADTTreeNode node) {
		if (node != null) {
			printInorderRecursively(node.getLeft());
			node.element.print();
			printInorderRecursively(node.getRight());
		}
	}

	@Override
	public void printPostorder() {
		printPostorderRecursively(root);
	}
	
	private void printPostorderRecursively(ADTTreeNode node) {
		if (node != null) {
			printPostorderRecursively(node.getLeft());
			printPostorderRecursively(node.getRight());
			node.getValue().print();
		}
	}

	@Override
	public void printPreorder() {
		printPreorderRecursively(root);
	}

	private void printPreorderRecursively(ADTTreeNode node) {
		if (node != null) {
			node.getValue().print();
			printPreorderRecursively(node.getLeft());
			printPreorderRecursively(node.getRight());
		}
	}

	@Override
	public void printLevelorder() {
		if(root.element instanceof IntElement){
			int[] values = levelorderToInt();
			for (int i = 0; i < values.length; i++) {
				print(values[i] + " ");
			}
		}
		else{
			String[] values = levelOrderToString();
			for (int i = 0; i < values.length; i++) {
				print(values[i] + "+");
			}
		}
	}
	
	private String[] levelOrderToString(){
		String[] values;
		// return Array of size 1 with -1 as value if tree is empty
		if (root == null) {
			values = new String[1];
			values[0] = "Empty";
			return values;
		}
		values = new String[size()];
		ADTLinkedList list = new ADTLinkedList();
		ADTTreeNode node = root;
		list.addLast(node);
		int i = 0;
		while (!list.isEmpty()) {
			if (checkLeft(node))
				list.addLast(node.getLeft());
			if (checkRight(node))
				list.addLast(node.getRight());
			StringElement nodeElement = (StringElement) list.getFirst().getValue().element;
			values[i] = nodeElement.value;
			list.removeFirst();
			if (!list.isEmpty())
				node = list.getFirst().getValue();
			i++;
		}
		return values;
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
		ADTLinkedList list = new ADTLinkedList();
		ADTTreeNode node = root;
		list.addLast(node);
		int i = 0;
		while (!list.isEmpty()) {
			if (checkLeft(node))
				list.addLast(node.getLeft());
			if (checkRight(node))
				list.addLast(node.getRight());
			IntElement nodeElement = (IntElement) list.getFirst().getValue().element;
			values[i] = nodeElement.value;
			list.removeFirst();
			if (!list.isEmpty())
				node = list.getFirst().getValue();
			i++;
		}
		println("Value0:");
		println(values[0]);
		return values;
	}

	public ADTBinaryTree clone() {
		ADTBinaryTree tree = new ADTMyBinaryTree();
		if(root == null)
			return tree;
		if(root.element instanceof IntElement){
			int[] values;
			print("Ist int");
			values = levelorderToInt();
			for (int i = 0; i < values.length; i++) {
				tree.insert(new IntElement(values[i]));
			}
		}
		else{
			String[] values;
			values = levelOrderToString();
			for (int i = 0; i < values.length; i++) {
				tree.insert(new StringElement(values[i]));
			}
		}
		
		return tree;
	}

	private boolean checkLeft(ADTTreeNode node) {
		if (node.getLeft() == null)
			return false;
		return true;
	}

	private boolean checkRight(ADTTreeNode node) {
		if (node.getRight() == null)
			return false;
		return true;
	}
	
	private ADTTreeNode findNode(Element e){
		return getNode(e, 0);
	}
	
	private ADTTreeNode getParent(Element e){
		return getNode(e, 1);
	}

	private ADTTreeNode getNode(Element e, int select){
		//select = 0 return node, 1 return parent
		ADTTreeNode parent = null;
		ADTTreeNode node = root;
		while (node.element.compareTo(e) != 0) {
			if (node.element.compareTo(e)>0) {
				if (checkLeft(node)) {
					parent = node;
					node = node.getLeft();
				} else
					return null;
			}
			if (node.element.compareTo(e)<0) {
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
	public ADTBinaryTree empty() {
		return new ADTMyBinaryTree();
	}
	
}
