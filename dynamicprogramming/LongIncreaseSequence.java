package dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Here Concept Already Set is there -> {1} as 1, if you add new element in the set then it will become {1,2} - 2

This concept will go like this.
 * 
 */

public class LongIncreaseSequence {
	
	public static void main(String[] args) {
		System.out.println("Ramesh is King");
		int[] nums = {10,9,2,5,3,7,101,18};
		int answer = lengthOfLIS(nums);
		System.out.println("Answer is "+answer);
		
		
	}
	
	public static void display(int[] dp) {
		for(int i=0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
	}
	
	 public static int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        dp[0] = 1;
	        int ans = 1;
	       
	        
	        for(int i = 1; i < nums.length; i++) {
	            dp[i] = 1;
	            for(int j = 0; j < i; j++) {
	            	//System.out.println(j + " " + i);
	               if (nums[j] < nums[i]) {
	            	   //System.out.println(i + " " + dp[i] + " " + nums[i]);	            	   
	                   dp[i] = Math.max(dp[i], dp[j] + 1);
	               } 
	            }
	            ans = Math.max(ans, dp[i]);	           
	        }
	        
	        return ans;
	    }

}
