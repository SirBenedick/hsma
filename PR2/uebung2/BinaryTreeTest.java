package uebung2;

import static org.junit.Assert.assertEquals;
import java.lang.invoke.MethodHandles;
import org.junit.Test;

public class BinaryTreeTest {

	private ADTBinaryTree tree1 = new ADTMyBinaryTree();
	private ADTBinaryTree tree2 = new ADTMyBinaryTree();
	private ADTMyBinaryTree tree3 = new ADTMyBinaryTree();

	@Test
	public void demoDatei() throws Exception {
		String filename = "treeInput.txt";
//		tree1.insert(new IntElement(10));   // nur für vereinfachte Tests
		assertEquals(true, tree1.insert(filename));
		assertEquals(true, tree1.insert(filename));
		assertEquals(16, tree1.size());
		assertEquals(6, tree1.height());
		assertEquals(0, tree1.getMax().compareTo(new IntElement(80)));
		assertEquals(0, tree1.getMin().compareTo(new IntElement(1)));
		assertEquals(false, tree1.remove(new IntElement(31)));
		assertEquals(false, tree1.isEmpty());
		assertEquals(false, tree1.contains(new IntElement(3)));
		assertEquals(true, tree1.contains(new IntElement(30)));
		tree3 = (ADTMyBinaryTree) tree1.clone();

		tree3.remove(new IntElement(10));
		assertEquals(false, tree3.contains(new IntElement(10)));
		assertEquals(true, tree1.contains(new IntElement(10)));

		tree1.remove(new IntElement(40));
		assertEquals(15, tree1.size());
		assertEquals(6, tree1.height());

		tree1.remove(new IntElement(30));
		assertEquals(14, tree1.size());
		assertEquals(5, tree1.height());

		tree1.remove(new IntElement(35));
		assertEquals(13, tree1.size());
		assertEquals(5, tree1.height());

		tree1.clear();
		assertEquals(0, tree1.size());
		
//		tree1.insert(new IntElement(10));   // nur für vereinfachte Tests

		tree1.insert(filename);
		tree2 = (ADTBinaryTree) tree1.clone();
		//tree1.addAll(tree2);
		assertEquals(tree1.size(), tree2.size());

//		 assertEquals(false, tree1.clone().isEmpty());
//		 assertEquals(true, tree1.remove(10));
//		 assertEquals(true, tree1.isEmpty());
//		 assertEquals(false, tree1.contains(10));
//		 assertEquals(true, tree1.clone().isEmpty());
	}

	@Test
	public void testsOnEmpty() {
		assertEquals(0, tree1.size());
		assertEquals(0, tree1.height());
		assertEquals(null, tree1.getMax());
		assertEquals(null, tree1.getMin());
		assertEquals(false, tree1.remove(new IntElement(1)));
		assertEquals(true, tree1.isEmpty());
		assertEquals(false, tree1.contains(new IntElement(1)));
		assertEquals(true, ((ADTBinaryTree) tree1.clone()).isEmpty());
	}

	@Test
	public void insertOnlyOneElement() {
		tree1.insert(new IntElement(10));
		assertEquals(1, tree1.size());
		assertEquals(1, tree1.height());
		assertEquals(0, tree1.getMax().compareTo(new IntElement(10)));
		assertEquals(0, tree1.getMin().compareTo(new IntElement(10)));
		assertEquals(false, tree1.remove(new IntElement(1)));
		assertEquals(false, tree1.isEmpty());
		assertEquals(false, tree1.contains(new IntElement(1)));
		assertEquals(true, tree1.contains(new IntElement(10)));
		assertEquals(false, ((ADTBinaryTree) tree1.clone()).isEmpty());
		assertEquals(true, tree1.remove(new IntElement(10)));
		assertEquals(true, tree1.isEmpty());
		assertEquals(false, tree1.contains(new IntElement(10)));
		assertEquals(true, ((ADTBinaryTree) tree1.clone()).isEmpty());
	}

	@Test
	public void demoDateiStrings() throws Exception {
		String filename = "treeInputStrings.txt";
//		tree1.insert(new StringElement("Hans")); // damit die Tests klappen
		assertEquals(true, tree1.insert(filename));
		//assertEquals(false, tree1.insert(filename));
		assertEquals(16, tree1.size());
		assertEquals(6, tree1.height());
		assertEquals(0, tree1.getMax().compareTo(new StringElement("Willy")));
		assertEquals(0, tree1.getMin().compareTo(new StringElement("Andrea")));
		assertEquals(false, tree1.remove(new StringElement("Willi")));
		assertEquals(false, tree1.isEmpty());
		assertEquals(false, tree1.contains(new StringElement("Willibald")));
		assertEquals(true, tree1.contains(new StringElement("Lothar")));
		tree3 = (ADTMyBinaryTree) tree1.clone();

		tree3.remove(new StringElement("Hans"));
		assertEquals(false, tree3.contains(new StringElement("Hans")));
		assertEquals(true, tree1.contains(new StringElement("Hans")));

		tree1.remove(new StringElement("Rolf"));
		assertEquals(15, tree1.size());
		assertEquals(6, tree1.height());

		tree1.remove(new StringElement("Norbert"));
		assertEquals(14, tree1.size());
		assertEquals(5, tree1.height());

		tree1.remove(new StringElement("Paul"));
		assertEquals(13, tree1.size());
		assertEquals(5, tree1.height());

		tree1.clear();
		assertEquals(0, tree1.size());

//		tree1.insert(new StringElement("Hans"));   // nur für vereinfachte Tests

		tree1.insert(filename);
		tree2 = (ADTBinaryTree) tree1.clone();
		tree1.addAll(tree2);
		assertEquals(tree1.size(), tree2.size());

		// assertEquals(false, tree1.clone().isEmpty());
		// assertEquals(true, tree1.remove(10));
		// assertEquals(true, tree1.isEmpty());
		// assertEquals(false, tree1.contains(10));
		// assertEquals(true, tree1.clone().isEmpty());
	}

	@Test
	public void testsOnEmptyStrings() {
		assertEquals(0, tree1.size());
		assertEquals(0, tree1.height());
		assertEquals(null, tree1.getMax());
		assertEquals(null, tree1.getMin());
		assertEquals(false, tree1.remove(new StringElement("Hans")));
		assertEquals(true, tree1.isEmpty());
		assertEquals(false, tree1.contains(new StringElement("Hans")));
		assertEquals(true, ((ADTBinaryTree) tree1.clone()).isEmpty());
	}

	@Test
	public void insertOnlyOneElementStrings() {
		tree1.insert(new StringElement("Hans"));
		assertEquals(1, tree1.size());
		assertEquals(1, tree1.height());
		assertEquals(0, tree1.getMax().compareTo(new StringElement("Hans")));
		assertEquals(0, tree1.getMin().compareTo(new StringElement("Hans")));
		assertEquals(false, tree1.remove(new StringElement("Hansi")));
		assertEquals(false, tree1.isEmpty());
		assertEquals(false, tree1.contains(new StringElement("Hansi")));
		assertEquals(true, tree1.contains(new StringElement("Hans")));
		assertEquals(false, ((ADTBinaryTree) tree1.clone()).isEmpty());
		assertEquals(true, tree1.remove(new StringElement("Hans")));
		assertEquals(true, tree1.isEmpty());
		assertEquals(false, tree1.contains(new StringElement("Hans")));
		assertEquals(true, ((ADTBinaryTree) tree1.clone()).isEmpty());
	}


}

