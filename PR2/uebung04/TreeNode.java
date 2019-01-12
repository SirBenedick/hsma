package uebung04;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TreeNode implements Cloneable {
	private TreeNode father = null;
	private Comparable[] elements;
	private TreeNode[] children;
	private int order;

	public TreeNode(int order) {
		this.order = order;
		elements = new Comparable[order * 2 + 1];
		children = new TreeNode[order * 2 + 2];
	}
	/**
	 * clones the node
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * @return elements in a node
	 */
	public Comparable[] getElements() {
		return elements;
	}

	/**
	 * 
	 * @return children in a node
	 */
	public TreeNode[] getChildren() {
		return children;
	}

	/**
	 * 
	 * @param o
	 *            - value to be inserted
	 * @return	null if no new root, TreeNode new root
	 */
	public TreeNode insert(Comparable o) {
		// Determine Position in node where element needs to be inserted
		int pos = 0;
		while (elements[pos] != null && o.compareTo(elements[pos]) > 0) {
			pos++;
		}
		// shift elements right if position is already present
		if (elements[pos] != null) {
			Comparable[] tempElements = new Comparable[elements.length];
			tempElements[pos] = o;
			int t = 0;
			for (int i = 0; i < tempElements.length; i++) {
				if (tempElements[i] == null) {
					tempElements[i] = elements[t];
					t++;
				}
			}
			elements = tempElements;
		} else {
			elements[pos] = o;
		}
		if (elements[elements.length - 1] != null) {
			return split();
		}
		return null;
	}

	/**
	 * handles the splitting of a node when it exceeds the limit of the maximum
	 * contained elements by creating a new sibling of the node and moving
	 * values into it as well as placing one value in the father of the nodes
	 * 
	 * @return returns the root of the tree if there is a new one, else null
	 */
	private TreeNode split() {
		int middleIndex = elements.length / 2;
		Comparable middleElement = elements[middleIndex];

		// split node in two and copy right elements into a new node
		TreeNode rightNode = new TreeNode(order);
		for (int i = middleIndex + 1; i < children.length; i++) {
			if (i < elements.length)
				rightNode.insert(elements[i]);
			if (children[i] != null) {
				rightNode.setChild(children[i]);
				rightNode.getChild(i - middleIndex - 1).setFather(rightNode);
			}
			if (i < elements.length)
				elements[i] = null; // delete right elements from current node
			children[i] = null;

		}
		children[middleIndex + 1] = null;
		elements[middleIndex] = null;

		if (father == null)

		{
			father = new TreeNode(order);
			father.insert(middleElement);
			father.setChildren(this, rightNode);
			rightNode.setFather(father);
			return father;
		}

		int i = 0;
		while (children[i] != null) {
			i++;
		}
		rightNode.setChild(children[i]);
		children[i] = null;

		father.setChildren(this, rightNode);
		rightNode.setFather(father);

		TreeNode tempRoot = father.insert(middleElement);
		if (tempRoot == null)
			return null;
		while (tempRoot.getFather() != null)
			tempRoot.setFather(tempRoot.getFather());
		return tempRoot;
	}
	/**
	 * 
	 * @param o - value to be deleted
	 * @returns root if there is a new one, else null
	 */
	public TreeNode delete(Comparable o) {
		int i = 0;
		while (elements[i] != null && o.compareTo(elements[i]) != 0)
			i++;
		elements[i] = null;
		if (isLeaf()) {
			Comparable[] tempElements = new Comparable[elements.length];
			int pos = 0;
			for (int j = 0; j < tempElements.length; j++) {
				if (elements[j] != null)
					tempElements[pos++] = elements[j];
			}
			elements = tempElements;
			int amountElements = 0;
			while (elements[amountElements] != null)
				amountElements++;
			if (amountElements < order)
				return handleDeficit(o);
		}
		TreeNode node = this;
		while (node.getFather()!= null)
			node = node.getFather();
		return node;
	}
	/**
	 * 
	 * @param o - value to be deleted
	 * @return root if there is a new one, else null
	 */
	private TreeNode handleDeficit(Comparable o) {
		// Choose sibling, if node is the child on the right choose left node as
		// sibling;
		int pos = 0;
		while (father.getElements()[pos] != null && o.compareTo(father.getElements()[pos]) > 0)
			pos++;
		TreeNode sibling;
		if (father.getChild(pos + 1) != null)
			sibling = father.getChild(pos + 1);
		else {
			pos--;
			sibling = father.getChild(pos);
		}

		Comparable elementFather = father.getElements()[pos];

		if (sibling.getElements()[order] != null) {
			Comparable elementSibling = sibling.getElements()[0];
			sibling.delete(elementSibling);
			father.delete(o);
			father.insert(elementSibling);
			insert(elementFather);
		} else {
			father.delete(elementFather);
			Comparable[] elementsSibling = sibling.getElements();
			for (int i = 0; i < elementsSibling.length / 2; i++) {
				insert(elementsSibling[i]);
			}
			insert(elementFather);
			if (father.getElements()[0] == null) {
				setFather(null);
				return this;
			}
		}
		TreeNode node = this;
		while (node.getFather()!= null)
			node = node.getFather();
		return node;

	}

	/**
	 * 
	 * @param elements
	 */
	public void setElements(Comparable[] elements) {
		this.elements = elements;
	}
	/**
	 * 
	 * @param children
	 */
	public void setChildren(TreeNode[] children) {
		this.children = children;
	}
	/**
	 * 
	 * @return true if the node is a leaf, false if not
	 */
	private boolean isLeaf() {
		if (children[0] == null)
			return true;
		return false;
	}

	private TreeNode getChild(int i) {
		return children[i];
	}

	private void setChild(TreeNode node) {
		int i = 0;
		while (children[i] != null) {
			i++;
		}
		children[i] = node;
	}

	public TreeNode getFather() {
		return father;
	}

	private void setFather(TreeNode father) {
		this.father = father;
	}
	/**
	 * sets the given two nodes in the most right spots possible 
	 * @param leftNode
	 * @param rightNode
	 */
	private void setChildren(TreeNode leftNode, TreeNode rightNode) {
		Comparable[] leftElements = leftNode.getElements();
		int pos = 0;
		for (int i = 0; i < leftElements.length; i++) {
			if (elements[i] != null && leftElements[0].compareTo(elements[i]) > 0)
				pos++;
		}
		if (children[pos] == null) {
			children[pos] = leftNode;
			children[pos + 1] = rightNode;
		} else {
			TreeNode[] tempChildren = new TreeNode[children.length];
			tempChildren[pos + 1] = rightNode;

			int index = 0;
			for (int i = 0; i < tempChildren.length; i++) {
				if (tempChildren[i] == null) {
					tempChildren[i] = children[index];
					index++;
				}
			}
			children = tempChildren;
		}
	}
	/**
	 * prints the node's elements to a String (no blanks)
	 */
	@Override
	public String toString() {
		String values = "";
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null)
				values += elements[i].toString();
		}
		return values;
	}

}
