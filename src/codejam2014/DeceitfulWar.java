package codejam2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DeceitfulWar {

	int cases = 0;
	ArrayList<GameD> list = new ArrayList<GameD>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeceitfulWar deceitfulWar = new DeceitfulWar();
		deceitfulWar.read();
		for (int i = 0; i < deceitfulWar.cases; i++) {
			String out = "Case #" + (i + 1) + ": ";
			GameD gameD = deceitfulWar.list.get(i);
			out += gameD.deceitfulWar(gameD.A, gameD.B);
			out += " ";
			out += deceitfulWar.list.get(i).war();
			System.out.println(out);
		}
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2014/D-large.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				s = br.readLine();
				int n = Integer.valueOf(s);
				double[] A = new double[n];
				double[] B = new double[n];
				s = br.readLine();
				String[] strings = s.split(" ");
				for (int j = 0; j < n; j++) {
					A[j] = Double.valueOf(strings[j]);
				}
				s = br.readLine();
				strings = s.split(" ");
				for (int j = 0; j < n; j++) {
					B[j] = Double.valueOf(strings[j]);
				}
				GameD gameD = new GameD(n, A, B);
				list.add(gameD);
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

class GameD {
	private int n;
	double[] A;
	double[] B;

	public GameD(int n, double[] A, double[] B) {
		this.n = n;
		this.A = A;
		this.B = B;
		Arrays.sort(A);
		Arrays.sort(B);
		// for (int i = 0; i < B.length; i++) {
		// System.out.print(A[i]+" ");
		// }
		// System.out.print("\n");
		// for (int i = 0; i < B.length; i++) {
		// System.out.print(B[i]+" ");
		// }
		// System.out.print("\n");
	}

	public int deceitfulWar(double[] A, double[] B) {
		int score = 0;
		int length = A.length;
		int tail = length - 1;
		int head = 0;
		for (int i = length - 1; i >= 0; i--) {
			double massA = A[tail];
			double massB = B[i];
			if (massA > massB) {
				score++;
				tail--;
				continue;
			}
			if (massA < massB && score > 0) {
				return score += deceitfulWar(
						Arrays.copyOfRange(A, head, tail + 1),
						Arrays.copyOfRange(B, 0, i + 1));
			}
			head++;
		}
		return score;
	}

	public int war() {
		int score = 0;
		boolean[] firedA = new boolean[n];
		boolean[] firedB = new boolean[n];
		for (int i = 0; i < n; i++) {
			double mass = A[i];
			int choose = -1;
			for (int j = 0; j < n; j++) {
				if (!firedB[j] && B[j] > mass) {
					choose = j;
					firedA[i] = true;
					firedB[j] = true;
					break;
				}
			}
			if (choose == -1) {
				for (int j = 0; j < n; j++) {
					if (!firedB[j]) {
						firedA[i] = true;
						firedB[j] = true;
						score++;
						break;
					}
				}
			}
		}
		return score;
	}
}