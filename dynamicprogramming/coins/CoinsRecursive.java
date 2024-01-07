package dynamicprogramming.coins;

import java.util.Arrays;

/**
 * 
 * Here Problem Statement not minimum, its asking num of solution - empty set also.
 * Input: sum = 4, coins[] = {1,2,3}, 
Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}. 

Input: sum = 10, coins[] = {2, 5, 3, 6}
Output: 5
Explanation: There are five solutions: 
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
public class CoinsRecursive {
	
	 // Driver code
    public static void main(String args[]) {
        int coins[] = { 2,4};
        int n = coins.length;
 
        //System.out.println(count(coins, n, 4));
        int result = countNumOfSolution(coins, n, 4);
        //int result = coinChange_quadraticSpace(coins,4);
        System.out.println();
        System.out.println("Results are -> "+result);
    }
    

    
    public static void display(int coins[]) {
    	for(int i=0; i < coins.length; i++) {
    		System.out.print(coins[i] + " ");
    	}
    }
    

    
    // Returns the count of ways we can - sum coins[0...n-1] coins to get sum "sum"
 
 	static int countNumOfSolution(int coins[], int n, int sum)
 	{
 		display(coins);
 		System.out.print( " ->  n value : "+n + " sum value : "+sum);
 		System.out.println();
 		// If sum is 0 then there is 1 solution
 		// (do not include any coin)
 		if (sum == 0) {
 			System.out.println("Find the solution");
 			return 1;
 		}

 		// If sum is less than 0 then no
 		// solution exists
 		if (sum < 0) {
 			System.out.println("No Solution"); 			
 			return 0;
 		}
 			

 		// If there are no coins and sum
 		// is greater than 0, then no
 		// solution exist
 		if (n <= 0){
 			System.out.println("No Solution n < 0"); 			
 			return 0;
 		}

 		// count is sum of solutions (i) including coins[n-1] (ii) excluding coins[n-1] 		
 		return countNumOfSolution(coins, n, sum - coins[n - 1]) + countNumOfSolution(coins, n - 1, sum);
 			
 	}

}
