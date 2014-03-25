import java.util.HashSet;
import java.util.Iterator;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("hoo");
		String start = "hit";
		String end = "aaa";
		System.out.println(ladderLength(start, end, dict));
	}

	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		dict.add(end);
		HashSet<String> exit = new HashSet<String>();
		exit.add(start);
		int result=subLength(start, end, dict, exit);
		if(result==Integer.MAX_VALUE-1)
			return 0;
		return result;
	}

	public static int subLength(String start, String end, HashSet<String> dict,
			HashSet<String> exit) {
		int transformCounter = Integer.MAX_VALUE - 1;
		Iterator<String> iterator = getNextLocal(start, dict, exit).iterator();
		while (iterator.hasNext()) {
			String tmpString = iterator.next();
			if (tmpString.equals(end))
				return 2;
			else {
				exit.add(tmpString);
				transformCounter = Math.min(
						subLength(tmpString, end, dict, exit) + 1,
						transformCounter);
			}
		}
		return transformCounter;
	}

	// return all possible next nodes(no overlap)
	public static HashSet<String> getNext(String string, HashSet<String> dict,
			HashSet<String> exit) {
		HashSet<String> strings = new HashSet<String>();
		Iterator<String> iterator = dict.iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			if (exit.contains(tmp))
				continue;
			if (isNext(string, tmp))
				strings.add(tmp);
		}
		return strings;
	}

	// return all possible next nodes(by local transform)
	// create and delete(not in dictionary and in exit)
	public static HashSet<String> getNextLocal(String string,
			HashSet<String> dict, HashSet<String> exit) {
		HashSet<String> strings = new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			char[] s = string.toCharArray();
			// 'a'=97,'z'=122
			for (int j = 97; j < 123; j++) {
				s[i] = (char) j;
				strings.add(String.valueOf(s));
			}
		}
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			if (exit.contains(tmp)) {
				iterator.remove();
				continue;
			}
			if (!dict.contains(tmp))
				iterator.remove();
		}
		return strings;
	}

	// if string can transform to dictS, return true
	// transform means only one letter different. same length String.
	public static boolean isNext(String string, String dictS) {
		if (string.length() != dictS.length())
			return false;
		char[] charA = string.toCharArray();
		char[] charB = dictS.toCharArray();
		int counter = 0;
		for (int i = 0; i < string.length(); i++) {
			if (charA[i] != charB[i]) {
				counter++;
			}
		}
		if (counter == 1)
			return true;
		return false;
	}
}
