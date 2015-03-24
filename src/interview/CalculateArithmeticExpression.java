package interview;

import java.util.Stack;

/**
 * Input an arithmetic expression with ONLY +, -, * and /, parse the expression
 * and calculate the result. 
 * Input: 5.6 / 0.7 * 2 – 3.5 Output: 12.5 
 * Input: -1.3 + 5.1 / 3 – 0.8 Output: -0.4
 * 
 */

public class CalculateArithmeticExpression {

	public static void main(String[] args) {
		System.out.println(calculate("5.6 / 0.7 * 2 - 3.5"));
		System.out.println(calculate("-1.3 + 5.1 / 3 - 0.8"));
	}

	public static float calculate(String s) {
		s = s.replaceAll("\\s", "");
		String[] ss = s.split("[-+*\\/]");
		Stack<String> stack = new Stack<String>();
		float res;
		int index;
		int n;
		if (s.charAt(0) == '-') {
			stack.push("-" + ss[1]);
			index = 1 + ss[1].length();
			n = 2;
		} else {
			stack.push(ss[0]);
			index = ss[0].length();
			n = 1;
		}
		while (index < s.length() && n < ss.length) {
			float f = Float.valueOf(ss[n]);
			float p = Float.valueOf(stack.peek());
			if (s.charAt(index) == '+' || s.charAt(index) == '-') {
				stack.push(s.substring(index, index + 1));
				stack.push(ss[n]);
			} else if (s.charAt(index) == '*') {
				stack.pop();
				stack.push(String.valueOf(p * f));
			} else if (s.charAt(index) == '/') {
				stack.pop();
				stack.push(String.valueOf(p / f));
			}
			index += 1 + ss[n].length();
			n++;
		}
		res = Float.valueOf(stack.pop());
		while (!stack.isEmpty()) {
			String e = stack.pop();
			if (e.equals("+"))
				res += Float.valueOf(stack.pop());
			else
				res = Float.valueOf(stack.pop()) - res;
		}
		return res;
	}
}
