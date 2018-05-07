package uebung2;

import static pr.MakeItSimple.*;

import myBinaryTree.MyBinaryTree;

public class ADTMyBinaryTreeTest {

	public static void main(String[] args) {
		ADTBinaryTree tree = new ADTMyBinaryTree();
		ADTBinaryTree tree2 = new ADTMyBinaryTree();
		tree.insert("Baum.txt");
		println(tree.size());
//		tree.insert(new StringElement("Hallo"));
//		tree.insert(new StringElement("Peter"));
//		tree.insert(new StringElement("Hans"));
//		tree.insert(new StringElement("Detlef"));
//		tree.insert(new StringElement("Dietmar"));
		tree2 = (ADTBinaryTree) tree.clone();
		tree.addAll(tree2);
//		tree.printInorder();
//		println("\n" + tree.height());
//		tree.printLevelorder();
//		println(tree.remove(new StringElement("Hallo")));
//		tree.printLevelorder();
//		//tree.saveToFile("../outputwirklich.txt");
//		Element i = new IntElement(24);
//		Element s = new StringElement("hans");
//		println("\n" + tree.contains(s));
//		println(tree.size()); 
//		tree.getMax().print();
//		tree.getMin().print();
//		//tree.remove(i);
//		println();
//		tree.printLevelorder();
//		ADTBinaryTree tree2 = new ADTMyBinaryTree();
//		//tree2.insert("baum2.txt");
//		println();
//		tree2.insert(s);
//		tree2.printLevelorder();
//		println();
//		//tree2.addAll(tree).printLevelorder();
//		println();
//		tree2.printInorder();
//		println();
//		tree2.printPostorder();
//		println();
//		tree2.printPreorder();
	}
//
}
