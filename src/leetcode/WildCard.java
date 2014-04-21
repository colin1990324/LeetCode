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
		String string2 = "1?";
		String string3 = "1";
		String string4 = "?1";
		ArrayList<String> outoutArrayList = expand(string4);
		for (String s : outoutArrayList) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> expand(String s) {
		ArrayList<String> output = new ArrayList<String>();
		String[] splits = s.split("\\?");
		//empty String
		if(s.length()==0)
			return output;
		//no '?'
		if(splits.length==1 && !s.substring(s.length()-1).equals("\\?")){
			output.add(s);
			return output;
		}
		//
		int length = splits[0].length() + 1;
		helper(s.substring(length, s.length()), splits[0] + "1", output);
		helper(s.substring(length, s.length()), splits[0] + "0", output);
		return output;
	}

	public static void helper(String s, String pre, ArrayList<String> output) {
		if (s.length() == 0) {
			output.add(pre);
			return;
		}
		String[] splits = s.split("\\?");
		int length = splits[0].length();
		if (splits.length != 1) {
			length++;
			helper(s.substring(length, s.length()), pre + splits[0] + "1",
					output);
			helper(s.substring(length, s.length()), pre + splits[0] + "0",
					output);
		} else {
			helper("", pre + splits[0], output);
		}
	}

}
