import java.util.Scanner;

public class Ladder {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int H = s.nextInt();
		int V = s.nextInt();
		double V2 = Math.toRadians(V);
		int Ladder = (int) (H / (Math.sin(V2)));
		System.out.println(Ladder + 1);

	}
}