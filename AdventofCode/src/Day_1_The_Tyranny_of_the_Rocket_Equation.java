import java.util.Scanner;

public class Day_1_The_Tyranny_of_the_Rocket_Equation {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int total = 0;
		// StringBuffer sbf = new StringBuffer(initF);
		for (int i = 0; i < 100; i++) { // unsure
			int initF = s.nextInt(); // works
			initF = ((initF / 3)) - 2; // works
			total += initF; // works
		}
		System.out.println(total); // works
	}
}