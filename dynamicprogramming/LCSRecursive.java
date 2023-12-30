package dynamicprogramming;

public class LCSRecursive {
	
	static String text1, text2;
	static int[][] dp;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		System.out.println("Ramesh is King");
		String str1 = "arunachalashiva";
		String str2 = "shiva";
		LCSRecursive lcsRecursive = new LCSRecursive();
		
		int result = lcsRecursive.longestCommonSubsequence(str1, str2);
		System.out.println("Result : "+result);
		

		
		System.out.println("Common Sequence : "+sb.toString());
		
		//Finding the diagonal relation to find the common sequence - one more technique to find the diagnoal important - (i,j) -> diagnoal - (i+1,j), (i,j+1)
		System.out.println("Common Sequence Alternate : "+getLCSString());
		
		
		
	}
	
	
	public static String getLCSString() {

		int i = 0, j = 0;
		int l1 = dp.length;
		int l2 = dp[0].length;
		StringBuffer sb = new StringBuffer();
		
		while (i < l1 && j < l2) {
			if (text1.charAt(i) == text2.charAt(j)) {
				sb.append(text1.charAt(i));
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
	
   
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int n = text1.length();
        int m = text2.length();
        
        this.dp = new int[n][m];
        return lcs(n-1, m-1);
    }
    
    int lcs(int i, int j) {
    	
        if (i == -1 || j == -1) {
            return 0;
        } else {
            if (this.dp[i][j] != 0) {
                return this.dp[i][j];
            }
            
            if (text1.charAt(i) == text2.charAt(j)) {
                this.dp[i][j] = lcs(i-1, j-1) + 1;
                //System.out.print(text1.charAt(i) + " ");
                sb.append(text1.charAt(i));
            }
            else {
                this.dp[i][j] = Math.max(lcs(i-1, j), lcs(i, j-1));
            }
            return this.dp[i][j];
        }
        
    }

}
