package Step_03_Sovle_Problems_on_Arrays.Lec1.Easy;

public class _13NumberAppearOnce {

	public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR
        }
        return result;
    }
}
