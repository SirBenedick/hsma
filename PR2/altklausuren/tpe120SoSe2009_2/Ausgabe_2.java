package tpe120SoSe2009_2;


public class Ausgabe_2{
	public static void main(String[] args) {
//		System.out.print(1);
		A a = new Unter_Unter_A (1);

		System.out.println("a.m1()");
		a.m1();
		System.out.println("---");
		
		System.out.println("((A)a).m2();");
		((A)a).m2();
		System.out.println("---");
		
		
	}
}
