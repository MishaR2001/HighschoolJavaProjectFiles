import java.util.ArrayList;
import java.util.Scanner;

public class Parking{ 
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in); //note need to do range times two
		int T = s.nextInt();
		int i = 0;
		while(i<T){ 
			int maxVal = 0;
			int minVal =0;
			int N = s.nextInt();
			String tempList = s.next();
			ArrayList<String> list=new ArrayList<String>(N);
			for(int j = 0;j<list.size();j++){ 
				String tempy = tempList.substring(j);
				list.add(tempy);
			}
			ArrayList<Integer> list2 = new ArrayList<Integer>(); 
			for(String str : list){ 
				list2.add(Integer.parseInt(str));
			}
			System.out.println(list);
			i++;
		}
	}
}