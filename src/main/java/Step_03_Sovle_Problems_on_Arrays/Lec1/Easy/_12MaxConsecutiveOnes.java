package Step_03_Sovle_Problems_on_Arrays.Lec1.Easy;

// Max CX
public class _12MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : arr) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // reset if zero
            }
        }

        return maxCount;
    }
	
	public static int longestOnes(int[] arr, int k) {
        int left = 0, right = 0;
        int zeroCount = 0, maxLen = 0;

        while (right < arr.length) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
