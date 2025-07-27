package Leetcode_Contest;

import java.util.Arrays;

public class LCC {
	
	public static void main(String[] args) {
		LCC lc = new LCC();
		int[] nums = {2,1,3,2,1,3};

		long result = lc.maximumMedianSum(nums);
		System.out.println(result);
	}

	public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int k = n / 3;
        long sum = 0;
        int index = n - 2;

        for (int i = 0; i < k; i++) {
            sum += nums[index];
            index -= 2;
        }

        return sum;
    }
	
	public long maxLCTSubsequences(String s) {
        long countL = 0, countLC = 0, countLCT = 0;

        // Count base LCT subsequences
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                countL++;
            } else if (ch == 'C') {
                countLC += countL;
            } else if (ch == 'T') {
                countLCT += countLC;
            }
        }

        long max = countLCT;

        // Simulate insert 'L' at beginning
        // Adds to future 'C's and 'T's
        long extraLC = 0, extraLCT = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'C') extraLC += 1;         // +1 new L (inserted) makes this C part of new LC
            else if (ch == 'T') extraLCT += extraLC;
        }
        max = Math.max(max, countLCT + extraLCT);

        // Simulate insert 'C' at each position
        long lSoFar = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                lSoFar++;
            } else if (ch == 'T') {
                // inserting 'C' before this T
                long gain = lSoFar; // new LC = lSoFar, leads to 1 more LCT for this T
                max = Math.max(max, countLCT + gain);
            }
        }

        // Simulate insert 'T' at end
        // adds all current LC as new LCTs
        max = Math.max(max, countLCT + countLC);

        return max;
    }
}
