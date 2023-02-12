package primeFun;

import java.util.Scanner;

public class PrimeFUN {

	public static int main(String[] args) {
		// TODO Auto-generated method stub
		Scanner m = new Scanner(System.in);
		boolean prime = false;
		int n = m.nextInt();
		int result = 0;
		int i = 2;
		while (i <= n / 2) {
			if (n % i == 0) {
				prime = true;
				break;
			}

			i++;
		}
		if (prime == true)
			result = ((n * n) - 1);

		if (prime == false) {
			 result = (n * n * n);
		}
		return result;

	}

}
