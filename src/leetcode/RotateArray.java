package leetcode;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(a, 3);
	}

	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		int nowIndex = 0;
		int tmp1, tmp2 = nums[0];
		// j here limit time complexity to O(n)
		// i here controls occurrence of loops
		for (int j = 0, i = 0; j < n; j++) {
			tmp1 = tmp2;
			nowIndex = (k + nowIndex) % (n);
			tmp2 = nums[nowIndex];
			nums[nowIndex] = tmp1;
			if (nowIndex == i && i < nums.length - 1) {
				nowIndex = ++i;
				tmp2 = nums[nowIndex];
			}
		}
	}
}
