package fileWriter;

public class Konstruktor {
	public static void main(String[] args) {
		Class001 c1 = new Class001(7);
		// call 2nd constructor
		c1.print();
	}
}

class Class000 {
	protected int a; // attribut visible in all

	Class000() {// mandatory parameterless constructor
		a = 10;
		System.out.println("Constructor Class000");
	}
}

class Class001 extends Class000 {
	int i, j;

	Class001(int i, int j) { // 1stconstructor
		System.out.println("Constructor 1 Class001");
		this.i = i;
		this.j = j * a; // access to superclass attribute
	}

	Class001(int i) {// 2nd constructor
		this(i, i * i); // call 1st constructor
		System.out.println("Constructor 2 Class001");
	}

	void print() {
		System.out.println("i= " + i + ",j= " + j);
	}
}