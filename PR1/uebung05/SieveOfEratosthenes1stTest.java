package pr1.uebung05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SieveOfEratosthenes1stTest {

	@Test
	public void zeroIsNotPrime() {
		boolean[] primeMarkers = SieveOfEratosthenes.calculatePrimes(10);
		assertFalse(primeMarkers[0]);
	}

	@Test
	public void twoPrimesInARow() {
		boolean[] primeMarkers = SieveOfEratosthenes.calculatePrimes(3);
		assertEquals(4, primeMarkers.length);
		assertTrue(primeMarkers[2]);
		assertTrue(primeMarkers[3]);
	}

}