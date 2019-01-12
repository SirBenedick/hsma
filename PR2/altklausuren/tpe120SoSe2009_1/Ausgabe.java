package tpe120SoSe2009_1;

public class Ausgabe{
	public static void main(String[] args) {
		
		System.out.println("A a = new A(1);");
		A a = new A(1);
		System.out.println("---");
		
		System.out.println("a.m1();");
		a.m1();
		System.out.println("---");
		
		System.out.println("A uua = new Unter_Unter_A (1);");
		A uua = new Unter_Unter_A (1);
		System.out.println("---");
		
		System.out.println("a.m1()");
		uua.m1();
		System.out.println("---");
		
		System.out.println("(uua.m2();");
		uua.m2();
		System.out.println();
		
		System.out.println("b");
		//A a1 = new Unter_A (1);
		A a2 = new Unter_Unter_A(1);
		Unter_A ua = new Unter_Unter_A (1); 
		//Unter_Unter_A uub2 = a2;
		Unter_Unter_A uua2 = new Unter_Unter_A (1);
		Unter_Unter_A uub3 = (Unter_Unter_A) uua;
		
	}
}
