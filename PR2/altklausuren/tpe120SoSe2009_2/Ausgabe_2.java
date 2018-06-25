package tpe120SoSe2009_2;


public class Ausgabe_2{
	public static void main(String[] args) {
//		System.out.print(1);
		A a = new A(1);
		System.out.println("a.m1()");
		a.m1();
		System.out.println("---");
		
		System.out.println("Unter_Unter_A uua = new Unter_Unter_A (1);");
		Unter_Unter_A uua = new Unter_Unter_A (1);
		System.out.println();
		
		System.out.println("uua.m1();");
		uua.m1();
		System.out.println("---");
		
		System.out.println("uua.m2();");
		uua.m2();
		System.out.println("---");
	}
}
