package leetcode;

/**
 * http://oj.leetcode.com/problems/decode-ways/
 * 
 * @author ColinMac
 */

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inString = "101";
		System.out.println(numDecodings(inString));
	}

	public static int numDecodings(String s) {
		int length = s.length();
		if (length == 0 || s.charAt(0) == '0')
			return 0;
		int[] vector = new int[length + 1];
		vector[0] = 1;
		vector[1] = 1;
		for (int i = 2; i < vector.length; i++) {
			int v = Integer.valueOf(s.substring(i - 2, i));
			if (v <= 26) {
				if (v > 9)
					vector[i] += vector[i - 2];
				if (s.charAt(i - 1) != '0')
					vector[i] += vector[i - 1];
			} else {
				if (s.charAt(i - 1) != '0')
					vector[i] += vector[i - 1];
				else if (i != length)
					return 0;
			}
		}
		return vector[length];
	}
}
