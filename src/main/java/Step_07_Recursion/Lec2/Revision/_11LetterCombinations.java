package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _11LetterCombinations {

	public static void main(String[] args) {
		String digits = "34";
		System.out.println(letterCombinations(digits));
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "");map.put(3, "def");map.put(6, "mno");map.put(9, "wxyz");
		map.put(1, "");map.put(4, "ghi");map.put(7, "pqrs");
		map.put(2, "abc");map.put(5, "jkl");map.put(8, "tuv");
		
		StringBuilder sb = new StringBuilder();
		
//		letterCombinations(digits, 0, result, map, sb);
		letterCombinations(digits, 0, result, map, "");
		return result;
    }

	private static void letterCombinations(String digits, int idx, List<String> result, Map<Integer, String> map,
			StringBuilder sb) {
		// Processed all?
		if (idx == digits.length()) {
			result.add(sb.toString());
			return;
		}

		int digit = digits.charAt(idx) - '0';
		// Get the letters for the digit
		String letters = map.get(digit);

		// Combinations
		for (int i = 0; i < letters.length(); i++) {
			sb.append(letters.charAt(i)); // Pick
			letterCombinations(digits, idx + 1, result, map, sb); // Recurse
			sb.deleteCharAt(sb.length() - 1); // Backtrack
		}
	}
	

	private static void letterCombinations(String digits, int idx, List<String> result, Map<Integer, String> map,
			String str) {
		// Processed all?
		if (idx == digits.length()) {
			result.add(str);
			return;
		}

		int digit = digits.charAt(idx) - '0';
		// Get the letters for the digit
		String letters = map.get(digit);

		// Combinations
		for (int i = 0; i < letters.length(); i++) {
			letterCombinations(digits, idx + 1, result, map, str + letters.charAt(i)); // Recurse
		}
	}
	
}
