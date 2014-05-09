package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbc"));
	}

	// http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
	// Given a string, find the length of the longest substring without
	// repeating characters.
	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length == 0)
			return 0;
		int[] vector = new int[length];
		char[] chars = s.toCharArray();
		vector[0] = 1;
		int pointer = 0;
		for (int i = 1; i < length; i++) {
			int index = i - 1;
			while (index >= pointer && chars[index] != chars[i])
				index--;
			if (index < pointer)
				vector[i] = Math.max(i - pointer + 1, vector[i - 1]);
			else {
				vector[i] = Math.max(i - pointer, vector[i - 1]);
				pointer = index + 1;
			}
		}
		return vector[length - 1];
	}
	//Time complexity is O(nm), n is length of String, m is number of different Characters
	//when m is big, part of the while loop can be replaced by a HashMap<Character, Integer> 
	//which store the latest occurrence of a Character
}
