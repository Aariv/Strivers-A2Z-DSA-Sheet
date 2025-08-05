package Step_03_Sovle_Problems_on_Arrays.Lec1.Easy;

import java.util.ArrayList;
import java.util.List;

public class _10UnionTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {2, 3, 5, 6, 7};
		int[] arr2 = {3, 6, 7, 8, 20};
		
		List<Integer> result = unionSorted(arr1, arr2);
		System.out.println(result);
	}
	
	public static List<Integer> unionSorted(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            // Skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            if (arr1[i] < arr2[j]) {
                result.add(arr1[i++]);
            } else if (arr2[j] < arr1[i]) {
                result.add(arr2[j++]);
            } else { // Equal
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Remaining elements in arr1
        while (i < arr1.length) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                result.add(arr1[i]);
            }
            i++;
        }

        // Remaining elements in arr2
        while (j < arr2.length) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                result.add(arr2[j]);
            }
            j++;
        }

        return result;
    }
	
}
