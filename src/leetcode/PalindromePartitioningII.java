package leetcode;
import java.util.HashMap;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		System.out
				.println(minCutII("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(minCut("ADaDA"));
		System.out.println(minCut("AAaD"));
	}

	//The HashMap cost more time that expected, need more explanation
	public static int minCut(String s) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		int[] list = new int[s.length() + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.MAX_VALUE;
		}
		list[0] = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (list[j] != 2147483647
						&& isPalidrome(s.substring(j, i + 1), map)) {
					if (list[j] + 1 < list[i + 1])
						list[i + 1] = list[j] + 1;
				}
				System.out.println(i + " " + j + " " + map.size());
			}
		}
		return list[s.length()] - 1;
	}

	public static boolean isPalidrome(String s, HashMap<String, Boolean> map) {
		if (map.containsKey(s))
			return true;
		int length = s.length();
		if (length == 1) {
			map.put(s, true);
			return true;
		} else if (length == 2) {
			if (s.charAt(0) == s.charAt(1))
				map.put(s, true);
			return true;
		} else {
			if (s.charAt(0) == s.charAt(length - 1)) {
				if (isPalidrome(s.substring(1, length - 1), map)) {
					map.put(s, true);
					return true;
				}
			}
		}
		return false;
	}

	//this is a 2 dimension DP 
	public static int minCutII(String s) {
		if (s.length() == 0)
			return 0;
		int length = s.length();
		boolean[][] pal = new boolean[length][length];
		int[] d = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			d[i] = length - i - 1;
			for (int j = i; j < length; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || pal[i + 1][j - 1])) {
					pal[i][j] = true;
					if (j == length - 1)
						d[i] = 0;
					else if (d[j + 1] + 1 < d[i])
						d[i] = d[j + 1] + 1;
				}
			}
		}
		return d[0];
	}
}
