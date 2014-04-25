package leetcode;

import java.util.ArrayList;

public class MyIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("input 123, output "+reverse(123));
		// System.out.println("input -123, output "+reverse(-123));
		// System.out.println(countAndSay(30));
		// System.out.println(mysqrt(5));
		// int[] a={9,9,9};
		// System.out.println(plusOne(a));
		System.out.println(climbStairs(4));
	}

	// http://oj.leetcode.com/problems/climbing-stairs/
	public static int climbStairs(int n) {
		if (n == 1)
			return 1;
		int[] counter = new int[n + 1];
		counter[1] = 1;
		counter[2] = 2;
		for (int i = 3; i < counter.length; i++) {
			counter[i] = counter[i - 1] + counter[i - 2];
		}
		return counter[n];
	}

	// http://oj.leetcode.com/problems/plus-one/
	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		if (length == 0)
			return digits;
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (carry != 1) {
				break;
			}
			if (digits[i] == 9) {
				digits[i] = 0;
				continue;
			}
			digits[i]++;
			carry = 0;
			break;
		}
		if (carry == 1) {
			int[] output = new int[length + 1];
			output[0] = 1;
			for (int i = 1; i < output.length; i++) {
				output[i] = digits[i - 1];
			}
			return output;
		}
		return digits;
	}

	// http://oj.leetcode.com/problems/sqrtx/
	public static int mysqrt(int in) {
		double g0, g1, x = in;
		if (x == 0)
			return 0;
		g0 = x / 2;
		g1 = (g0 + x / g0) / 2;
		while (Math.abs(g1 - g0) > 0.1) {
			g0 = g1;
			g1 = (g0 + (x / g0)) / 2;
		}
		return (int) Math.floor(g1);
	}

	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		char[] code = new char[n];
		for (int i = 0; i < code.length; i++) {

		}
		Integer.valueOf("0101", 2).toString();
		return result;
	}

	public static int reverse(int x) {
		boolean negative = false;
		if (x < 0) {
			negative = true;
			x *= -1;
		}
		int result = 0;
		int target = x;
		while (target >= 10) {
			result = result * 10 + target % 10;
			target = target / 10;
		}
		result = result * 10 + target;
		if (negative) {
			result *= -1;
		}
		return result;
	}

	// Given an integer n, generate the nth sequence.
	// 1 is read off as "one 1" or 11.
	// 11 is read off as "two 1s" or 21.
	// 21 is read off as "one 2, then one 1" ==> 1211.
	public static String countAndSay(int n) {
		return countAndSay(String.valueOf(1), n);
	}

	// input s can be any digits String
	public static String countAndSay(String s, int n) {
		if (n == 1)
			return s;
		char[] chars = s.toCharArray();
		String string = "";
		int index = 0;
		while (index < chars.length) {
			int count = 1;
			while (index + 1 < chars.length) {
				if (chars[index] == chars[index + 1]) {
					count++;
					index++;
				} else
					break;
			}
			string += String.valueOf(count);
			string += String.valueOf(chars[index]);
			index++;
		}
		return countAndSay(string, n - 1);
	}
}
