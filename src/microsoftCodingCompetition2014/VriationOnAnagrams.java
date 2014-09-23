package microsoftCodingCompetition2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class VriationOnAnagrams {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		while (true) {
			try {
				String s = br.readLine();
				if (s.length() == 0)
					break;
				list.add(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String s : list) {
			String[] ss = getString(s);
			if (anagram(ss[0], ss[1]))
				System.out.println("Valid Pattern");
			else
				System.out.println("Invalid Pattern");
		}
	}

	public static boolean anagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		Arrays.sort(as);
		Arrays.sort(bs);
		for (int i = 0; i < as.length; i++) {
			if (as[i] != bs[i])
				return false;
		}
		return true;
	}

	private static String[] getString(String s) {
		String[] ss = new String[2];
		int index = 1;
		s = s.toLowerCase();
		s = s.replaceAll("\\s+", "");
		index = s.indexOf("\"", index);
		ss[0] = s.substring(1, index);
		index = s.indexOf("\"", index + 1);
		ss[1] = s.substring(index + 1, s.indexOf("\"", index + 1));
		return ss;
	}
}
