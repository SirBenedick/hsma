package tpe120SoSe2009_3;

public class Exceptions {

	public void a1(int start, int end) {
		int failures = 0;
		for (int i = start; i < end; i++) {
			try {
				if (i % 4 == 0 || 4 / i == -1)
					throw new RuntimeException("A1 No foo");
				if (i % 2 == 0)
					throw new RuntimeException("A1 No bar");
			} catch (RuntimeException e) {
				System.out.println("A1: try failed: " + e.getMessage());
				failures++;
				if (failures >= 3)
					throw new RuntimeException("A1: 3 times");
			} finally {
				System.out.println("A1 done with " + i);
			}
		}
		throw new RuntimeException("A1: Catch me");
	}

	public void a2() {
		a1(3, 15);
	}

	public void a3() throws Exception {
		try {
			a1(0, 2);
		} catch (Exception e) {
			System.out.println("A3: A1: " + e.getMessage());
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		Exceptions eo = new Exceptions();
		try {
			try {
				eo.a2();
			} catch (Exception e) {
				System.out.println("Main: A2 threw Exception: " + e.getMessage());
			}
			eo.a3();
		} catch (Exception e) {
			System.out.println("Main: An exception occured ");
			e.printStackTrace(System.out);
			System.out.println("Main: I am going to rethrow it now.");
			throw e;
		} finally {
			System.out.println("Bye");
		}
	}

}