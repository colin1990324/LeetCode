package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
}
