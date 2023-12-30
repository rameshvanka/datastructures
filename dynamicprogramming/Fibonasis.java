package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

//In a Fibonacci Series, every number (except the first two numbers) is the sum of the previous two numbers
public class Fibonasis {
	
	//Cache 
	static private Map <Integer,Long > cacheMap = new HashMap<>();
	
	public static void main(String[] args) {
		int fib_len = 9;

		System.out.println("Ramesh is King " + fib1(4));
		
		//Without Cache
		 for (int i = 0; i < fib_len; i++) {
		      System.out.print(fib1(i) + " ");
		 }
		 
		 System.out.println(" ");
		 
		 //With Cache
		 for (int i = 0; i < fib_len; i++) {
		      System.out.print(fib1(i) + " ");
		 }
	}
	
	
	/** Without Cache **/
	public static long fib1(int num) {
		
		if(num == 0) {
			return 0;
		}
		if(num == 1 || num == 2) {
			return 1;
		} 
		
		return fib1(num-1) + fib1(num-2);
	}
	
	/** Without Cache **/
	public static long fib2(int num) {
		
		if(num == 0) {
			return 0;
		}
		if(num == 1 || num == 2) {
			return 1;
		} 
		
		if (cacheMap.containsKey(num)) {
		    // getting value from the stored result(s)
		    return cacheMap.get(num);
		}
		
		Long result = fib1(num-1) + fib1(num-2);
		
		//Store the result in cache
		cacheMap.put(num, result);
		
		return result;
	}
	
	

}
