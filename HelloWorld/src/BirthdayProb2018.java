public class BirthdayProb2018 {

	public static void main(String[] args) {

		System.out.println("Birthday Problem!");
		System.out.println("What is the probability that two students "
				+ "in a class of 30\nshare the same birthday (month & day only)?");

		int numTrials = 10000;  //original value was 10000
		int numSuccessfulTrials = 0;
		int numStudents = 30;  //original value was 30
		int birthdays[] = new int[numStudents];

		for (int trial = 1; trial <= numTrials; trial++) {

			// 0.
			// implement the method fillWithRandomFrom1to365
			fillWithRandomFrom1to365(birthdays);

			// 1.
			// implement the hasDuplicates method .. using your code from codingBat

			// 2.
			// increment numSuccessfulTrials
			// if the birthdays array has a duplicate value
			// (hint: invoke the hasDuplicates method)
			if (hasDuplicates(birthdays)) {
				numSuccessfulTrials++;
			}

		}

		double percent = ((double)numSuccessfulTrials / numTrials)*100; // was 0.0
		// 3.
		// calculate the percent of trials in which
		// the birthdays array had a duplicate value (i.e. successfulTrial)

		percent = (int) (10.0 * percent + 0.5) / 10.0;
		System.out.println("\nThe probability is  " + percent + "%");

		//String X = " "; 
		
		// ** ULTRA MEGA BONUS **
		// write yet another loop to
		// output the probabilities for classes of 2,3,4,5 .. 50 students
		// as a String of X's
		// example:
		// 2 - - 0.2%
		// 3 - XX - 2.1%
		// 4 - XXXXX - 5.8%
		// ...
		// ...
		// 49 - XXXXXXXXXXXXXXXXXXXXX - 21.4%
		// 50 - XXXXXXXXXXXXXXXXXXXXXXX - 23.9%

	}

	/**
	 * assigns a random integer from 1 to 365 inclusive to each element in nums
	 */
	public static void fillWithRandomFrom1to365(int nums[]) {
	for (int i = 0; i<nums.length;i++) {
		nums[i] =(int)(Math.random()*365)+1; 
	}
	}

	/**
	 * return false if all values in nums are unique, true otherwise
	 */
	public static boolean hasDuplicates(int nums[]) {

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;

	}

}
