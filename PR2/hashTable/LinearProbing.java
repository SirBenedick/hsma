package hashTable;

public class LinearProbing implements Probing {

	private int index = 0;
	
	@Override
	public void startProbing() {
		

	}
	
	@Override
	public int getNum() {
		return index;
	}
	
	@Override
	public int nextNum() {
		return index++;
	}

}
