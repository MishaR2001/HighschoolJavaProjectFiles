import java.util.Scanner;

public class SumKindOfProblem {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int S1 = 0;
		int S2 = 0;
		int S3 = 0;
		int P = s.nextInt();

		for (int i = 0; i < P; i++) {
			int K = s.nextInt();
			int N = s.nextInt();
			S1 = ((N * (N + 1)) / 2); // sum of all positive numbers
			S2 = (N * N); // sum of all odd numbers
			S3 = (N * N) + N; // sum of all even numbers wrong
			System.out.println(K + " " + S1 + " " + S2 + " " + S3);
		}
	}
}