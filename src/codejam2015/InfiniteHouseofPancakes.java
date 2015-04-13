package codejam2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InfiniteHouseofPancakes {

	int cases = 0;

	public static void main(String[] args) {
		InfiniteHouseofPancakes problem = new InfiniteHouseofPancakes();
		problem.read();
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2015/InfiniteHouseofPancakesSmall5.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				int[] array;
				// number and length
				s = br.readLine();
				int n = Integer.valueOf(s);
				array = new int[n];
				// in
				s = br.readLine();
				String[] ss = s.split(" ");
				for (int j = 0; j < n; j++) {
					array[j] = Integer.valueOf(ss[j]);
				}
				int result = solve(array);
				System.out.println("Case #" + (i + 1) + ": " + result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private int solve(int[] array) {
		int check = checkDone(array);
		if (check == 1)
			return 1;
		if (check == 0)
			return 2;
		int flat = solve(flat(array)) + 1;
		int eat = solve(eat(array)) + 1;
		return Math.min(flat, eat);
	}

	private int[] eat(int[] array) {
		int[] res = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			res[i] = array[i] - 1;
		}
		return res;
	}

	private int[] flat(int[] array) {
		int[] res = new int[array.length + 1];
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		for (int i = 0; i < res.length - 1; i++) {
			res[i] = array[i];
			if (index == i) {
				res[i] = array[i] / 2;
				res[res.length - 1] = array[i] - array[i] / 2;
			}
		}
		return res;
	}

	// all 1s return 1
	// all smaller than 3 return 0
	// otherwise return -1
	private int checkDone(int[] array) {
		boolean allOnes = true;
		boolean done = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 1)
				allOnes = false;
			if (array[i] > 2) {
				done = false;
				allOnes = false;
				break;
			}
		}
		if (allOnes)
			return 1;
		if (done)
			return 0;
		return -1;
	}
}
