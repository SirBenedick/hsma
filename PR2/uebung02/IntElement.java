package uebung02;

public class IntElement implements Element {
	
	protected int value;

	public IntElement(int value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(Element e) {
		if(!(e instanceof IntElement)){
			throw new IllegalArgumentException();
		} else {
			return this.value - ((IntElement)e).value;
		}
	}
	@Override
	public void print() {
		System.out.print(value);
	}

	@Override
	public Element getVal() {
		return this;
	}

	public Object clone() {
		return new IntElement(value);
	}
}
