package leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs1 = { "a", "a", "ac" };
		String[] strs2 = { "abab", "aba", "" };
		System.out.println(longestCommonPrefix(strs1));
		System.out.println(longestCommonPrefix(strs2));
	}

	public static String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if (strs.length == 0)
			return prefix;
		if (strs.length == 1)
			return strs[0];
		String s1 = strs[0];
		String s2 = strs[1];
		int l = Math.min(s1.length(), s2.length());
		int i, j;
		for (i = 0; i < l; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
		}
		prefix = s1.substring(0, i);
		for (i = 2; i < strs.length; i++) {
			for (j = 0; j < prefix.length(); j++) {
				if (strs[i].length() <= j
						|| prefix.charAt(j) != strs[i].charAt(j))
					break;
			}
			prefix = s1.substring(0, j);
		}
		return prefix;
	}
}
