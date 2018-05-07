package uebung2;

import static pr.MakeItSimple.*;

public class ADTLinkedList {

	ADTListNode head = null;
	
	public void addLast(ADTTreeNode tNode){
		ADTListNode newNode = new ADTListNode(tNode);
		if(head == null)
			head = newNode;
		else {
		ADTListNode lNode = head;
		while(lNode.getNext() != null){
			lNode = lNode.getNext();
		}
		lNode.setNext(newNode);
		}
	}
	
	public void printList(){
		ADTListNode node = head;
		while(node.getNext() != null){
			node.getValue().getValue().print();
			node = node.getNext();
		}
		node.getValue().getValue().print();
	}
	
	public ADTListNode getFirst(){
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
