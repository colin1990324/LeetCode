package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SubstringWithConcatenation {

	public static void main(String[] args) {
		String s = "aaa";
		String[] l = { "a", "b" };
		ArrayList<Integer> result = findSubstring(s, l);
		Iterator<Integer> iterator = result.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}

	// https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int totleLength = 0;
		for (int i = 0; i < L.length; i++) {
			totleLength += L[i].length();
		}
		int pointer = 0;
		while (pointer + totleLength <= S.length()) {
			if (containsAll(S.substring(pointer, pointer + totleLength), L))
				result.add(pointer);
			pointer++;
		}
		return result;
	}

	public static boolean containsAll(String S, String[] L) {
		if (S.length() == 0)
			return true;
		int pointer = 0;
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, L);
		while (list.size() > 0) {
			boolean flag = false;
			for (int i = 0; i < list.size(); i++) {
				if (S.substring(pointer, pointer + list.get(i).length())
						.equals(list.get(i))) {
					pointer += list.get(i).length();
					list.remove(i);
					flag = true;
				}
			}
			if (!flag)
				return false;
		}
		return true;
	}
}
