package myBinaryTree;

import static pr.MakeItSimple.*;

public class BinaryTreeTest {

	public static void main(String[] args) {
		MyBinaryTree baum = new MyBinaryTree();
		BinaryTree baum2 = new MyBinaryTree();
		println("Baum ist leer");
		baum.printLevelorder();
		println("einfügen");
		baum.insert("./baum.txt");
		baum2 = baum.clone();
//		baum2.insert(12);
		
		baum.printLevelorder();
//		System.out.println("");
//		baum2.printLevelorder();
//		baum2.remove(20);
//		baum2.remove(10);
//		baum2.remove(3);
//		baum2.remove(20);
//		baum2.remove(6);
//		baum2.remove(14);
		System.out.println("");
		baum2.printLevelorder();
		
//		baum2.insert("./baum2.txt");
//		baum.addAll(baum2);
//		println(baum.remove(2));
//		baum.printInorder();
//		System.out.println("-----------------");
//		baum.printPostorder();
//		System.out.println("-----------------");
//		baum.printPreorder();
//		System.out.println("-----------------");
//		baum.printLevelorder();
//		System.out.println("-----------------");
//		System.out.println(baum.isEmpty());
//		System.out.println(baum.getMax());
//		System.out.println(baum.getMin());
//		System.out.println(baum.size());
//		System.out.println(baum.contains(17));
//		System.out.println(baum.contains(50));
//		System.out.println("-----------------");
//		println(baum.height());
		
	}

}
