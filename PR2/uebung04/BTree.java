package uebung04;

public interface BTree {

	public boolean insert(Comparable o);
	
	public boolean insert(String filename);
	
	public boolean contains(Comparable o);
	
	public void delete(Comparable obj);
	
	public int size();
	
	public int height();
	
	public Comparable getMax();
	
	public Comparable getMin();
	
	public boolean isEmpty();
	
	public void addAll(MyBTree otherTree);
	
	public void printInorder();
	
	public void printPostorder();
	
	public void printPreorder();
	
	public void printLevelorder();
	
}
