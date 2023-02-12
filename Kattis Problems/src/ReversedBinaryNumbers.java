import java.util.Scanner;

public class ReversedBinaryNumbers {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String Binary1 = Integer.toBinaryString(N);
		StringBuffer sbf = new StringBuffer(Binary1);
		sbf.reverse();
		String Binary2 = sbf.toString();
		int decimal = Integer.parseInt(Binary2, 2);
		System.out.println(decimal);

	}

}