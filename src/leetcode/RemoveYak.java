package leetcode;

public class RemoveYak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringYak("yayakkzz"));
	}

	/*
	 * Suppose the string "yak" is unlucky. Given a string, return a version
	 * where all the "yak" are removed, but the "a" can be any char. The "yak"
	 * strings will not overlap. 
	 * stringYak("yakpak") → "pak" 
	 * stringYak("pakyak") → "pak" 
	 * stringYak("yak123ya") → "123ya"
	 */
	public static String stringYak(String s) {
		if (s.length() < 3)
			return s;
		if (s.equals("yak"))
			return "";
		int index = s.indexOf("yak");
		if (index == -1)
			return s;
		else {
			String newString = s.substring(0, index) + s.substring(index + 3);
			return stringYak(newString);
		}
	}
}
