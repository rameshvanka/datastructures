package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubsets {
	
	  //public static boolean include[];
    public static int W = 52;
    public static int w[] = { 2, 10, 13, 17, 22, 42 };
    public static List<List<Integer>> sumOfSubset = new ArrayList<>();
    
    // 2+10+13+17+22+42 = 106
    //static int total = 106;
    
    static int total = getTotalSumOfWeights(w);
    public static boolean include[] = new boolean[50];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("solution: ");
		/*
		 * for(int i=0; i<w.length-1;i++) { sum_of_subsets(i, w[i], W); }
		 */
        
        sum_of_subsets(0, 0, total);
        
        System.out.println("Sum Of Subset ->"+sumOfSubset);

    }
    
  

    public static void sum_of_subsets(int i, int weight, int total) {

        if (promising(i, weight, total)) {
            if (weight == W) {
            	System.out.println("  ");
				/*
				 * for (int j = 0; j < w.length; j++) { if(include[j]) System.out.print(w[j] +
				 * " "); }
				 */
            	sumOfSubset.add(getSumSubset(i));
            	
            } else {
                include[i + 1] = true;
                sum_of_subsets(i + 1, weight + w[i + 1], total - w[i + 1]);
                include[i + 1] = false;
                sum_of_subsets(i + 1, weight, total - w[i + 1]);
            }
            

        }
        
    }

    public static boolean promising(int i, int weight, int total) {
        return (weight + total >= W) && (weight == W || weight + w[i+1] <= W);
    }
    
    public static int getTotalSumOfWeights(int w[]) {
    	int total = 0;
    	for(int i=0; i < w.length ; i++) {
    		total = total + w[i];
    	}
    	return total;
    }
    
    public static List<Integer> getSumSubset(int index) {
    	List<Integer> ans = new ArrayList<>();
    	for(int j=0; j <= index; j++) {
    		//System.out.println("index "+i + " value "+ w[i] + " include j "+j + " value "+include[j]);
    		if(include[j]) {
    			ans.add(w[j]);
    		}
    		
    	}
    	return ans;
    }



}
