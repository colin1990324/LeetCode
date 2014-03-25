import java.util.ArrayList;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String t = "bddabdcae";
		System.out.println(numDistinct(s, t));
	}

	public static int numDistinct(String S, String T) {
		char[] sArray = S.toCharArray();
		char[] tArray = T.toCharArray();
		// Trace 0: not match, 1 do action
		int[][] matrixR = new int[T.length() + 1][S.length() + 1];
		int[][] matrixD = new int[T.length() + 1][S.length() + 1];
		// initialize
		for (int i = 0; i < S.length() - T.length() + 1; i++) {
			matrixR[0][i] = 1;
		}
		matrixD[0][0] = 1;
		for (int i = 1; i < T.length() + 1; i++) {
			for (int j = 1; j < S.length() + 1; j++) {
				if (reachable(matrixR, matrixD, i, j - 1)) {
					matrixR[i][j] = 1;
				}
				if (reachable(matrixR, matrixD, i - 1, j - 1)
						&& sArray[j - 1] == tArray[i - 1]) {
					matrixD[i][j] = 1;
				}
			}
		}
		return countAll(matrixR, matrixD, S, T);
	}

	private static boolean reachable(int[][] matrixR, int[][] matrixD, int i,
			int j) {
		if (matrixR[i][j] == 1 || matrixD[i][j] == 1) {
			return true;
		} else {
			return false;
		}
	}

	//recursive traceBack
	private static void traceBack(int[][] matrixR, int[][] matrixD, int i,
			int j, int[] counter) {
		if (i == 0 && j == 0) {
			counter[0]++;
			return;
		}
		if (matrixD[i][j] == 1)
			traceBack(matrixR, matrixD, i - 1, j - 1, counter);
		if (matrixR[i][j] == 1)
			traceBack(matrixR, matrixD, i, j - 1, counter);
	}
	
	//better counting, do not trace back, just counting
	private static int countAll(int[][] matrixR, int[][] matrixD, String S, String T) {
		int[][] counter=new int[T.length() + 1][S.length() + 1];
		for (int i = 0; i < S.length() + 1; i++) {
			counter[0][i]=1;
		}
		for (int i = 1; i < T.length() + 1; i++) {
			for (int j = 1; j < S.length() + 1; j++) {
				if(matrixR[i][j]==1)
					counter[i][j]+=counter[i][j-1];
				if(matrixD[i][j]==1)
					counter[i][j]+=counter[i-1][j-1];
			}
		}
		return counter[T.length()][S.length()];
	}
}
