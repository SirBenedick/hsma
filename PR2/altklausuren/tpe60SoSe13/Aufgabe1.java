package tpeSoSe13;

class A {
	public A() {
		p();
	} // Konstruktor

	public void m() {
		System.out.println("0");
		this.p();
	}

	public void m(A a) {
		System.out.println("1");
		this.p();
	}

	public void p() {
		System.out.println("11");
	}
}

class B extends A {
	public void m(A a) {
		System.out.println("2");
		((A) this).p();
	}

	public void m(B b) {
		System.out.println("3");
	}

	public void p() {
		System.out.println("22");
	}
}

public class Aufgabe1 {
	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		
		a = b;
//		a.m(a);
//
//		a.m(b);
//		b.m((A) (b));
//		b.m(b);
//		a.m((B) a);
//		a.m();
	}
}
