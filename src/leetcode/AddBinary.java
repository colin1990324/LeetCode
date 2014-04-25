package leetcode;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	// http://oj.leetcode.com/problems/add-binary/
	public static String addBinary(String a, String b) {
		int length;
		length = a.length() > b.length() ? a.length() : b.length();
		String zeros = "";
		for (int i = 0; i < Math.abs(a.length() - b.length()); i++) {
			zeros += "0";
		}
		if (a.length() > b.length())
			b = zeros + b;
		else
			a = zeros + a;
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		boolean carry = false;
		String output = "";
		for (int i = length - 1; i >= 0; i--) {
			if (charA[i] == '0' && charB[i] == '0' && carry == true) {
				output = "1" + output;
				carry = false;
				continue;
			}
			if (charA[i] == '0' && charB[i] == '1' && carry == true) {
				output = "0" + output;
				carry = true;
				continue;
			}
			if (charA[i] == '1' && charB[i] == '0' && carry == true) {
				output = "0" + output;
				carry = true;
				continue;
			}
			if (charA[i] == '1' && charB[i] == '1' && carry == true) {
				output = "1" + output;
				carry = true;
				continue;
			}
			if (charA[i] == '0' && charB[i] == '0' && carry == false) {
				output = "0" + output;
				carry = false;
				continue;
			}
			if (charA[i] == '0' && charB[i] == '1' && carry == false) {
				output = "1" + output;
				carry = false;
				continue;
			}
			if (charA[i] == '1' && charB[i] == '0' && carry == false) {
				output = "1" + output;
				carry = false;
				continue;
			}
			if (charA[i] == '1' && charB[i] == '1' && carry == false) {
				output = "0" + output;
				carry = true;
				continue;
			}
		}
		if (carry == true)
			output = "1" + output;
		return output;
	}
}
