package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LCSRecursiveInteger {
	
	static int[] text1, text2;
	static int[][] dp;
	static StringBuffer sb = new StringBuffer();
	static List<Integer> listInt = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		System.out.println("Ramesh is King");
		String str1 = "arunachalashiva";
		int[] num1 = {10,9,2,5,3,7,101,18};
		String str2 = "shiva";
		int[] num2 = {2,3,5,7,9,10,18,101};
		LCSRecursiveInteger lcsRecursive = new LCSRecursiveInteger();
		
		int result = lcsRecursive.longestCommonSubsequence(num1, num2);
		System.out.println("Result : "+result);
		

		
		System.out.println("Common Sequence**** : "+listInt);
		
		display();
		System.out.println("");
		
		//Finding the diagonal relation to find the common sequence - one more technique to find the diagnoal important - (i,j) -> diagnoal - (i+1,j), (i,j+1)
		System.out.println("Common Sequence Alternate : "+getLCSString());
		
		
		
	}
	
	public static void display() {
		for(int i=0; i < dp.length; i++) {
			System.out.println("");
			for(int j=0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] +" ");
			}
		}
	}
	
	

	
   
    public int longestCommonSubsequence(int[] text1, int[] text2) {
        this.text1 = text1;
        this.text2 = text2;
        int n = text1.length;
        int m = text2.length;
        
        this.dp = new int[n+1][m+1];
        return lcs(n-1, m-1);
    }
    
    int lcs(int i, int j) {
    	
        if (i == -1 || j == -1) {
            return 0;
        } else {
        	 //System.out.println(text1[i] + " - " + text2[j] + " - " + dp[i][j]);
            if (this.dp[i][j] != 0) {
                return this.dp[i][j];
            }
            
            if (text1[i] == text2[j]) {
            	listInt.add(text2[j]);            	
                this.dp[i][j] = lcs(i-1, j-1) + 1;
            }
            else {
                this.dp[i][j] = Math.max(lcs(i-1, j), lcs(i, j-1));
            }
            return this.dp[i][j];
        }
        
    }
    
	public static String getLCSString() {

		int i = 0, j = 0;
		StringBuffer sb = new StringBuffer();
		
		while (i < text1.length && j < text2.length) {
			if (text1[i] == text2[j]) {
				sb.append(Integer.toString(text1[i])+" ");
				i++;
				j++;
			} else if (dp[i + 1][j] >= dp[i][j + 1]) { //Diagnoal checking				
				i++;
			} else {
			    j++;
			}				
		}
		
		return sb.toString();		 
	}

}
