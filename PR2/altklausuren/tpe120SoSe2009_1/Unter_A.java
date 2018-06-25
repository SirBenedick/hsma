package tpe120SoSe2009_1;

abstract class Unter_A extends A {
	protected int i;

	public Unter_A (int i) {
		super(i * 2);
		this.i = i;
	}

	public void m1() {
		super.m1();
		System.out.println(i);
	}

	abstract public void m2();
}
