package uebung02;

public class StringElement implements Element {

	protected String value;
	
	public StringElement(String value){
		this.value = value;
	}
	@Override
	public int compareTo(Element e) {
		return this.value.compareTo(((StringElement)e).value);
	}

	@Override
	public void print() {
		System.out.print(value + "+");
	}

	@Override
	public Element getVal() {
		return this;
	}
	
	public Object clone(){
		return new StringElement(value);
	}

}
