package uebung04;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class BTreeTest {


	BTree tree = new MyBTree(2);
	@Before
	public void setUp() throws Exception {
		BTree tree = new MyBTree(2);
		BTree tree2 = new MyBTree(2);
	}

	@Test
	public void insert18andDown() {
		
		 final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outContent));
		 
		for (int i = 18; i > 0; i--) {
			assertEquals(true, tree.insert(i));
		}
		assertEquals(true, tree.contains(18));
		assertEquals(false, tree.insert(12));
		tree.printInorder();
		assertEquals("123456789101112131415161718",outContent.toString());
		System.out.println();
	}
	@Test
	public void insertNull() {
		assertEquals(false, tree.insert(null));
		 
		 
		 
	}
	

}
