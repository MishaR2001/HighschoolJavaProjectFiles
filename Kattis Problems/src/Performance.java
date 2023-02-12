import java.util.Scanner;
public class Performance {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int H = s.nextInt();
		int V = s.nextInt();
		double V2 = Math.toRadians(V);
		int Ladder = ((int) (H / (Math.sin(V2)))) + 1;
		System.out.println(Ladder);
		String Binary1 = Integer.toBinaryString(Ladder);
		System.out.println(Binary1); //ladder to binary
		StringBuffer Binary2 = new StringBuffer(Binary1);
		for (int i = 0; i < Binary2.length() - 1; i++) {
			if (Binary2.charAt(i) == Binary2.charAt(i + 1)) {
				Binary2.deleteCharAt(i + 1);
				i--;
			}
		}//results in the 2nd binary string
		System.out.println(Binary2);
		String B2Count = Binary2.toString();//binary2 to string
		int D2 = Integer.parseInt(B2Count, 2);//Binary2 to int
		System.out.println(D2);
		System.out.println(Ladder - D2);
	}
}