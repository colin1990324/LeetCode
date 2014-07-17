package leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
        String newString = s.toLowerCase();
        newString = newString.replaceAll("[^a-zA-Z0-9]", "");
        return isPalidrome(newString);
    }
	
	public static boolean isPalidrome(String s) {
		int length = s.length();
		if (length == 1)
			return true;
		for (int i = 0; i < length / 2; i++) {
			if (s.charAt(i) != s.charAt(length - i - 1))
				return false;
		}
		return true;
	}
}
