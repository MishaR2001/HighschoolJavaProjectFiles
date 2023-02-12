import java.util.Scanner;

public class DetailedDifferences {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int i = 0;
		while (i < N) {
			String list1 = s.next();
			String list2 = s.next();
			String result = "";
			StringBuffer sbf1 = new StringBuffer(list1);
			StringBuffer sbf2 = new StringBuffer(list2);
			for (int j = 0; j < sbf1.length(); j++) {
				if (sbf1.charAt(j) == sbf2.charAt(j)) {
					result += ".";
				} else {
					result += "*";
				}
			}
			System.out.println(sbf1);
			System.out.println(sbf2);
			System.out.println(result);
			i++;
		}
	}
}