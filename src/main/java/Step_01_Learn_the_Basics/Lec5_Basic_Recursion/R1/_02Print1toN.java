package Step_01_Learn_the_Basics.Lec5_Basic_Recursion.R1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, write a function to print all numbers from n to 1
 * (inclusive) using recursion.
 * 
 * You must not use any loops such as for, while, or do-while. The function
 * should print each number on a separate line, in decreasing order from n to 1
 * 
 * Input: 5
 * 
 * Output:
 * 
 * 5, 4, 3, 2, 1
 * 
 */
public class _02Print1toN {

	public static void main(String[] args) {
		print1toN(3);
	}

	private static void print1toN(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		print1toN(n-1);
	}
	
	public static List<Integer> print1toNR(int n) {
		List<Integer> result = new ArrayList<Integer>();
		print1toN(n, result);
		return result;
	}
	
	private static void print1toN(int n, List<Integer> result) {
		if(n == 0) {
			return;
		}
		result.add(n);
		print1toN(n-1);
	}
}
