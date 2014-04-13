package codejam2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MagicTrick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2014/A.in";
		int cases = 0;
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			int[] answers = new int[cases];
			for (int i = 0; i < cases; i++) {
				//
				s = br.readLine();
				int answerA = Integer.valueOf(s);
				//
				s = br.readLine();
				int[][] gridA = new int[4][4];
				String[] strings = s.split(" ");
				gridA[0][0] = Integer.valueOf(strings[0]);
				gridA[0][1] = Integer.valueOf(strings[1]);
				gridA[0][2] = Integer.valueOf(strings[2]);
				gridA[0][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridA[1][0] = Integer.valueOf(strings[0]);
				gridA[1][1] = Integer.valueOf(strings[1]);
				gridA[1][2] = Integer.valueOf(strings[2]);
				gridA[1][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridA[2][0] = Integer.valueOf(strings[0]);
				gridA[2][1] = Integer.valueOf(strings[1]);
				gridA[2][2] = Integer.valueOf(strings[2]);
				gridA[2][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridA[3][0] = Integer.valueOf(strings[0]);
				gridA[3][1] = Integer.valueOf(strings[1]);
				gridA[3][2] = Integer.valueOf(strings[2]);
				gridA[3][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				int answerB = Integer.valueOf(s);
				//
				s = br.readLine();
				int[][] gridB = new int[4][4];
				strings = s.split(" ");
				gridB[0][0] = Integer.valueOf(strings[0]);
				gridB[0][1] = Integer.valueOf(strings[1]);
				gridB[0][2] = Integer.valueOf(strings[2]);
				gridB[0][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridB[1][0] = Integer.valueOf(strings[0]);
				gridB[1][1] = Integer.valueOf(strings[1]);
				gridB[1][2] = Integer.valueOf(strings[2]);
				gridB[1][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridB[2][0] = Integer.valueOf(strings[0]);
				gridB[2][1] = Integer.valueOf(strings[1]);
				gridB[2][2] = Integer.valueOf(strings[2]);
				gridB[2][3] = Integer.valueOf(strings[3]);
				//
				s = br.readLine();
				strings = s.split(" ");
				gridB[3][0] = Integer.valueOf(strings[0]);
				gridB[3][1] = Integer.valueOf(strings[1]);
				gridB[3][2] = Integer.valueOf(strings[2]);
				gridB[3][3] = Integer.valueOf(strings[3]);
				//
				Game game = new Game(gridA, gridB, answerA, answerB);
				answers[i] = game.sovler();
			}
			for (int i = 0; i < cases; i++) {
				String output = "";
				output = "Case #" + (i + 1) + ": " + answers[i];
				if (answers[i] == -1)
					output = "Case #" + (i + 1) + ": Bad magician!";
				if (answers[i] == -2)
					output = "Case #" + (i + 1) + ": Volunteer cheated!";
				System.out.println(output);
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

class Game {
	private int[][] gridA = new int[4][4];
	private int[][] gridB = new int[4][4];
	private int answerA;
	private int answerB;

	public Game(int[][] gridA, int[][] gridB, int answerA, int answerB) {
		this.gridA = gridA;
		this.gridB = gridB;
		this.answerA = answerA - 1;
		this.answerB = answerB - 1;
	}

	// -1 means Bad magician!
	// -2 means Volunteer cheated!
	public int sovler() {
		int[] tmpA = new int[4];
		tmpA[0] = gridA[answerA][0];
		tmpA[1] = gridA[answerA][1];
		tmpA[2] = gridA[answerA][2];
		tmpA[3] = gridA[answerA][3];
		int[] tmpB = new int[4];
		tmpB[0] = gridB[answerB][0];
		tmpB[1] = gridB[answerB][1];
		tmpB[2] = gridB[answerB][2];
		tmpB[3] = gridB[answerB][3];
		int count = 0;
		int correct = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tmpA[i] == tmpB[j]) {
					count++;
					correct = tmpA[i];
				}
			}
		}
		if (count == 0)
			return -2;
		if (count == 1)
			return correct;
		if (count > 1)
			return -1;
		return -3;
	}
}