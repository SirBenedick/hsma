package pr1.uebung10;

import static pr.MakeItSimple.*;
import java.util.*;

public class LinkedList implements OrderedList {

	private ListNode head;

	public void insert(SongImplementation song) {
		ListNode songList = new ListNode(song);
		songList.setNext(head);
		head = songList;
	}

	public int indexOf(String songName) {
		int index = 0;
		ListNode current = head;

		while (current != null) {
			if (current.getSongs().getSongName().equals(songName)) {
				return index;
			}
			index++;
			current = current.next;
		}

		return -1;
	}

	@Override
	public void delete(int position) throws PRException {
		ListNode current = head;
		if (head == null) {
			throw new PRException("Liste ist leer");
		} // liste ist leer
		if (position == 0) {
			head = current.next;
			return;
		}
		if (position >= size() || position < 0)
			throw new PRException("Position exisitiert nicht");
		for (int count = 0; count < position - 1; count++) {
			current = current.next;
		}
		current.next = current.next.next;
	}

	public int size() {
		int size = 0;
		for (ListNode n = head; n != null; n = n.getNext())
			size++;
		return size;
	}

	public Song get(int position) throws PRException {
		if (position >= size() || position < 0 || head == null) {
			throw new PRException("position exisitiert nicht");
		} else {
			ListNode current = head;
			for (int count = 0; count <= position; count++, current = current.getNext())
				if (count == position) {
					return current.getSongs();
				}
		}
		throw new PRException("Fehler");
	}

}
