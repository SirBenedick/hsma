package uebung04;

public class PrintLevelOrderTest {

	public static void main(String[] args) {
		BTree tree = new MyBTree(2);
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.printLevelorder();
	}

}
