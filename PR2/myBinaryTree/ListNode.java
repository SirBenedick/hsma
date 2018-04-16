package myBinaryTree;

public class ListNode {
	
	private TreeNode node;
	private ListNode next;

	public ListNode(TreeNode node){
		this.node = node;
	}
	
	public ListNode getNext(){
		return next;
	}
	public void setNext(ListNode node){
		this.next = node;
	}
	public TreeNode getValue(){
		return node;
	}
}
