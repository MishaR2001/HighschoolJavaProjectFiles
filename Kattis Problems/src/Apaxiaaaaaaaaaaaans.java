import java.util.ArrayList;
import java.util.Scanner;

public class Apaxiaaaaaaaaaaaans {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String Name = s.next();

		StringBuffer sbf = new StringBuffer(Name);

		for (int i = 0; i < sbf.length()-1; i++) {
			if (sbf.charAt(i) == sbf.charAt(i + 1)) {
				sbf.deleteCharAt(i+1);
				i--;
			}
		}
		System.out.println(sbf);
	}
}