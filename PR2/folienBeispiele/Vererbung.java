package fileWriter;

public class Vererbung {
	public static void main(String[] args) {
		Card t = new Card();
		t.f(); // shows that construction is done
	}
}

class Tag {
	Tag(int marker) {
		System.out.println("Tag(" + marker + ")");
	}
}

class Card {
	Tag t1 = new Tag(1); // before constructor Card()

	Card() { // indicate we're in the constructor:
		System.out.println("Card()");
		t3 = new Tag(33); // reinitialize t3
	}

	Tag t2 = new Tag(2); // after constructor

	void f() {
		System.out.println("f()");
	}

	Tag t3 = new Tag(3); // at end

	
}