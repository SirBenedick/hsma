package myBinaryTree;

public class TreeNode {
	
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int value){
		this.value = value;
		left = right = null;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public int getValue(){
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
