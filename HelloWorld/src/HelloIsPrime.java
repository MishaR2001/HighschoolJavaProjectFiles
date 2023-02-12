import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * HelloIsPrime is an algorithm efficiency task.. a timed challenge.. see how
 * fast you can get your algorithm to count the number of primes from 2 to
 * 250000
 */

public class HelloIsPrime {

	public static void main(String[] args) {
		int upperBound = 250000;
		System.out.println("Determining the number of primes between 2 and " + upperBound + "...");
		System.out.println("This may take a few seconds...\n");

		long curTime = System.currentTimeMillis();

		int primeCounter = 1; // presume 2 is prime

		for (int i = 3; i < upperBound; i = i + 1) {
			if (isPrime(i)) {
				primeCounter++;
			}
		}

		System.out.println("" + primeCounter + " primes from 2 to " + upperBound);
		double elapsedTime = (System.currentTimeMillis() - curTime) / 1000.0;
		System.out.println("It took " + elapsedTime + " seconds\n");

	}

	/**
	 * return true if n is prime, false otherwise (precondition: n >= 3)
	 */

	public static boolean isPrime(int n) {
		for (int i = 2; i * i < n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}