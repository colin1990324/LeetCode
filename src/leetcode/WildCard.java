package leetcode;

import java.util.ArrayList;
/**
 * given a String like "1?00?101"
 * replace '?' with '1' or '0'
 * get all possible outputs
 */

public class WildCard {

	public static void main(String[] args) {
		String string = "1?00?101";
		ArrayList<String> outoutArrayList = expand(string);
		for (String s : outoutArrayList) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> expand(String s) {
		ArrayList<String> output = new ArrayList<String>();
		String[] splits = s.split("\\?");
		int lenth = splits[0].length() + 1; // lengthof the first split
		helper(s.substring(lenth, s.length()), splits[0] + "1", output);
		helper(s.substring(lenth, s.length()), splits[0] + "0", output);
		return output;
	}

	public static void helper(String s, String pre, ArrayList<String> output) {
		if (s.length() == 0) {
			output.add(pre);
			return;
		}
		String[] splits = s.split("\\?");
		int lenth = splits[0].length();
		if (splits.length != 1) {
			lenth++;
			helper(s.substring(lenth, s.length()), pre + splits[0] + "1",
					output);
			helper(s.substring(lenth, s.length()), pre + splits[0] + "0",
					output);
		} else {
			helper("", pre + splits[0], output);
		}
	}

}
