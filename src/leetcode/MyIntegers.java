package leetcode;

import java.util.ArrayList;

public class MyIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("input 123, output "+reverse(123));
		// System.out.println("input -123, output "+reverse(-123));
		System.out.println(countAndSay(30));
	}
	
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		char[] code=new char[n];
		for (int i = 0; i < code.length; i++) {
			
		}
		Integer.valueOf("0101",2).toString();
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
	
	//input s can be any digits String
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
