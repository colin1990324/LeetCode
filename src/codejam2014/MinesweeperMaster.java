package codejam2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MinesweeperMaster {

	int cases = 0;
	ArrayList<GameC> list = new ArrayList<GameC>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinesweeperMaster minesweeperMaster = new MinesweeperMaster();
		minesweeperMaster.read();
		for (int i = 0; i < minesweeperMaster.cases; i++) {
			System.out.println("Case #" + (i + 1) + ":");
			if (!minesweeperMaster.list.get(i).solver())
				System.out.println("Impossible");
		}
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2014/C.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				int R, C, M;
				s = br.readLine();
				String[] strings = s.split(" ");
				R = Integer.valueOf(strings[0]);
				C = Integer.valueOf(strings[1]);
				M = Integer.valueOf(strings[2]);
				GameC gameC = new GameC(R, C, M);
				list.add(gameC);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class GameC {
	private int R;
	private int C;
	private int M;
	private boolean fliped = false;
	private int noMine;

	public GameC(int R, int C, int M) {
		if (R > C) {
			this.R = R;
			this.C = C;
		} else {
			this.R = C;
			this.C = R;
			fliped = true;
		}
		this.M = M;
		noMine = R * C - M;
	}

	public boolean solver() {
		int[][] matrix = new int[R][C];
		//
		if (noMine == 1) {
			matrix[0][0] = 2;
			print(matrix);
			return true;
		}
		if (C == 1) {
			matrix[0][0] = 2;
			for (int i = 1; i < noMine; i++) {
				matrix[i][0] = 1;
			}
			print(matrix);
			return true;
		}
		if (C == 2) {
			if (noMine < 4 || noMine % 2 == 1)
				return false;
			matrix[0][0] = 2;
			matrix[0][1] = 1;
			for (int i = 1; i < noMine; i++) {
				matrix[i][0] = 1;
				matrix[i][1] = 1;
			}
			print(matrix);
			return true;
		}
		// more

		//
		return false;
	}

	// . = 1
	// c = 2
	private void print(int[][] matrix) {
		if (fliped) {
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					System.out.print(printHelper(matrix[i][j]));
				}
				System.out.print("\n");
			}
		} else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(printHelper(matrix[i][j]));
				}
				System.out.print("\n");
			}
		}
	}

	private char printHelper(int i) {
		switch (i) {
		case 0:
			return '*';
		case 1:
			return '.';
		case 2:
			return 'c';
		}
		return 0;
	}
}