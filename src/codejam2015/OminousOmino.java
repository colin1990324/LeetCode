package codejam2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OminousOmino {

	int cases = 0;

	public static void main(String[] args) {
		OminousOmino problem = new OminousOmino();
		problem.read();
	}

	public void read() {
		FileReader dFileReader = null;
		BufferedReader br = null;
		String urlString = "/Users/ColinMac/Documents/JavaWorkSpace/LeetCode/src/codejam2015/OminousOminoSmall.in";
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
				int X = Integer.valueOf(ss[0]);
				int R = Integer.valueOf(ss[1]);
				int C = Integer.valueOf(ss[2]);
				String result = solve(X, R, C);
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

	static String RICHARD = "RICHARD";
	static String GABRIEL = "GABRIEL";
	
	private String solve(int X, int R, int C) {
		int max = Math.max(R, C);
		int min = Math.min(R, C);
		
		if (R * C % X != 0)
			return RICHARD;	
		if(X==1 || X==2)
			return GABRIEL;
		if(X==3){
			if(min==1)
				return RICHARD;
			if(min==2)
				return GABRIEL;
			if(min==3)
				return GABRIEL;
			if(min==4)
				return RICHARD;
		}
		if(X==4){
			if(min==1)
				return RICHARD;
			if(min==2){
				if(max==2)
					return RICHARD;
				if(max==4)
					return RICHARD;
			}
			if(min==3)
				return GABRIEL;
			if(min==4)
				return GABRIEL;
		}
			
		return GABRIEL;
	}
	
}
