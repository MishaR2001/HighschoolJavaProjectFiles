import java.util.Scanner;

public class QuadrantSelector {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int X = s.nextInt(); //x value
		int Y = s.nextInt(); //y value
		int Q = 0; //Quadrent

		if (X > 0 && Y > 0) {
			Q = 1;
		} else if (X < 0 && Y > 0) {
			Q = 2;
		} else if (X < 0 && Y < 0) {
			Q = 3;
		} else {
			Q = 4;
		}

		System.out.print(Q);
	}
}