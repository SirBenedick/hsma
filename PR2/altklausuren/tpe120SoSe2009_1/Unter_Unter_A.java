package tpe120SoSe2009_1;

public class Unter_Unter_A extends Unter_A {
	protected int i;

	public Unter_Unter_A(int i) {
		super(i * 2);
		this.i = i;
	}

	public void m1() {
		super.m1();
		System.out.println(i);
	}

	public void m2() {
		System.out.println(i);
	}
}