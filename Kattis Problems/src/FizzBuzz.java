import java.util.Scanner;

public class FizzBuzz {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int X = s.nextInt();
		int Y = s.nextInt();
		int N = s.nextInt();
		for (int i = 1; i < N + 1; i++) {
			String result = " ";
			if (i % X == 0 && i % Y == 0) {
				result = "FizzBuzz";
			} else if (i % X == 0) {
				result = "Fizz";
			} else if (i % Y == 0) {
				result = "Buzz";
			} else {
				result = Integer.toString(i);
			}
			System.out.println(result);
		}
	}
}