package microsoftCodingCompetition2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Cure_the_virus {

	public static void main(String[] args) {
		String b = "CTTGGTAGGTGTCACGCTG";
		int n = 50;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Float> map = new ArrayList<Float>();
		float[] r = new float[n];
		for (int i = 0; i < n; i++) {
			try {
				String s = br.readLine();
				float rst = get(s, b);
				r[i] = rst;
				map.add(rst);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Arrays.sort(r);
		int p = 0;
		for (int i = 1; i < n; i++) {
			if (r[i] != r[p]) {
				r[p + 1] = r[i];
				p++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (r[j] == map.get(i)) {
					System.out.println("Person #" + i + ": " + (p - j + 1)
							+ ".");
					break;
				}
			}
		}
	}

	public static float get(String a, String b) {
		return (float) search(a, b) / (float) b.length();
	}

	public static int search(String s2, String s1) {
		if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
			return 0;
		}

		int len1 = s1.length() + 1;
		int len2 = s2.length() + 1;

		int[][] match = new int[len1][len2];
		int maxLength = 0; 

		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {

				if (s2.charAt(j - 1) == s1.charAt(i - 1)) {
					if (match[i - 1][j - 1] != 0) {
						match[i][j] = match[i - 1][j - 1] + 1;
					} else {
						match[i][j] = 1;
					}
				} else {
					match[i][j] = match[i - 1][j];
				}
				maxLength = Math.max(maxLength, match[i][j]);

			}
		}
		return maxLength;
	}
}
