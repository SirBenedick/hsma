package pr1.uebung10;

public class ListNode {
	ListNode next;
	private SongImplementation song;

	ListNode(SongImplementation song) {
		this.song = song;
		next = null;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public SongImplementation getSongs() {
		return song;
	}

}
