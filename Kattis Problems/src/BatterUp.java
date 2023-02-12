import java.util.ArrayList;
import java.util.Scanner;

public class BatterUp {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int NegCount = 0;
		int sum = 0;
		Double Avg = 0.0;
		ArrayList<Integer> Hits=new ArrayList<Integer>();
		for(int i=0;i<N;i++) { 
			int H = s.nextInt();
			if(H>=0) { 
				Hits.add(H);
			}else { 
				NegCount++;
			}
		}
		for(int j=0;j<Hits.size();j++) { 
			sum+=Hits.get(j);
		}
		Avg = ((double)sum/((double)(N-NegCount)));
		System.out.println(Avg);
	}
}