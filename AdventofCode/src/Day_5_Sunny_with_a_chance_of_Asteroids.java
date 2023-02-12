import java.util.Arrays;
import java.util.Scanner;


public class Day_5_Sunny_with_a_chance_of_Asteroids {
	public static void main(String arg[]) {
		Scanner s = new Scanner(System.in);
		int list[] = { };
		int sum = 0;
		int product = 0;
		for (int i = 0; i < list.length; i += 4) {
			if (list[i] == 1) {
				System.out.println(Arrays.toString(list));
				sum = list[list[i + 1]] + list[list[i + 2]];
				list[list[i + 3]] = sum;
				sum = 0;
				System.out.println(Arrays.toString(list));
			}
			if (list[i] == 2) {
				System.out.println(Arrays.toString(list));
				product = list[list[i + 1]] * list[list[i + 2]];
				list[list[i + 3]] = product;
				product = 0;
				System.out.println(Arrays.toString(list));
			}
			if (list[i] == 3) 
				[list[list[i]]] = list[i];
			
			if (list[i] == 99) 
				break;
			
		}
		System.out.println("list[0] = " + list[0]);
		System.out.println("the lenght is " + list.length);

}
}
