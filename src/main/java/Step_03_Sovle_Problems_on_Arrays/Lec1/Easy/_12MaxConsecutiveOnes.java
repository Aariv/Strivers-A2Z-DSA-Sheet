package Step_03_Sovle_Problems_on_Arrays.Lec1.Easy;

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
}
