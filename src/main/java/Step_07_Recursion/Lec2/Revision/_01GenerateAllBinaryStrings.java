package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all binary strings of length n that do not contain
 * consecutive 1s. Return the result in lexicographically increasing order.
 * 
 * A binary string is a string consisting only of characters '0' and '1'. 
 * 
 * Input: n = 3
 * 
 * Output: ["000", "001", "010", "100", "101"]
 * 
 * Explanation: All strings are of length 3 and do not contain consecutive 1s.
 * 
 * Input: n = 2
 * 
 * Output: ["00", "01", "10"]
 */
public class _01GenerateAllBinaryStrings {

	public static void main(String[] args) {
		System.out.println(generateBinaryStrings(3));
	}

	/*
	 * Input: n = 3
	 * 
	 * Output: ["000", "001", "010", "100", "101"]
	 * 
	 * Explanation: All strings are of length 3 and do not contain consecutive 1s.
	 */
	public static List<String> generateBinaryStrings(int n) {
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<String>();
		// n, result, sb (for better performance)
		generate(n, result, sb);
		return result;
	}

	private static void generate(int n, List<String> result, StringBuilder sb) {
		// stop as long as the length is equal to n
		if(sb.toString().length() == n) {
			result.add(sb.toString());
			return;
		}
		// add zero till it reaches n
		sb.append("0"); 
		generate(n, result, sb);
		// remove for not pick scenario
		sb.deleteCharAt(sb.length()-1);
		// add one
		sb.append("1");
		generate(n, result, sb);
		sb.deleteCharAt(sb.length()-1);
	}
	
	private static void generateLoop(int n, List<String> result, StringBuilder sb) {
		if(sb.toString().length() == n) {
			result.add(sb.toString());
			return;
		}
		sb.append("0"); 
		generate(n, result, sb);
		sb.deleteCharAt(sb.length()-1);
		sb.append("1");
		generate(n, result, sb);
		sb.deleteCharAt(sb.length()-1);
	}
	
	/**
	 * N = 3
	 * 
	 * n    sb     result
	 * 3    0      
	 * 3    00     
	 * 3    000    000     - Add to the result
	 * 3    00             - Delete the last char
	 * 3    001    001     - Add 1 to the list
	 * 3    00             - Delete the last char
	 * 
	 */
}
