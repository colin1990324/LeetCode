package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		row1.add(2);
		row2.add(3);
		row2.add(4);
		row3.add(6);
		row3.add(5);
		row3.add(7);
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		System.out.println(minimumTotal(triangle));
	}

	// https://oj.leetcode.com/problems/triangle/
	// Given a triangle, find the minimum path sum from top to bottom. Each
	// step you may move to adjacent numbers on the row below.
	//This recursive version got "Time Exceed"
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return -1;
		int value = triangle.get(0).get(0);
		return Math.min(minimumTotalHelper(triangle, 1, 0, value),
				minimumTotalHelper(triangle, 1, 1, value));
	}

	private static int minimumTotalHelper(List<List<Integer>> triangle,
			int row, int index, int value) {
		if (triangle.size() <= row)
			return value;
		else {
			return Math.min(
					minimumTotalHelper(triangle, row + 1, index, value
							+ triangle.get(row).get(index)),
					minimumTotalHelper(triangle, row + 1, index + 1, value
							+ triangle.get(row).get(index)));
		}
	}

	// Botton Up Dynamic Programming
	public static int minimumTotalII(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			sum[n - 1][i] = triangle.get(n - 1).get(i);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}
		return sum[0][0];
	}
}
