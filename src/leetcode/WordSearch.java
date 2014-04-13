package leetcode;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		System.out.println(exist(board, "ABCESEEEFS"));
	}

	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] searched = new boolean[board.length][board[0].length];
					if (existHelper(board, word.substring(1), searched.clone(),
							i, j))
						return true;
				}
			}
		}
		return false;
	}

	private static boolean existHelper(char[][] board, String word,
			boolean[][] searched, int x, int y) {
		if (word.equals(""))
			return true;
		char c = word.charAt(0);
		searched[x][y] = true;
		// go left
		if (y - 1 >= 0 && !searched[x][y - 1] && board[x][y - 1] == c) {
			boolean[][] copyS = arrayCopy(searched);
			if (existHelper(board, word.substring(1), copyS, x, y - 1))
				return true;
		}
		// go right
		if (y + 1 < board[0].length && !searched[x][y + 1]
				&& board[x][y + 1] == c) {
			boolean[][] copyS = arrayCopy(searched);
			if (existHelper(board, word.substring(1), copyS, x, y + 1))
				return true;
		}
		// go up
		if (x - 1 >= 0 && !searched[x - 1][y] && board[x - 1][y] == c) {
			boolean[][] copyS = arrayCopy(searched);
			if (existHelper(board, word.substring(1), copyS, x - 1, y))
				return true;
		}
		// go down
		if (x + 1 < board.length && !searched[x + 1][y] && board[x + 1][y] == c) {
			boolean[][] copyS = arrayCopy(searched);
			if (existHelper(board, word.substring(1), copyS, x + 1, y))
				return true;
		}
		return false;
	}

	private static boolean[][] arrayCopy(boolean[][] searched) {
		// TODO Auto-generated method stub
		boolean[][] copyS = new boolean[searched.length][searched[0].length];
		for (int i = 0; i < copyS.length; i++) {
			for (int j = 0; j < copyS[0].length; j++) {
				copyS[i][j] = searched[i][j];
			}
		}
		return copyS;
	}
}
