package codejam2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CookieClickerAlpha {
	int cases = 0;
	ArrayList<GameB> list = new ArrayList<GameB>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CookieClickerAlpha clickerAlpha = new CookieClickerAlpha();
		clickerAlpha.read();
		for (int i = 0; i < clickerAlpha.cases; i++) {
			String out = "Case #" + (i + 1) + ": ";
			out += clickerAlpha.list.get(i).solver();
			System.out.println(out);
		}
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2014/B.in";
		try {
			dFileReader = new FileReader(new File(urlString));
			br = new BufferedReader(dFileReader);
			String s = null;
			s = br.readLine();
			cases = Integer.valueOf(s);
			for (int i = 0; i < cases; i++) {
				double C, F, X;
				s = br.readLine();
				String[] strings = s.split(" ");
				C = Double.valueOf(strings[0]);
				F = Double.valueOf(strings[1]);
				X = Double.valueOf(strings[2]);
				// System.out.println(C+" "+F+" "+X+" ");
				GameB gameB = new GameB(C, F, X);
				list.add(gameB);
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

class GameB {
	private double C;
	private double F;
	private double X;
	private final double init = 2;

	public GameB(double C, double F, double X) {
		this.C = C;
		this.F = F;
		this.X = X;
	}

	public double solver() {
		double cost = Double.MAX_VALUE;
		for (int i = 0; i <= X / C; i++) {
			double tmp = solver(i);
			if (cost > tmp)
				cost = tmp;
		}
		return cost;
	}

	private double solver(int farm) {
		double cost = 0;
		double current = init;
		for (int i = 0; i < farm; i++) {
			cost += C / current;
			current += F;
		}
		cost += X / current;
		return cost;
	}
}
