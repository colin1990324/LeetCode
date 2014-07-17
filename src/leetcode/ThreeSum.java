package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	// https://oj.leetcode.com/problems/3sum/
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) {
						left++;
					}
					while (left < right && num[right] == num[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
	}

	// https://oj.leetcode.com/problems/3sum-closest/
	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		int closet = Integer.MAX_VALUE / 2;
		for (int i = 0; i < num.length - 2; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum
						: closet;
			}
		}
		return closet;
	}
}
