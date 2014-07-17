package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("A", "A"));
	}

	public static String minWindow(String S, String T) {
		HashMap<Character, Integer> exitHashMap = new HashMap<Character, Integer>();
		// construct needed map
		HashMap<Character, Integer> neededHashMap = new HashMap<Character, Integer>();
		char[] charsT = T.toCharArray();
		for (int i = 0; i < charsT.length; i++) {
			if (neededHashMap.containsKey(charsT[i]))
				neededHashMap.put(charsT[i], neededHashMap.get(charsT[i]) + 1);
			else
				neededHashMap.put(charsT[i], 1);
		}
		char[] charsS = S.toCharArray();
		int headPointer = 0;
		int min = Integer.MAX_VALUE;
		String minString = "";
		for (int i = 0; i < charsS.length; i++) {
			char c = charsS[i];
			if (exitHashMap.containsKey(c))
				exitHashMap.put(c, exitHashMap.get(c) + 1);
			else
				exitHashMap.put(c, 1);
			if (satisfy(neededHashMap, exitHashMap)) {
				headPointer = contract(neededHashMap, exitHashMap, headPointer,
						i, S);
				if(headPointer==-1) headPointer=0;
				if (min > i - headPointer + 1) {
					min = i - headPointer + 1;
					minString = S.substring(headPointer, i + 1);
				}
			}
		}
		return minString;
	}

	private static boolean satisfy(HashMap<Character, Integer> target,
			HashMap<Character, Integer> hashMap) {
		Iterator<Entry<Character, Integer>> iterator = target.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> x = iterator.next();
			if (!hashMap.containsKey(x.getKey())
					|| x.getValue() > hashMap.get(x.getKey()))
				return false;
		}
		return true;
	}

	private static int contract(HashMap<Character, Integer> target,
			HashMap<Character, Integer> hashMap, int headPointer,
			int currentIndex, String S) {
		char[] chars = S.toCharArray();
		for (int i = headPointer; i < currentIndex; i++) {
			if (!target.containsKey(chars[i]))
				continue;
			if (hashMap.get(chars[i]) > target.get(chars[i]))
				hashMap.put(chars[i], hashMap.get(chars[i]) - 1);
			else
				return i;
		}
		return -1;
	}
	
	// http://answer.ninechapter.com/solutions/minimum-window-substring/
		public static String minWindowII(String S, String T) {
			if (S == null || S.length() == 0) {
				return S;
			}
			if (T == null || T.length() == 0) {
				return "";
			}

			HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();
			for (int i = 0; i < T.length(); i++) {
				Character c = T.charAt(i);
				if (tCounter.containsKey(c)) {
					tCounter.put(c, tCounter.get(c) + 1);
				} else {
					tCounter.put(c, 1);
				}
			}

			HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
			String minWindow = null;
			int tCount = 0, leftBound = 0;
			for (int i = 0; i < S.length(); i++) {
				Character c = S.charAt(i);
				if (!tCounter.containsKey(c)) {
					continue;
				}
				if (minWindowCounter.containsKey(c)) {
					minWindowCounter.put(c, minWindowCounter.get(c) + 1);
				} else {
					minWindowCounter.put(c, 1);
				}
				if (minWindowCounter.get(c) <= tCounter.get(c)) {
					tCount++;
				}
				if (tCount == T.length()) {
					while (leftBound < S.length()) {
						Character ch = S.charAt(leftBound);
						if (!tCounter.containsKey(ch)) {
							leftBound++;
							continue;
						}
						if (minWindowCounter.get(ch) > tCounter.get(ch)) {
							minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
							leftBound++;
							continue;
						}
						break;
					}
					if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
						minWindow = S.substring(leftBound, i + 1);
					}
				}
			}

			if (minWindow == null) {
				return "";
			}
			return minWindow;
		}
}
