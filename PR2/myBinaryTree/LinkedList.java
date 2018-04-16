package myBinaryTree;

import static pr.MakeItSimple.*;

public class LinkedList {

	ListNode head = null;
	
	public void addLast(TreeNode tNode){
		ListNode newNode = new ListNode(tNode);
		if(head == null)
			head = newNode;
		else {
		ListNode lNode = head;
		while(lNode.getNext() != null){
			lNode = lNode.getNext();
		}
		lNode.setNext(newNode);
		}
	}
	
	public void printList(){
		ListNode node = head;
		while(node.getNext() != null){
			println(node.getValue().getValue());
			node = node.getNext();
		}
		println(node.getValue().getValue());
	}
	
	public ListNode getFirst(){
		return head;
	}
	
	public void removeFirst(){
		head = head.getNext();
	}
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
}
