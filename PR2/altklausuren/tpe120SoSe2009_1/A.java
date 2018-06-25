package tpe120SoSe2009_1;

public class A {
	protected int i;

	protected void setI(int i) {
		this.i = i;
	}

	public A(int i) {
		this.setI(i);
	}

	public void m1() {
		System.out.println(i);
	}

	public void m2() {
		System.out.println(i * 2);
	}
}