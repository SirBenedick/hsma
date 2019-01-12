package uebung05;

public class Box<E> {

	private E value;
	
	public void setValue(E value){
		this.value = value;
	}
	
	public E getValue(){
		return value;
	}
}
