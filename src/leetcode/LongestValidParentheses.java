package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
	}

	public static int longestValidParentheses(String s) {
		if (s == null) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
		int accumulatedLen = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					accumulatedLen = 0;
				} else {
					int matchedPos = stack.pop();
					int matchedLen = i - matchedPos + 1;

					if (stack.isEmpty()) {
						accumulatedLen += matchedLen;
						matchedLen = accumulatedLen;
					} else {
						matchedLen = i - stack.peek();
					}

					maxLen = Math.max(maxLen, matchedLen);
				}
			}
		}

		return maxLen;
	}
	
	//https://oj.leetcode.com/problems/valid-parentheses/
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if ("({[".contains(String.valueOf(c))) {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private boolean is_valid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
				|| (c1 == '[' && c2 == ']');
	}
}
