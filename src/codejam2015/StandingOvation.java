package codejam2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StandingOvation {

	int cases = 0;

	public static void main(String[] args) {
		StandingOvation problem = new StandingOvation();
		problem.read();
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2015/StandingOvationLarge.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				// in
				s = br.readLine();
				String[] ss = s.split(" ");
				int maxL = Integer.valueOf(ss[0]);
				int[] array = new int[maxL + 1];
				char[] cs = ss[1].toCharArray();
				for (int j = 0; j < cs.length; j++) {
					array[j] = cs[j] - 48;
				}
				int result = solve(maxL, array);
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

	private int solve(int n, int[] array) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				continue;
			if (count < i) {
				result += i - count;
				count = i + array[i];
			} else {
				count += array[i];
			}
		}
		return result;
	}
}
