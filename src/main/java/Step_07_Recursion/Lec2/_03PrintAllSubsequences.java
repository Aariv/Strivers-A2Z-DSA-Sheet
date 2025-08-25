package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _03PrintAllSubsequences {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3};
		int[] arr = {5, 2, 1};
		System.out.println(powerSetSum(arr));
	}

	private static List<List<Integer>> printSubSequence(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		printSubSequence(arr.length, 0, inner, result, arr);
		return result;
	}

	private static void printSubSequence(int n, int idx, List<Integer> inner, List<List<Integer>> result, int[] arr) {
		if(idx == n) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		
		// Pick
		inner.add(arr[idx]);
		printSubSequence(n, idx + 1, inner, result, arr);
		// Not Pick
		inner.remove(inner.size()-1);
		printSubSequence(n, idx + 1, inner, result, arr);
	}
	
	private static List<Integer> powerSetSum(int[] arr) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> inner = new ArrayList<Integer>();
		int sum = 0;
		powerSetSum(arr.length, 0, inner, result, arr, sum);
		return result;
	}

	private static void powerSetSum(int n, int idx, List<Integer> inner, List<Integer> result, int[] arr, int sum) {
		if(idx == n) {
			result.add(sum);
//			sum = 0;
			return;
		}
		
		// Pick
//		sum += arr[idx];
//		inner.add(arr[idx]);
		powerSetSum(n, idx + 1, inner, result, arr, sum + arr[idx]);
		// Not Pick
//		inner.remove(inner.size()-1);
//		sum -= arr[idx];
		powerSetSum(n, idx + 1, inner, result, arr, sum);
	}
}
