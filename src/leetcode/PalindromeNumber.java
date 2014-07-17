package leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1234321));
		System.out.println(isPalindrome(123321));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int length = Integer.toString(x).length();
		int value;
		if (length % 2 == 0)
			value = x;
		else {
			value = (int) (x / Math.pow(10, length / 2 + 1))
					* (int) Math.pow(10, length / 2);
			value += (int) (x % Math.pow(10, length / 2));
		}
		return value % 11 == 0;
	}
}
