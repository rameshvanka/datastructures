package dynamicprogramming.coins;

import java.util.Arrays;


/***
 * Here Problem Statement not minimum, its asking num of solution - empty set also.
 */
public class CoinRecursiveMemoization {
	// Recursive function to count the numeber of distinct
	// ways to make the sum by using n coins
	static int countNumOfSolution(int[] coins, int sum, int n, int[][] dp) {
		// Base Case
		if (sum == 0)
			return dp[n][sum] = 1;

		// If number of coins is 0 or sum is less than 0 then
		// there is no way to make the sum.
		if (n == 0 || sum < 0)
			return 0;

		// If the subproblem is previously calculated then
		// simply return the result
		if (dp[n][sum] != -1)
			return dp[n][sum];

		// Two options for the current coin
		return dp[n][sum] = countNumOfSolution(coins, sum - coins[n - 1], n, dp)
				+ countNumOfSolution(coins, sum, n - 1, dp);
	}

	// Driver code
	public static void main(String[] args) {

		int n, sum;
		n = 3;
		sum = 4;
		int[] coins = { 2, 4, 6 };
		int[][] dp = new int[n + 1][sum + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		int res = countNumOfSolution(coins, sum, n, dp);
		System.out.println(res);

	}

}

