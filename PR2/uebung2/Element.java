package uebung2;

public interface Element {
    
// interface for different kinds of elements
	
	public int compareTo(Element e);
	public Object clone();
	public void print();
	public Element getVal();

}