package pr1.uebung10;

import static pr.MakeItSimple.*;
import java.util.*;

public class TestClass {
	public static void main(String[] args) {
		String[] artist = new String[2];
		artist[0] = "aa";
//		artist[1] = "ab";
		OrderedList list2= new ArrayList();
//		list.insert(new SongImplementation("bb","album",artist));
//		list.insert(new SongImplementation("ab","album",artist));
//		list.insert(new SongImplementation("aa","album",artist));

		
//		OrderedList list2= new LinkedList();
		list2.insert(new SongImplementation("ba3","album1",artist));
		list2.get(0).toString();
		list2.insert(new SongImplementation("ab2","album2",artist));
//		list2.insert(new SongImplementation("az1", "album3", artist));
		
	
//		println("Komplette Liste:");
//		for (int i=0;i<list2.size();i++)
//			println(list2.get(i).getSongName());
//		
//		list2.delete(0);
//		println("Nach Delete:");
//		for (int i=0;i<list2.size();i++)
//			println(list2.get(i).getSongName());
//		println("size:");
//		println(list2.size());
//		println("Indexof:");
//		println(list2.indexOf("aa3"));
		
//		println("Komplette Liste:");
//		for (int i=0;i<list.size();i++)
//			println(list.get(i).getSongName());
//
//		println("Nach Delete:");
//		for (int i=0;i<list.size();i++)
//			println(list.get(i).getSongName());
//		println("size:");
//		println(list.size());
//		println("Indexof:");
//		println(list.indexOf("aa2"));
//		
//		
	}
}
