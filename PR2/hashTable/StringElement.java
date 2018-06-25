package hashTable;

public class StringElement implements Element {

	protected String value;

	public StringElement(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(Element e) {
		return this.value.compareTo(((StringElement) e).value);
	}

	@Override
	public void print() {
		System.out.print(value + "+");
	}

	@Override
	public Element getVal() {
		return this;
	}

	public Object clone() {
		return new StringElement(value);
	}

	public int hashCode() { // Throws null pointer if value equals null
		int hash = 0;
		for (int i = 0; i < value.length(); i++) {
			 hash = hash*31 + value.charAt(i);
		}
		return hash;
	}

	@Override
	public boolean equals(Object e) {
		return this.value.equals(((StringElement) e).value);
	}

	@Override
	public String toString() {
		return value;
	}
}
