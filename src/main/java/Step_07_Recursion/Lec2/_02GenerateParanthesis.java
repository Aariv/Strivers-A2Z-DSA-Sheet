package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _02GenerateParanthesis {

	public static void main(String[] args) {
		int n = 3;
		
		generateParanthesis(n);
	}

	private static void generateParanthesis(int n) {
		List<String> res = new ArrayList<String>();
		generate(n, "", 0, 0, res);
		System.out.println(res);
	}

	private static void generate(int n, String str, int open, int close, List<String> res) {
		if(str.length() == n * 2)
		{
			res.add(str);
			return;
		}
		
		if(open < n) {
			generate(n, str + "(", open + 1, close, res);
		}
		
		if(close < open) {
			generate(n, str + ")", open, close + 1, res);
		}
	}
}
