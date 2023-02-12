public class Day_4_Secure_Container {
	static String numList = new String();
	static int count = 0;
	static boolean allIncreasing = true;
	static boolean hasDup = false;
	static int result = 0;

	public static void main(String args[]) {
		for (int i = 197487; i < 673251; i++) {
			String number = Integer.toString(i);
			allIncreasing = true;
			hasDup = false;
			for (int j = 0; j < 6 -1 ; j++) {
				int n1 = Integer.parseInt(number.substring(j, j + 1));
				int n2 = Integer.parseInt(number.substring(j + 1, j + 2));
				if (n1 > n2) 
					allIncreasing = false;
							
				if(n1==n2) 
					hasDup = true;
						
				}
				if(hasDup == true && allIncreasing == true)
					count++;
														   
		}
		System.out.println(count);

			}
				

				//System.out.println(count);	
		}


		
	

