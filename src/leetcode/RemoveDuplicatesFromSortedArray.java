package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 2 };
		System.out.println(removeDuplicatesII(A) + " " + Arrays.toString(A));
	}

	// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
	public static int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		int pointer = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				pointer++;
				A[pointer] = A[i];
			}
		}
		return pointer + 1;
	}

	// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	// Duplicates allow at most twice
	public static int removeDuplicatesII(int[] A) {
		if (A.length == 0)
			return 0;
		int pointer = 0;
		boolean twice = false;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				pointer++;
				A[pointer] = A[i];
				twice = false;
			} else if (!twice) {
				pointer++;
				A[pointer] = A[i];
				twice = true;
			}
		}
		return pointer + 1;
	}
}
