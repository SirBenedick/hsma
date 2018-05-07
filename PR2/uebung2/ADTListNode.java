package uebung2;

public class ADTListNode {
	
	private ADTTreeNode node;
	private ADTListNode next;

	public ADTListNode(ADTTreeNode node){
		this.node = node;
	}
	
	public ADTListNode getNext(){
		return next;
	}
	public void setNext(ADTListNode node){
		this.next = node;
	}
	public ADTTreeNode getValue(){
		return node;
	}
}
