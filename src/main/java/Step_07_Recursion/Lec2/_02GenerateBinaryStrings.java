package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _02GenerateBinaryStrings {

	public static void generate(int n, String current) {
        if (current.length() == n) {
            System.out.println(current);
            return;
        }
        generate(n, current + "0");
        generate(n, current + "1");
    }
	
	public static void generateOptimized(int n, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }
        current.append("0");
        generateOptimized(n, current, result);
        current.deleteCharAt(current.length()-1);
        current.append("1");
        generateOptimized(n, current, result);
        current.deleteCharAt(current.length()-1);
    }

    public static void main(String[] args) {
//        generate(3, "");
        StringBuilder str = new StringBuilder();
        List<String> result = new ArrayList<String>();
        generateOptimized(3, str, result);
        System.out.println(result);
    }
}
