package interview;

/**
 * Given a string, design an algorithm in O(n) running time to find the
 * character that appears more than half of the time in the string. If the
 * character does not exist, output null. 
 * Input: abadacababaaaa Output: a Input:
 * abcdeabbad Output: null
 * 
 * @author ColinMac
 */
public class HalfTimeChar {

	public static void main(String[] args) {
		System.out.println(find("abadacababaaaa"));
		System.out.println(find("abcdeabbad"));
	}

	public static Character find(String s) {
		int[] counter = new int[256];
		char[] chars = s.toCharArray();
		for (char c : chars) {
			counter[c]++;
		}
		for (int i = 0; i < 256; i++) {
			if (counter[i] > s.length() / 2)
				return new Character((char) i);
		}
		return null;
	}
}
