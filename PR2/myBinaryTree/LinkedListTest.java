package myBinaryTree;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(12);
		TreeNode node4 = new TreeNode(16);
		TreeNode node5 = new TreeNode(3);
		list1.addLast(node1);
		list1.addLast(node2);
		list1.addLast(node3);
		list1.addLast(node4);
		list1.addLast(node5);
		list1.removeFirst();
		list1.printList();
	}
}
