package leetcode;

import java.util.Arrays;

//https://oj.leetcode.com/problems/sort-colors/
public class SortColors {

	public static void main(String[] args) {
		int[] A = { 0,1 };
		sortColors(A);
		System.out.println(Arrays.toString(A));
	}

	public static void sortColors(int[] A) {
		int length = A.length;
		if (length == 1)
			return;
		int redHead = 0;
		int blueHead = length-1;
		for (int i = 0; i < length; i++) {
			if (A[i] == 0) {
				A[i] = A[redHead];
				A[redHead] = 0;
				redHead++;
				continue;
			} else if (A[i] == 1) {
				continue;
			} else if (A[i] == 2) {
				if(i>=blueHead){
					return;
				}
				A[i] = A[blueHead];
				A[blueHead] = 2;
				blueHead--;
				i--;
			}
		}
	}
}
