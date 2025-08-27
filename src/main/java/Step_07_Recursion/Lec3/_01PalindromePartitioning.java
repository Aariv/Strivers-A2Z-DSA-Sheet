package Step_07_Recursion.Lec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s partition string s such that every substring of partition is
 * palindrome. Return all possible palindrome partition of string s.
 * 
 * 
 * Examples: Input : s = "aabaa"
 * 
 * Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a",
 * "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
 * 
 * Explanation : Above all are the possible ways in which the string can be
 * partitioned so that each substring is a palindrome.
 * 
 * Input : s = "baa"
 * 
 * Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
 * 
 * Explanation : Above all are the possible ways in which the string can be
 * partitioned so that each substring is a palindrome.
 * 
 * 
 */
public class _01PalindromePartitioning {
	
	public static void main(String[] args) {
		String s = "aabaa";
        System.out.println(partition(s));

        String s2 = "baa";
        System.out.println(partition(s2));
	}

	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

	private static void backtrack(int start,
								  String s,
								  List<String> path,
								  List<List<String>> result) {
		if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
		// Try every possible substring from start → end
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // ✅ Pick substring
                path.add(s.substring(start, end + 1));

                // Recurse for remaining string
                backtrack(end + 1, s, path, result);

                // 🔄 Backtrack (remove last added substring)
                path.remove(path.size() - 1);
            }
        }
	}
	
	private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
