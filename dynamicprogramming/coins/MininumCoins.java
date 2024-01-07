package dynamicprogramming.coins;

import java.util.Arrays;

/**
 * This problem statement is different, previous one, here we are asked minimum num of coins to achieve wait
 * Here it will not come empty set concept, don't confuse.
 * 
 * Using Recursive it wil 2 power n, for the best solution we are choosing dynamic programming approach.
 */
public class MininumCoins {
	
	public static void main(String[] args) {
		System.out.println("Jai Sriram");
		int coins[] = { 2, 4 };
		int n = coins.length;

		int result = minimumCoins(coins, 4);
		System.out.println();
		System.out.println("Results are -> " + result);
	}
	
    public static int minimumCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        //display2D(dp);
        return dp[coins.length][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
    }
    
    
    public static void display2D(int[][] dp) {
    	System.out.println(Integer.MAX_VALUE);
    	for(int i=0; i < dp.length; i++) {
    		System.out.println();
    		
    		for(int j=0; j < dp[0].length; j++) {
    			System.out.print(dp[i][j] + "  ");
    		}
    	}
    }

}
