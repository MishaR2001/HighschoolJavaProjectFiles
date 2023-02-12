import java.util.ArrayList;

/**
 * This was a exercise in the usage of ArrayList
 * 
 * @author Misha R
 *
 */
public class ArrayListProject {

	public static void main(String[] args) {
		System.out.println("hello ArrayListProj");
		int scores[] = new int[3];
		scores[0] = 95;
		scores[1] = 88;
		scores[2] = 77;

		ArrayList<Integer> scoresList = new ArrayList<Integer>();
		scoresList.add(95);
		scoresList.add(88);
		scoresList.add(77);
		System.out.println("scoreList size is " + scoresList.size());
		System.out.println(scoresList);

		// for loop to add all elements in scoresList

		int sum = 0;
		for (int i = 0; i < scoresList.size(); i++) {
			sum += scoresList.get(i);
		}
		System.out.println("scoreList sum is " + sum);
		System.out.println("scoresList avg is " + arrayListAvg(scoresList));
		System.out.println("scoresList max is " + arrayListMax(scoresList));
		System.out.println("scoresList is " + scoresList);
		arrayListShiftLeft(scoresList);
		System.out.println("scoresList after shift left " + scoresList);
		System.out.println("scoresList hasDuplicates " + arrayListHasDuplicates(scoresList));

	}

	public static int arrayListSum(ArrayList<Integer> a) {
		int sum = 0;
		// for each loop
		// for each Integer called n in List a
		for (Integer n : a) {
			sum += n;
		}
		return sum;

	}

	// methods to write in class ArrayListProj
	public static double arrayListAvg(ArrayList<Integer> a) {

		return (double) arrayListSum(a) / a.size();
	}

	public static int arrayListMax(ArrayList<Integer> a) {
		int len = a.size();
		int maxVal = a.get(0);
		for (int i = 0; i < len; i++) {
			if (a.get(i) > maxVal) {
				maxVal = a.get(i);
			}

		}
		return maxVal;
	}

	public static void arrayListShiftLeft(ArrayList<Integer> a) {
		int temp = a.get(0);
		a.remove(0);
		a.add(temp);

	}

	public static boolean arrayListHasDuplicates(ArrayList<Integer> scoresList) {
		int len = scoresList.size();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (scoresList.get(i) == scoresList.get(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
