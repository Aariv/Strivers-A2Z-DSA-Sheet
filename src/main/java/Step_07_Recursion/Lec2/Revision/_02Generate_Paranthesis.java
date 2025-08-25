package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n.Generate all possible combinations of well-formed
 * parentheses of length 2 x N.
 * 
 * Examples: Input : n = 3
 * 
 * Output : [ "((()))" , "(()())" , "(())()" , "()(())" , "()()()" ]
 * 
 * Input : 2
 * 
 * Output : [ "(())" , "()()" ]
 * 
 */
public class _02Generate_Paranthesis {

	public static void main(String[] args) {
		System.out.println(generateParanthesis(3));
	}

	public static List<String> generateParanthesis(int n) {
		List<String> result = new ArrayList<String>();
		generate(n, "", 0, 0, result);
		return result;
	}

	private static void generate(int n, String str, int open, int close, List<String> result) {
		if(str.length() == n * 2) {
			result.add(str);
			return;
		}
		
		if(open < n) {
			generate(n, str + "(", open + 1, close, result);
		}
		
		if(close < open) {
			generate(n, str + ")", open, close + 1, result);
		}
	}
}
