package hashTable;

public class HashElement {
	private Object value;
	private Object key;
	public boolean delete = false;
	
	public HashElement(Object key, Object value){
		this.value = value;
		this.key = key;
	}
	
	@Override
	public String toString(){
		return value.toString();
	}
	
	public Object getKey(){
		return key;
	}
	
	public Object getValue(){
		return value;
	}
}
