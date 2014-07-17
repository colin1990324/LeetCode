package leetcode;

//https://oj.leetcode.com/problems/edit-distance/
public class EditDistance {

	public static void main(String[] args) {

	}

	//Typical DP problem
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] cost = new int[n + 1][m + 1];
		for (int i = 0; i < m + 1; i++) {
			cost[0][i] = i;
		}
		for (int i = 0; i < n + 1; i++) {
			cost[i][0] = i;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					cost[i][j] = cost[i - 1][j - 1];
				} else {
					cost[i][j] = 1 + Math.min(cost[i - 1][j - 1],
							Math.min(cost[i - 1][j], cost[i][j - 1]));
				}
			}
		}
		return cost[n][m];
	}
}
