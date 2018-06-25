package uebung02;

public class ADTTreeNode {
	
	public Element element;
	public ADTTreeNode left;
	public ADTTreeNode right;
	
	public ADTTreeNode(Element element){
		this.element = element;
		left = right = null;
 	}
	
	public ADTTreeNode getRight(){
		return right;
	}
	
	public ADTTreeNode getLeft(){
		return left;
	}
	
	public void setRight(ADTTreeNode right){
		this.right = right;
	}
	
	public void setLeft(ADTTreeNode left){
		this.left = left;
	}
	
	public Element getValue(){
		return element;
	}
}
